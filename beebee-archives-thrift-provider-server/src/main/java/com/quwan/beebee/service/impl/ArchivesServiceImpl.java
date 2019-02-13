package com.quwan.beebee.service.impl;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.quwan.beebee.common.Constants;
import com.quwan.beebee.constant.IntegralConstant;
import com.quwan.beebee.dao.*;
import com.quwan.beebee.design.pattern.ArchivesComment;
import com.quwan.beebee.design.pattern.Context;
import com.quwan.beebee.design.pattern.ReplyComment;
import com.quwan.beebee.design.pattern.ReplyTwoComment;
import com.quwan.beebee.entity.archives.*;
import com.quwan.beebee.entity.user.User;
import com.quwan.beebee.exception.ErrorCode;
import com.quwan.beebee.meta.IntegralTypeEnum;
import com.quwan.beebee.meta.ReadLogEnum;
import com.quwan.beebee.mongo.ClientReadLog;
import com.quwan.beebee.mongo.UserIntegral;
import com.quwan.beebee.mongo.UserIntegralLog;
import com.quwan.beebee.mongo.UserReadLog;
import com.quwan.beebee.param.archives.*;
import com.quwan.beebee.param.user.SaveUserTagsParam;
import com.quwan.beebee.resp.archives.ArchivesListResp;
import com.quwan.beebee.resp.archives.ArchivesPraiseResp;
import com.quwan.beebee.resp.archives.ArchivesSortResp;
import com.quwan.beebee.resp.archives.CommentAnswersResp;
import com.quwan.beebee.resp.user.UserIntegralLogResp;
import com.quwan.beebee.service.CommonManager;
import com.quwan.beebee.service.archives.ArchivesService;
import com.quwan.beebee.utils.PageUtil;
import com.quwan.beebee.utils.Result;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.thrift.TException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;

/**
 * archives模块
 */
@Service("archivesServiceImpl")
@Transactional
public class ArchivesServiceImpl implements ArchivesService.Iface {

    @Autowired
    public ArchivesDao archivesDao;

    @Autowired
    public CommonDao commonDao;

    @Autowired
    public UserDao userDao;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Autowired
    private UserReadLogDao userReadLogDao;

    @Autowired
    private ClientReadLogDao clientReadLogDao;

    @Autowired
    private UserIntegralLogDao integralLogDao;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private UserIntegralDao integralDao;

    @Autowired
	private CommonManager commonManager;

    @Autowired
    private RedisTemplate redisTemplate;

    private static final Logger LOGGER = LoggerFactory.getLogger(ArchivesServiceImpl.class);

    /**
     * 获取所有文章分类
     * @return
     * @throws TException
     */
    @Override
    @Cacheable(value = "getArchivesSort", key = "#root.methodName", unless = "#result.contains('Successful') eq false")
    public String getArchivesSort() throws TException {
        List<ArchivesSortResp> list = archivesDao.getArchivesSort();
        return JSON.toJSONString(Result.okList(1, list.size(), list.size(), list));
    }

    /**
     * 首页获取文章列表接口 单数据源
     *
     * @param param
     * @return
     */
    @Override
    @Cacheable(value = "queryArchivesList", key = "#root.methodName + '-' + #param.hashCode()", unless = "#result.contains('Successful') eq false")
    public String queryArchivesList(ArchivesListParam param) {
        Integer index = PageUtil.convertIndex(param.getPageNumber(), param.getPageSize());
        param.setPageNumber(index);
        List<ArchivesListResp> archivesList = null;
        int total = 0;
        try {
            archivesList = archivesDao.queryArchivesList(param);
            total = archivesDao.queryArchivesTotal(param);
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error("server.ip: "+ Constants.serverIpAddress +", com.quwan.beebee.service.impl.ArchivesServiceImpl queryArchivesList error", e);
            return JSON.toJSONString(Result.response(ErrorCode.ServerError));
        }
        Result result = Result.okList(param.getPageNumber(), param.getPageSize(), total, archivesList);
        return JSON.toJSONString(result);
    }

    /**
     *  获取评论列表-按照排序算法
     * @param param
     * @return
     */
    @Override
    public String getArchivesList(ArchivesListParam param) {
        Integer index = PageUtil.convertIndex(param.getPageNumber(), param.getPageSize());
        param.setPageNumber(index);
        List<ArchivesListResp> archivesList = null;
        int total = 0;
        try {
            archivesList = archivesDao.getArchivesList(param);
            total = archivesDao.getArchivesTotal(param);
            if (CollectionUtils.isEmpty(archivesList)) {
                return queryArchivesList(param);
            }
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error("server.ip: "+ Constants.serverIpAddress +", com.quwan.beebee.service.impl.ArchivesServiceImpl queryArchivesList error", e);
            return queryArchivesList(param);
        }
        Result result = Result.okList(param.getPageNumber(), param.getPageSize(), total, archivesList);
        return JSON.toJSONString(result);
    }

    /**
     * @param param
     * @Description: 文章详情页
     * @author 李静
     * @date 2018年1月4日 上午11:37:50
     */
    @Override
    @Cacheable(value = "getArchivesContent", key = "#root.methodName + '-' + #param.getId()", unless = "#result eq null")
    public String getArchivesContent(ArchivesContentParam param) {

        // 1 校验参数
        if (param.getId() <= 0) {
            return JSON.toJSONString(Result.response(ErrorCode.ServerError));
        }

        // 2 判断文章是否为空
        Archives archive = archivesDao.getArchiveById(param.getId());
        if (archive == null) {
            return JSON.toJSONString(Result.response(ErrorCode.NOThisArchive));
        }

        return archive.getContent();
    }

    /**
     * 读取文章后，更新用户行为
     * @param param
     * @throws TException
     */
    @Override
    public String updateUserBehavior(ArchivesContentParam param) throws TException  {

        // 设置用户已阅读文章的id
        setReadUserId(param);

        // 1 更新文章点击数
        archivesDao.updateClickCount(param);

        // 2 把此文章标签更新到用户标签表里（相关推荐可能用）
        setUserTags(param.getUserId(), param.getId());

        // 3 每日阅读加花朵（已登陆用户 打开任意遛遛、哔哔投、哔哔说内页记为一次阅读，相同内容多次打开记一次阅读，
        // 用户每天阅读三次完成“每日阅读“获得相应的奖励，每个用户一天只能获得一次”每日阅读“奖励）
        commonManager.sendIntegral(param.getUserId(), IntegralTypeEnum.READ_3, IntegralConstant.READ_3_NUM);

        // 4 添加阅读日志
        addUserReadLog(param);

        return JSON.toJSONString(Result.success());
    }

    /**
     * 设置已阅读用户的id
     * @param param
     */
    private void setReadUserId(ArchivesContentParam param) {
        Archives archive = archivesDao.getArchiveById(param.getId());
        if (archive == null) {
            return;
        }
        String readUserId = StringUtils.EMPTY;
        if (param.getUserId() > 0) {
            if (StringUtils.isEmpty(archive.getReadUserId())) {
                readUserId = String.valueOf(param.getUserId());
            } else {
                readUserId = archive.getReadUserId() + "," + String.valueOf(param.getUserId());
            }
            param.setReadUserId(readUserId);
        } else {
            param.setReadUserId(archive.getReadUserId());
        }

    }

    /**
     * 添加用户阅读日志和客户端日志（阅读时长等字段）
     * @param param
     */
    private void addUserReadLog(ArchivesContentParam param) {

        // 1 添加用户阅读日志
        UserReadLog userReadLog = new UserReadLog(param.getUserId(), ReadLogEnum.TYPE_ARCHIVE.code, param.getId());
        userReadLogDao.insert(userReadLog);

        // 2 增加客户端初始阅读记录
        if (StringUtils.isEmpty(param.getDeviceId())) {
            return ;
        }
        ClientReadLog clientReadLog = new ClientReadLog(param.getId(), param.getUserId(), ReadLogEnum.TYPE_ARCHIVE.code, param.getDeviceId(), param.getDeviceType());
        clientReadLogDao.insert(clientReadLog);
    }

    /**
     * 把此文章标签 更新到用户标签表里  @李静
     * @param userId
     * @param archId
     */
    private void setUserTags(int userId, int archId) {
        List<ArchivesTag> tags = archivesDao.getArchivesTagsById(archId);
        if (CollectionUtils.isEmpty(tags)) {
            return;
        }

        List<SaveUserTagsParam> paramList = Lists.newArrayList();
        SaveUserTagsParam param = null;
        String now = DateFormatUtils.format(System.currentTimeMillis(), Constants.FORMAT_DATETIME);
        for (ArchivesTag tag : tags) {
            param = new SaveUserTagsParam();
            param.setUserId(userId);
            param.setTag(tag.getTag());
            param.setModifyTime(now);
            paramList.add(param);
        }
        archivesDao.saveUserTags(paramList);
    }

    /**
     * 回复评论接口
     *
     * @param param
     * @return
     * @throws TException
     */
    @Override
    public String answerComment(AnswerParam param) throws TException {
        param.setAnswerTime(DateFormatUtils.format(System.currentTimeMillis(),
                Constants.FORMAT_DATETIME));
        try {
            archivesDao.answerComment(param);
            archivesDao.updateArchivesComment(param);
            
            // 添加积分-陈晓婵-2018年1月9日15:36:27
            // 1.判断今天是否对文章评论userIdAnswer
            int archivesCommentCount = archivesDao.getArchivesCommentCount(param.getUserIdAnswer());
           
            // 2.判断今天是否对哔哔投和哔哔说评论
            int topicCommentCount = archivesDao.getTopicCommentCount(param.getUserIdAnswer());
            
            // 3.判断今天是否回复别人的评论
            int commentAnswer = archivesDao.getCommentAnswer(param.getUserIdAnswer());
            
            // 4.如果参与了评论/回复,获得一次“评论1次”3朵花朵的奖励
            int totalCount = 0;
            totalCount = archivesCommentCount + topicCommentCount
                    + commentAnswer;
            if (totalCount != 1) {
                return JSON.toJSONString(Result.success());
            }
           
            // 4.1 如果totalCount==1,说明没有评论过哔哔或者回复过评论
            // 往T_IntegralLog中添加积分日志
            insertInteLog(3, "评论", 4, "评论获得花朵", param.getUserIdAnswer());
           
            // 4.2 往T_Loyalty中添加评论1次的日志
            //loyaltyService.update(param.getUserIdAnswer(),IntegralTypeEnum.COMMENT.code, null, 0);
            
            // 4.3 往T_Integral中更新用户的积分
            List<UserIntegral> findByUserId = integralDao.findByUserId(param
                    .getUserIdAnswer());
            if (findByUserId == null || findByUserId.size() <= 0) {
                return JSON.toJSONString(Result.response(ErrorCode.ArchivesParamNull));
            }
            updateUserIntegral(3, findByUserId);
           
            // mysql中添加积分
            insertUserInteLog(3, IntegralTypeEnum.SHARE.code, IntegralTypeEnum.SHARE.message,
                    "分享获得花朵", 0, param.getUserIdAnswer());
            return JSON.toJSONString(Result.success());
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error("server.ip: "+ Constants.serverIpAddress +", com.quwan.beebee.service.impl.ArchivesServiceImpl answerComment error", e);
            return JSON.toJSONString(Result.response(ErrorCode.ServerError));
        }
    }

    /**
     * 查询文章评论和回复，两者合并
     *
     * @param param
     * @return
     * @throws TException
     */
    @Override
//    @Cacheable(value = "getCommentList", key = "#root.methodName + '-' + #param.hashCode()", unless = "#result.contains('Successful') eq false")
    public String getCommentList(CommentListParam param) throws TException {
        Integer index = PageUtil.convertIndex(param.getPageNumber(), param.getPageSize());
        param.setPageNumber(index);
        List<CommentAnswersResp> commentList = Lists.newArrayList();
        List<CommentAnswersResp> answerList = Lists.newArrayList();
        List<CommentAnswersResp> list = Lists.newArrayList();
        int total = 0;
        try {

            List<Integer> userIds = param.getArchId() > 0 ? commonDao.getBLacklist(param.getUserId()) : null;
            commentList = archivesDao.getComments(param, userIds);
            answerList = archivesDao.getAnswers(param, userIds);
            commentList.addAll(answerList);
            commentList.sort(new Comparator() {
                @Override
                public int compare(Object o1, Object o2) {
                    CommentAnswersResp obj1 = (CommentAnswersResp) o1;
                    CommentAnswersResp obj2 = (CommentAnswersResp) o2;
                    return obj2.getAddTime().compareTo(obj1.getAddTime());
                }
            });
            total = archivesDao.getCommentListTotal(param, userIds);
            if(index > total){
                return JSON.toJSONString(Result.response(ErrorCode.NoMoreComments));
            }
            if (!CollectionUtils.isEmpty(commentList)) {
                int pageSize = param.getPageSize() * (index + 1);
                list = commentList.subList(param.getPageNumber(), commentList.size() < pageSize ? commentList.size() : pageSize);
            }
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error("server.ip: "+ Constants.serverIpAddress +", com.quwan.beebee.service.impl.ArchivesServiceImpl getCommentList error", e);
            return JSON.toJSONString(Result.response(ErrorCode.ServerError));
        }
        Result result = Result.okList(param.getPageNumber(), param.getPageSize(), total, list);
        return JSON.toJSONString(result);
    }

    /**
     * 文章阅读完成、未完成
     * 李静
     *
     * @param param
     * @return
     * @throws TException
     */
    @Override
    public String updateArchivesReadStatus(ArchivesReadParam param) throws TException {
        int num = 0;
        try {
            int archId = param.getArchId();
            archivesDao.updateArchivesReadStatusNum(archId, param.getStatus());
            Integer id = archivesDao.getLastUnreadIdByCondition(param.getDeviceId(), param.getDeviceType(), archId);
            if (id != null) {
                num = archivesDao.updateClientReadLog(id, param);
            }
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error("server.ip: "+ Constants.serverIpAddress +", com.quwan.beebee.service.impl.ArchivesServiceImpl updateArchivesReadStaus error", e);
            return JSON.toJSONString(Result.response(ErrorCode.ServerError));
        }
        Result okObject = Result.okObject(num);
        return JSON.toJSONString(okObject);
    }

    /**
     * @param param
     * @return String
     * @Title: isCollection
     * @Description: 文章是否收藏 1：是，0：否
     * @author lijing
     * @date 2017年12月25日 下午5:35:10
     */
    @Override
    public String isCollection(ArchivesUserParam param) throws TException {
        int num = 0;
        try {
            num = archivesDao.isCollection(param);
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error("server.ip: "+ Constants.serverIpAddress +", com.quwan.beebee.service.impl.ArchivesServiceImpl isCollection error", e);
            return JSON.toJSONString(Result.response(ErrorCode.ServerError));
        }
        Result okObject = Result.okObject(num);
        return JSON.toJSONString(okObject);
    }

    /**
     * 收藏
     *
     * @param param
     * @return
     * @throws TException
     */
    @Override
    public String collect(ArchivesCollectionParam param) throws TException {
        int num = 0;
        try {
            int i = archivesDao.hasCollection(param);

            // 修改收藏
            if (i > 0) {
                param.setModTime(DateFormatUtils.format(System.currentTimeMillis(), Constants.FORMAT_DATETIME));
                num = archivesDao.updateCollection(param);
            } else {

                // 添加收藏
                num = archivesDao.addCollection(param);
            }

            // 同步文章表收藏数量
            archivesDao.syncArchiveCollectionCount(param.getArchId());

            // 同步用户表收藏数量
            archivesDao.syncUserCollectionCount(param.getUserId());
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error("server.ip: "+ Constants.serverIpAddress +", com.quwan.beebee.service.impl.ArchivesServiceImpl collect error", e);
            return JSON.toJSONString(Result.response(ErrorCode.ServerError));
        }
        return JSON.toJSONString(Result.okObject(num));
    }

    /**
     * 文章是否点赞 1：是，0：否
     * 李静
     *
     * @param param
     * @return
     * @throws TException
     */
    @Override
    public String isPraise(ArchivesUserParam param) throws TException {

        if(param.getArchId() <= 0 || param.getUserId() <= 0){
            return JSON.toJSONString(Result.response(ErrorCode.ArchivesParamNull));
        }

        int num = 0;
        try {
            num = archivesDao.isPraise(param);
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error("server.ip: "+ Constants.serverIpAddress +", com.quwan.beebee.service.impl.ArchivesServiceImpl isPraise error", e);
            return JSON.toJSONString(Result.response(ErrorCode.ServerError));
        }
        Result okObject = Result.okObject(num);
        return JSON.toJSONString(okObject);
    }

    /**
     * 点赞
     * 何飞达
     *
     * @param param
     * @return
     * @throws TException
     */
    @Override
    public String praise(ArchivesPraiseParam param) throws TException {

        if(param.getArchId() <= 0 || param.getUserId() <= 0 || param.getDeviceType() <= 0 || param.getDeviceId() == null) {
            return JSON.toJSONString(Result.response(ErrorCode.ArchivesParamNull));
        }

        ArchivesPraiseResp archivesPraiseResp = null;
        Integer result = null;
        try {
            archivesPraiseResp = archivesDao.getArchivesPraise(param);
            if (archivesPraiseResp == null) {
                result = archivesDao.addArchivesPraise(param);
            } else {
                if(param.getValid() == archivesPraiseResp.getValid()){
                    return JSON.toJSONString(Result.response(ErrorCode.InsertFail));
                }
                result = archivesDao.updateArchivesPraise(param);
            }
            archivesDao.syncArchivePraiseCount(param.getArchId());
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error("server.ip: "+ Constants.serverIpAddress +", com.quwan.beebee.service.impl.ArchivesServiceImpl praise error", e);
            return JSON.toJSONString(Result.response(ErrorCode.ServerError));
        }
        return JSON.toJSONString(Result.okObject(result));
    }

    /**
     * 举报文章
     * 李静
     *
     * @param param
     * @return
     * @throws TException
     */
    @Override
    public String addComplain(ArchivesComplainParam param) throws TException {
        int num = 0;
        try {
            num = archivesDao.addComplain(param);
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error("server.ip: "+ Constants.serverIpAddress +", com.quwan.beebee.service.impl.ArchivesServiceImpl addComplain error", e);
            return JSON.toJSONString(Result.response(ErrorCode.ServerError));
        }
        return JSON.toJSONString(Result.okObject(num));
    }

    /**
     * 添加分享记录
     * 李静
     *
     * @param param
     * @return
     * @throws TException
     */
    @Override
    public String addShare(ArchivesShareParam param) throws TException {
        int num = 0;
        int userId = param.getUserId();
        int archId = param.getArchId();
        int archiShareCount = archivesDao.getArchiShareCount(userId);
        int topicShareCount = archivesDao.getTopicShareCount(userId);

        // 当天分享的活动和文章数量
        int totalShareCount = archiShareCount + topicShareCount;
        try {

            // 添加转发记录
            num = archivesDao.addShare(param);
            archivesDao.syncUserShareCount(userId, totalShareCount);
            if (archId != 0) {

                // 修改 bb_archives表 文章转发数量 relay 和 bb_user表 用户转发数量 relay
                archivesDao.syncArchiveShareCount(archId);
            }

            // 添加转发活动记录
            int addShareTopic = 0;
            if (param.getTopicId() != 0) {
                addShareTopic = archivesDao.addShareTopic(param);
                archivesDao.syncUserShareCount(userId, totalShareCount);
            }
            int shareNum = addShareTopic + num;

            // 增加花朵-陈晓婵-2018年1月6日13:19:05
            // 查询user表的转发条数是否大于5
            int relayByUserId = archivesDao.getRelayByUserId(userId);

            // 如果大于5,不再增加花朵
            if (relayByUserId > 5) {
                return JSON.toJSONString(Result.okObject(num));

            }
            if(userId != 0){
            	//loyaltyService.update(userId, IntegralTypeEnum.SHARE.code, "(" + shareNum + "/5)*2朵花朵", 0);
            }
            
            // 添加积分日志
            insertInteLog(2, "分享(每天)", IntegralTypeEnum.SHARE.code, "分享获得花朵", userId);

            // 更新积分表
            List<UserIntegral> findByUserIdIntegral = integralDao.findByUserId(userId);
            if (CollectionUtils.isEmpty(findByUserIdIntegral)) {
                return JSON.toJSONString(Result.response(ErrorCode.ArchivesParamNull));
            }
            updateUserIntegral(2, findByUserIdIntegral);

            // mysql中添加积分
            insertUserInteLog(2, IntegralTypeEnum.SHARE.code, IntegralTypeEnum.SHARE.message, "分享获得花朵", 0, param.getUserId());
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error("server.ip: "+ Constants.serverIpAddress +", com.quwan.beebee.service.impl.ArchivesServiceImpl addShare error", e);
            return JSON.toJSONString(Result.response(ErrorCode.ServerError));
        }

        return JSON.toJSONString(Result.okObject(num));
    }

    /**
     * 推荐文章
     * 何飞达
     *
     * @param param
     * @return
     * @throws TException
     */
    @Override
    public String pushArchivesList(ArchivesPushParam param) throws TException {
        List<ArchivesListResp> archivesList = null;
        try {
            archivesList = archivesDao.pushArchivesList(param);
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error("server.ip: "+ Constants.serverIpAddress +", com.quwan.beebee.service.impl.ArchivesServiceImpl pushArchivesList error", e);
            return JSON.toJSONString(Result.response(ErrorCode.ServerError));
        }
        return JSON.toJSONString(Result.okObject(archivesList));
    }

    /**
     * 张植富
     * 文章评论(0:文章 1：评论 2：回复)
     * @param param
     * @return
     */
    @Override
    public String addComment(ArchivesCommentParam param) {
        String response = checkParam(param);
        if (response != null) {
            return response;
        }

        Context context = null;
        switch (param.getDeviceType()) {
            case 0:
                context = new Context(new ArchivesComment());
                break;
            case 1:
                context = new Context(new ReplyComment());
                break;
            case 2:
                context = new Context(new ReplyTwoComment());
                break;
        }

        String execute = StringUtils.EMPTY;

        try {
            execute = context.execute(param, archivesDao);
        } catch (Exception e) {
            LOGGER.error("server.ip: " + Constants.serverIpAddress + ", com.beebee.tracing.service.impl.ArchivesServiceImpl archivesComment error", e);
        }

        return execute;
    }

    private String checkParam(ArchivesCommentParam param) {
        int type = param.getDeviceType();
        if(type != 0 && type != 1 && type != 2){
            return JSON.toJSONString(Result.response(ErrorCode.UserParamIsError));
        }

        User user = userDao.getDetail(param.getUserId());
        if (user == null) {
            return JSON.toJSONString(Result.response(ErrorCode.ServerError));
        }

        return null;
    }

//    /**
//     * 添加评论
//     *
//     * @param param
//     * @return
//     * @throws TException
//     */
//    @Override
//    public String addComment(ArchivesCommentParam param) throws TException {
//        Integer num = 0;
//        String archId = param.getArchId();
//        Integer userId = param.getUserId();
//        String content = param.getContent();
//        if (archId == null || userId == null || content == null) {
//            return JSON.toJSONString(Result.response(ErrorCode.ArchivesParamNull));
//        }
//
//        try {
//            // 添加评论
//            num = archivesDao.addComment(param);
//            if (num == null) {
//                return JSON.toJSONString(Result.response(ErrorCode.InsertFail));
//            }
//
//            // 修改评论数量
//            if (archId != null) {
//                archivesDao.syncCommentCount(Integer.parseInt(archId));
//            }
//            // 修改用户评论数量
//            archivesDao.syncUserCommentCount(userId);
//
//            // 1.判断今天是否对文章评论
//            int archivesCommentCount = archivesDao.getArchivesCommentCount(userId);
//
//            // 2.判断今天是否对哔哔投和哔哔说评论
//            int topicCommentCount = archivesDao.getTopicCommentCount(userId);
//
//            // 3.判断今天是否回复别人的评论
//            int commentAnswer = archivesDao.getCommentAnswer(userId);
//
//            // 4.如果参与了评论/回复,获得一次“评论1次”3朵花朵的奖励
//            int totalCount = 0;
//            totalCount = archivesCommentCount + topicCommentCount + commentAnswer;
//            if (totalCount != 1) {
//                return JSON.toJSONString(Result.success());
//            }
//
//            // 4.1 如果totalCount==1,说明没有评论过哔哔或者回复过评论，往T_IntegralLog中添加积分日志
//            insertInteLog(3, "评论", 4, "评论获得花朵", userId);
//
//            // 4.2 往T_Loyalty中添加评论1次的日志
//            //loyaltyService.update(userId, IntegralTypeEnum.COMMENT.code, null, 0);
//
//            // 4.3 往T_Integral中更新用户的积分
//            List<UserIntegral> findByUserId = integralDao.findByUserId(userId);
//            if (findByUserId == null || findByUserId.size() <= 0) {
//                return JSON.toJSONString(Result.response(ErrorCode.ArchivesParamNull));
//            }
//            updateUserIntegral(3, findByUserId);
//
//            // 4.4 myseql中添加积分
//            insertUserInteLog(3, IntegralTypeEnum.COMMENT.code, IntegralTypeEnum.COMMENT.message,
//                    "评论获得花朵", 0, param.getUserId());
//            return JSON.toJSONString(Result.success());
//        } catch (Exception e) {
//            e.printStackTrace();
//            LOGGER.error(
//                    "server.ip: "+ Constants.serverIpAddress +", com.quwan.beebee.service.impl.ArchivesServiceImpl addComment error",
//                    e);
//            return JSON.toJSONString(Result.response(ErrorCode.UserIsNotExist));
//        }
//    }


    /**
     * 添加积分日志
     *
     * @param integral
     * @param title
     * @param type
     * @param typeDesc
     * @param userId
     */
    private void insertInteLog(int integral, String title, int type, String typeDesc, int userId) {
        UserIntegralLog integralLog = new UserIntegralLog();
        integralLog.setAddTime(DateFormatUtils.format(
                System.currentTimeMillis(), Constants.FORMAT_DATETIME));
        integralLog.setIntegral(integral);
        integralLog.setTitle(title);
        integralLog.setType(type);
        integralLog.setTypeDesc(typeDesc);
        integralLog.setUserId(userId);
        integralLogDao.insert(integralLog);
    }

    /**
     * 更新用户积分
     *
     * @param num
     * @param findByUserId
     */
    private void updateUserIntegral(int num, List<UserIntegral> findByUserId) {
        int totalNum = 0;
        Update update = new Update();
        UserIntegral integral = findByUserId.get(0);
        Integer totalIntegral = integral.getIntegral();
        totalNum = totalIntegral + num;
        integral.setIntegral(totalNum);
        update.set("integral", totalNum);
        mongoTemplate.updateFirst(
                Query.query(Criteria.where("_id").is(
                        integral.getId())), update, UserIntegral.class);
    }

    /**
     * mysql中添加积分记录
     *
     * @param integralNum
     * @param type
     * @param title
     * @param typeDesc
     * @param typeId
     * @param userId
     */
    private void insertUserInteLog(int integralNum, int type, String title, String typeDesc, int typeId, int userId) {
        UserIntegralLogResp registerParam = new UserIntegralLogResp();
        registerParam.setIntegral(integralNum);
        registerParam.setType(type);
        registerParam.setTitle(title);
        registerParam.setTypeDesc(typeDesc);
        registerParam.setTypeId(typeId);
        registerParam.setUserId(userId);
        insertIntegralLog(registerParam);
    }

    /**
     * mysql中添加积分日志-陈晓婵-2018年1月17日21:15:49
     *
     * @param param
     * @return
     */
    public int insertIntegralLog(UserIntegralLogResp param) {
        int insertIntegralLog = archivesDao.insertIntegralLog(param);
        return insertIntegralLog;
    }

    // -----------------------------------------------------------------------------------------------------------------

    public void recordUserBehavior(List<UserBehavior> list) {
        archivesDao.recordUserBehavior(list);
    }

    /**
     * 记录用户行为，请求kafka
     */
    private void recordUserBehavior(List<Integer> ids, ArchivesListParam param) {

        ServiceInstance serviceInstance = this.loadBalancerClient.choose("beebee-kafka-provider");

        List<UserBehavior> lists = Lists.newArrayList();
        for (Integer id : ids) {
            UserBehavior userBehavior = new UserBehavior();
//            userBehavior.setUserId(String.valueOf(param.getUserId()));
            userBehavior.setActObj(String.valueOf(id));
            userBehavior.setObjType("item");
            userBehavior.setBhvType("view");
            userBehavior.setBhvAmt(0.0);
            userBehavior.setBhvCnt(1.0);
            userBehavior.setBhvDateTime(DateFormatUtils.format(System.currentTimeMillis(), Constants.FORMAT_DATETIME));
            lists.add(userBehavior);
        }

        this.restTemplate.postForObject("http://" + serviceInstance.getServiceId() + "/send/recordUserBehavior", lists, String.class);
    }

    /**
     * 处理collection
     *
     * @param executor
     * @param archivesList
     * @param ids
     */
    private void handleCollection(ExecutorService executor, List<Archives> archivesList, List<Integer> ids) {

        // 1 根据文章id，查询ArchivesCollection
        CompletableFuture<List<ArchivesCollection>> result1 =
                CompletableFuture.supplyAsync(() -> archivesDao.queryCollectionListByIds(ids), executor);

        // 2 处理ArchivesCollection
        result1.thenAcceptAsync(archivesCollections -> {
            if (CollectionUtils.isEmpty(archivesCollections)) {
                return;
            }

            for (ArchivesCollection archivesCollection : archivesCollections) {
                for (Archives archives : archivesList) {
                    if (Integer.valueOf(archives.getId()).compareTo(archivesCollection.getArchId()) == 0) {
                        archives.setAddtime(archivesCollection.getAddtime());
                        archives.setAdduserid(archivesCollection.getUserId());
                        archives.setPubtime(archivesCollection.getModtime());
                    }
                }
            }
        }, executor);
    }

    /**
     * 处理tag
     *
     * @param executor
     * @param archivesList
     * @param ids
     */
    private void handleTag(ExecutorService executor, List<Archives> archivesList, List<Integer> ids) {

        // 1 根据文章id，查询taglist
        CompletableFuture<List<Tag>> result2 =
                CompletableFuture.supplyAsync(() -> archivesDao.queryTagListByIds(ids), executor);

        // 2 处理taglist
        result2.thenAcceptAsync(tagList -> {
            if (CollectionUtils.isEmpty(tagList)) {
                return;
            }

            for (Tag tag : tagList) {
                for (Archives archives : archivesList) {
                    if (Integer.valueOf(tag.getId()).compareTo(archives.getId()) == 0) {
                        archives.setCat1(tag.getCat1());
                        archives.setTags(tag.getTags());
                    }
                }
            }
        }, executor);
    }

    /**
     * list转ids
     *
     * @param list
     * @return
     */
    private List<Integer> getIds(List<Archives> list) {
        List<Integer> ids = Lists.newArrayList();
        for (Archives archives : list) {
            ids.add(archives.getId());
        }
        return ids;
    }

    /**
     * 多数据源
     * 根据第一个查询结果的文章id
     * @return

     @Override public String queryArchivesList(ArchivesListParam param) {
     LOGGER.info(param.toString());

     Integer index = PageUtil.convertIndex(param.getPageNumber(), param.getPageSize());
     param.setPageNumber(index);

     ExecutorService executor = Executors.newFixedThreadPool(2);
     List<Archives> archivesList = null;
     int total = 0;
     try {
     // 1 查询主库
     archivesList = archivesDao.queryArchivesList(param);

     // 2 提取文章id
     List<Integer> ids = getIds(archivesList);

     // 3 查询tag相关
     handleTag(executor, archivesList, ids);

     // 4 查询收藏相关
     handleCollection(executor, archivesList, ids);

     // 5 记录用户行为
     // recordUserBehavior(ids, param);
     total = archivesDao.queryArchivesTotal(param);
     } catch (Exception e) {
     e.printStackTrace();
     LOGGER.error("Unexpected exception", e);
     return JSON.toJSONString(Result.response(ErrorCode.ServerError));
     }

     Result result = Result.okList(param.getPageNumber(), param.getPageSize(), total, archivesList);
     return JSON.toJSONString(result);
     }
     */
}

package com.quwan.beebee.service.impl;

import java.util.*;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.quwan.beebee.dao.*;
import com.quwan.beebee.param.topic.*;
import com.quwan.beebee.resp.topic.*;
import com.quwan.beebee.resp.user.UserCommentResp;
import com.quwan.beebee.service.topic.TopicService;

import org.apache.commons.collections.ListUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.thrift.TException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.quwan.beebee.common.Constants;
import com.quwan.beebee.constant.IntegralConstant;
import com.quwan.beebee.entity.topic.TopicComment;
import com.quwan.beebee.entity.user.UserIdentity;
import com.quwan.beebee.exception.ErrorCode;
import com.quwan.beebee.meta.IntegralTypeEnum;
import com.quwan.beebee.meta.ReadLogEnum;
import com.quwan.beebee.meta.TopicTypeEnum;
import com.quwan.beebee.mongo.UserIntegral;
import com.quwan.beebee.mongo.UserIntegralLog;
import com.quwan.beebee.mongo.Loyalty;
import com.quwan.beebee.mongo.UserReadLog;
import com.quwan.beebee.service.CommonManager;
import com.quwan.beebee.utils.PageUtil;
import com.quwan.beebee.utils.Result;
import org.springframework.util.CollectionUtils;

/**
 * archives模块
 */
@Service("topicServiceImpl")
@Transactional
public class TopicServiceImpl implements TopicService.Iface {

    @Autowired
    public CommonDao commonDao;

    @Autowired
    public TopicDao topicDao;
    
    @Autowired
	public UserDao userDao;
    
    @Autowired
    private UserIntegralLogDao integralLogDao;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private UserIntegralDao integralDao;

    @Autowired
    private UserReadLogDao userReadLogDao;

    @Autowired
	private CommonManager commonManager;
    
    private static final Logger LOGGER = LoggerFactory.getLogger(TopicServiceImpl.class);

    /**
     * 哔哔首页获取列表 1 = 最新，2 = 最热
     * 何飞达
     * @param param
     * @return
     * @throws TException
     */
    @Override
    @Cacheable(value = "getList", key = "#root.methodName + '-' + #param.getType() + '-' + #param.getSortType() + '-' + #param.getPageSize() + '-' + #param.getPageNumber()", unless = "#result.contains('Successful') eq false")
    public String getList(TopicListParam param) throws TException {
        Integer index = PageUtil.convertIndex(param.getPageNumber(), param.getPageSize());
        param.setPageNumber(index);
        List<TopicResp> topicList = null;
        int total = 0;
        try {
            List<Integer> userIds = param.getUserId() > 0 ? commonDao.getBLacklist(param.getUserId()) : null;
            topicList = topicDao.queryTopicList(param, userIds);
            total = topicDao.queryTopicTotal(param, userIds);
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error("com.quwan.beebee.service.impl.TopicServiceImpl.getList exception", e);
            return JSON.toJSONString(Result.response(ErrorCode.ServerError));
        }

        Result result = Result.okList(param.getPageNumber(), param.getPageSize(), total, topicList);
        return JSON.toJSONString(result);
    }

    /**
     * 获取活动详情
     * 何飞达
     * @param param
     * @return
     * @throws TException
     */
    @Override
    @Cacheable(value = "getDetail", key = "#root.methodName + '-' + #param.getTopicId()", unless = "#result.contains('Successful') eq false")
    public String getDetail(TopicDetailParam param) throws TException {
        TopicDetailResp topic = null;

        try {

        	//1、查询活动详情
            topic = topicDao.getDetail(param);
            if(topic == null) {
                return JSON.toJSONString(Result.response(ErrorCode.FailedObtainDetails));
            }

            List<TopicVoteOptionResp> respList = topicDao.getVoteOption(param);
            if(respList == null){
                return JSON.toJSONString(Result.response(ErrorCode.FailedObtainDetails));
            }
            topic.setOptions(respList);

            //2、增加用户阅读记录到MongoDB   @李静
            if(param.getUserId() > 0){
    			UserReadLog readLog =new UserReadLog();
    			readLog.setUserId(param.getUserId());
    			readLog.setType(ReadLogEnum.TYPE_TOPIC.code);
    			readLog.setTopicId(param.getTopicId());
    			readLog.setAddTime(DateFormatUtils.format(System.currentTimeMillis(), Constants.FORMAT_DATETIME));
    			userReadLogDao.insert(readLog);

    			//3、每日阅读加花朵（已登陆用户 打开任意遛遛、哔哔投、哔哔说内页记为一次阅读，
	    		  //相同内容多次打开记一次阅读，用户每天阅读三次完成“每日阅读“获得相应的奖励，每个用户一天只能获得一次”每日阅读“奖励）
    			commonManager.sendIntegral(param.getUserId(),
        				IntegralTypeEnum.READ_3, IntegralConstant.READ_3_NUM);
                LOGGER.info("阅读加花朵");
            }else {
                return JSON.toJSONString(Result.okObject(topic));
            }

            List<Integer> voteIds = topicDao.getDeteailVotes(param);
            if(voteIds != null && voteIds.size() > 0){
                topic.setVoteIds(voteIds);
            }
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error("com.quwan.beebee.service.impl.TopicServiceImpl.getDetail exception", e);
            return JSON.toJSONString(Result.response(ErrorCode.ServerError));
        }
        return JSON.toJSONString(Result.okObject(topic));
    }

    /**
     * 活动添加评论
     * 陈晓婵
     */
	@Override
	public String addComment(TopicCommentParam param) throws TException {
        Integer userId = param.getUserId();
        Integer topicId = param.getTopicId();
        if ( userId == 0 || topicId == 0){
            return JSON.toJSONString(Result.response(ErrorCode.NoLoginPleaseLogin));
        }
		Integer addComment = 0;
		try {
			
			//查询用户身份
			UserIdentity userIdentity = new UserIdentity();
			userIdentity.setUserId(param.getUserId())
			.setIdentity(param.getIdentity());
			
			List<UserIdentity> identitys = userDao.getIdentitys(userIdentity);
			if(identitys.size() > 0){
				userIdentity = identitys.get(0);
			}else{
				userIdentity.setColor(param.getColor());
				userDao.addUserIdentity(userIdentity);
			}
			
            TopicComment topicComment = new TopicComment();
            topicComment.setTopicId(param.getTopicId()).setUserId(param.getUserId())
            .setIdentityId(userIdentity.getId()).setContent(param.getContent()).setImg(param.getImg());
			addComment = topicDao.addComment(topicComment);

            //评论送花朵
            //String ok = commentGetIntegral(param);

			//同步评论数
            topicDao.syncTopicCommentCount1(param);

            //极光推送相关
            topicRecord(userId, topicId);
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error(
					"com.quwan.beebee.service.impl.TopicServiceImpl addComment error",
					e);
			return JSON.toJSONString(Result.response(ErrorCode.ServerError));
		}

		return JSON.toJSONString(Result.okObject(addComment));
	}

    /**
     * 话题发布者
     * @param userId
     * @param topicId
     */
	private void topicRecord(int userId, int topicId){
        //寻找话题发布者
        Integer adduserid = topicDao.getFramer(topicId);
        if(adduserid == null || adduserid <= 0){
            return;
        }

        //判断发布者是否插入成功
        Integer framerUser = commonDao.queryUser(adduserid);
        if(framerUser == null || framerUser <= 0){
            return;
        }

        Integer count = commonDao.queryUser(userId);
        if(count == null || count <= 0){

            //插入用户操作记录
            Integer addUser = commonDao.addUser(userId);
        }else {

            //更新操作
            Integer updateCount = commonDao.updateUserCount(userId);
        }

        //更新发布者推送数量 + 1
        Integer pushCount = commonDao.updatePushCount(adduserid);
    }

    /**
     * 评论送花朵
     * @param param
     * @return
     */
    public String commentGetIntegral(TopicCommentParam param){

        // 1.判断今天是否对文章评论
        int archivesCommentCount = topicDao
                .getArchivesCommentCount(param.getUserId());
        // 2.判断今天是否对哔哔投和哔哔说评论
        int topicCommentCount = topicDao.getTopicCommentCount(param
                .getUserId());
        // 3.判断今天是否回复别人的评论
        int commentAnswer = topicDao.getCommentAnswer(param
                .getUserId());
        // 4.如果参与了评论/回复,获得一次“评论1次”3朵花朵的奖励
        int totalCount = 0;
        Update update = new Update();
        totalCount = archivesCommentCount + topicCommentCount
                + commentAnswer;
        if (totalCount == 1) {
            // 4.1 如果totalCount==1,说明没有评论过哔哔或者回复过评论
            // 往T_IntegralLog中添加积分日志
            UserIntegralLog integralLog = new UserIntegralLog();
            integralLog.setAddTime(DateFormatUtils.format(
                    System.currentTimeMillis(), Constants.FORMAT_DATETIME));
            integralLog.setIntegral(3);
            integralLog.setTitle("评论");
            integralLog.setType(4);
            integralLog.setTypeDesc("评论获得花朵");
            integralLog.setUserId(param.getUserId());
            integralLogDao.insert(integralLog);
            // 4.2 往T_Loyalty中添加评论1次的日志
            Query query = new Query();
            Criteria criteria = new Criteria();
            criteria.and("userId").is(param.getUserId());
            criteria.and("data.name").is("评论1次");
            query.addCriteria(criteria);
            List<Loyalty> find = mongoTemplate.find(query, Loyalty.class);
            if (find.size() == 0) {
                return JSON.toJSONString(Result
                        .response(ErrorCode.UserIsNotExist));
            }
            /*Loyalty loyaltyParam = find.get(0);
            List<LoyaltyLog> data = loyaltyParam.getData();
            for (LoyaltyLog loyaltyLog : data) {
                String name = loyaltyLog.getName();
                if (name.equals("评论1次")) {
                    loyaltyLog.setFinished(1);
                    Update updateComment = new Update();
                    loyaltyParam.setData(data);
                    updateComment.set("data", data);
                    mongoTemplate.updateFirst(
                            Query.query(Criteria.where("_id").is(
                                    loyaltyParam.getId())), updateComment,
                            Loyalty.class);
                    break;
                }
            }*/

            // 4.3 往T_Integral中更新用户的积分
            int totalNum = 0;
            List<UserIntegral> findByUserId = integralDao.findByUserId(param
                    .getUserId());
            if (findByUserId != null && findByUserId.size() > 0) {
                UserIntegral integral = findByUserId.get(0);
                Integer totalIntegral = integral.getIntegral();
                totalNum = totalIntegral + 3;
                integral.setIntegral(totalNum);
                update.set("integral", totalNum);
                mongoTemplate.updateFirst(
                        Query.query(Criteria.where("_id").is(
                                integral.getId())), update, UserIntegral.class);
            } else {
                return JSON.toJSONString(Result
                        .response(ErrorCode.ArchivesParamNull));
            }

            return JSON.toJSONString(Result.success());
        }
        return JSON.toJSONString(Result.success());
    }

    /**
     * 获取活动评论列表
     * 陈晓婵
     */
    @Override
//    @Cacheable(value = "getCommentList", key = "#root.methodName + '-' + #param.getTopicId() + '-' + #param.getSort() + '-' + #param.getPageSize() + '-' + #param.getPageNumber()", unless = "#result.contains('Successful') eq false")
    public String getCommentList(TopicCommentListParam param) throws TException {
		List<TopicCommentResp> commentList;
        List<TopicCommentReplyThreeListResp> commentReplyThreeList = null;
		Integer index = PageUtil.convertIndex(param.getPageNumber(), param.getPageSize());
		param.setPageNumber(index);
		int totalCount = 0;
        int comments = 0;
		try {
            List<Integer> userIds = param.getUserId() > 0 ? commonDao.getBLacklist(param.getUserId()) : null;
			totalCount = topicDao.getCommentTotal(param, userIds);
			commentList = topicDao.getCommentList(param, userIds);
			for (TopicCommentResp topicComment : commentList) {

			    // 获取评论回复火热的三条
                commentReplyThreeList = topicDao.getTopicCommentThreeList(topicComment.getId());
                topicComment.setCommentReplyThreeListRespList(commentReplyThreeList);

                // 获取评论回复总条数
                comments = topicDao.getCommentReplyTotal(topicComment.getId());
                topicComment.setComments(comments);

                if (StringUtils.isNotEmpty(topicComment.getIdentity())) {
                    continue;
                }

                List<Map<String,String>> replierList = (List<Map<String,String>>) JSONArray.parse(topicComment.getReplierID());
                if (CollectionUtils.isEmpty(replierList)) {
                    continue;
                }

                topicComment.setIdentity(replierList.get(0).get("identity"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error("com.quwan.beebee.service.impl.TopicServiceImpl getCommentList error", e);
			return JSON.toJSONString(Result.response(ErrorCode.ServerError));
		}

		Result okList = Result.okList(param.pageNumber, param.pageSize, totalCount, commentList);
		return JSON.toJSONString(okList);
    }

    /**
     * 添加活动评论回复
     * 李静
     */
    @Override
    public String addCommentReply(TopicCommentReplyParam param)
            throws TException {
        Integer userId = param.getUserId();
        Integer commentId = param.getCommentId();
        if ( userId == 0 || commentId == 0){
            return JSON.toJSONString(Result.response(ErrorCode.NoLoginPleaseLogin));
        }
        Integer num = null;
        try {

            // 获取评论详情
            TopicComment comment = topicDao.getTopicCommentById(param.getCommentId());
            TopicComment topicComment = new TopicComment();
            topicComment.setTopicId(comment.getTopicId()).setUserId(param.getUserId()).setContent(param.getContent())
                    .setParentId(param.getCommentId()).setParentUserId(comment.getUserId()).setImg(param.getImg());

            // 添加评论回复
            num = topicDao.addCommentReply(topicComment);

            // 同步活动表 评论数、今日评论数
            topicDao.syncTopicCommentCount(param);
            commentRecord(userId, commentId);
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error("com.quwan.beebee.service.impl.TopicServiceImpl addCommentReply error", e);
            return JSON.toJSONString(Result.response(ErrorCode.ServerError));
        }

        return JSON.toJSONString(Result.okObject(num));
    }

    /**
     * 获取哔哔评论回复列表
     * 李静
     */
    public String getCommentReplyList(TopicCommentReplyListParam param) throws TException {
        List<TopicCommentReplyListResp> topicCommentReplyList = null;
        Integer index = PageUtil.convertIndex(param.getPageNumber(), param.getPageSize());
        param.setPageNumber(index);
        int total = 0;
        String parentUser = "";
        try {
            total = topicDao.getCommentReplyTotal(param.getCommentId());
            topicCommentReplyList = topicDao.getCommentReplyList(param);
            for (TopicCommentReplyListResp commentReplyListResp : topicCommentReplyList) {
                parentUser = topicDao.getCommentReplyUserNicker(commentReplyListResp.getParentUserId());
                commentReplyListResp.setParentUser(parentUser);
            }
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error("com.quwan.beebee.service.impl.TopicServiceImpl getCommentReplyList error", e);
            return JSON.toJSONString(Result.response(ErrorCode.ServerError));
        }
        Result result = Result.okList(param.getPageNumber(), param.getPageSize(), total, topicCommentReplyList);
        return JSON.toJSONString(result);
    }

    /**
     * 评论点赞状态的添加和修改
     * @param param
     * @author 于浩
     */
    @Override
    public String updateCommentPraiseStatus(TopicCommentPraiseParam param) throws TException {
        Integer userId = param.getUserId();
        Integer commentId = param.getCommentId();
        LOGGER.info("userId=" + userId +"----" + "commentId=" + commentId);
        if ( userId == 0 || commentId == 0){
            return JSON.toJSONString(Result.response(ErrorCode.NoLoginPleaseLogin));
        }
        Integer num = null;
        try {

            // 查询评论是否为空
            TopicComment comment = topicDao.getTopicCommentById(param.getCommentId());
            LOGGER.info("comment=" + comment.toString());
            if(comment == null){
                return JSON.toJSONString(Result.response(ErrorCode.FailedObtainDetails));
            }

            // 查询是否有过点赞记录
            Integer id = topicDao.getCommentPraiseId(param);

            // 如果该用户没有点赞 并且 行为是取消点赞
            if (id == null && param.getValid() == 0) {
                LOGGER.info("如果该用户没有点赞 并且 行为是取消点赞");
                return JSON.toJSONString(Result.response(ErrorCode.FailedVote));
            }

            // 如果该用户没有点赞 并且 行为是点赞
            if (id == null) {
                num = topicDao.addCommentPraise(param);
                topicDao.syncCommentPraise(param);
                LOGGER.info("如果该用户没有点赞 并且 行为是点赞");
                commentRecord(userId, commentId);
                return JSON.toJSONString(Result.okObject(num));
            }

            // 如果该用户已经点赞 修改点赞
            num = topicDao.updateCommentPraise(param);
            topicDao.syncCommentPraise(param);
            LOGGER.info("成功！！！！");
            return JSON.toJSONString(Result.okObject(num));
        }catch (Exception e){
            e.printStackTrace();
            LOGGER.error("com.quwan.beebee.service.impl.TopicServiceImpl updateCommentPraiseStatus error", e);
            return JSON.toJSONString(Result.response(ErrorCode.ServerError));
        }
    }

    /**
     * 话题评论者
     * @param userId
     * @param commentId
     */
    private void commentRecord(int userId, int commentId){

        //寻找话题评论者
        TopicComment comment = topicDao.getTopicCommentById(commentId);
        if(comment == null){
            return;
        }

        //判断发布者是否插入成功
        Integer framerUser = commonDao.queryUser(comment.getUserId());
        if(framerUser == null || framerUser <= 0){
            return;
        }

        Integer count = commonDao.queryUser(userId);
        if(count == null || count <= 0){

            //插入用户操作记录
            Integer addUser = commonDao.addUser(userId);
        }else {

            //更新操作
            Integer updateCount = commonDao.updateUserCount(userId);
        }

        //更新发布者推送数量 + 1
        Integer pushCount = commonDao.updatePushCount(comment.getUserId());
    }

    /**
     * 获取活动弹幕列表
     * 何飞达
     * @param param
     * @return
     * @throws TException
     */
    @Override
    public String getBarrageList(TopicBarrageListParam param) throws TException {
        Integer index = PageUtil.convertIndex(param.getPageNumber(), param.getPageSize());
        param.setPageNumber(index);
        List<TopicBarrageListResp> topicBarrageList = null;
        int total = 0;
        try {
            topicBarrageList = topicDao.getBarrageList(param);
            total = topicDao.getBarrageListTotal(param);
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error("com.quwan.beebee.service.impl.TopicServiceImpl.getBarrageList exception", e);
            return JSON.toJSONString(Result.response(ErrorCode.ServerError));
        }

        Result result = Result.okList(param.getPageNumber(), param.getPageSize(), total, topicBarrageList);
        return JSON.toJSONString(result);
    }

    /**
     * 话题投票
     * 何飞达
     * @param param
     * @return
     * @throws TException
     */
    @Override
    public String addVote(TopicVoteParam param) throws TException {
        Integer userId = param.getUserId();
        Integer topicId = param.getTopicId();
        String option = param.getOption();
        if ( userId <= 0 || topicId <= 0 || option.equals("")){
            return JSON.toJSONString(Result.response(ErrorCode.NoLoginPleaseLogin));
        }
        Integer addVote = null;
        try {
            List<TopivVoteResp> topicVote = topicDao.getTopicVote(param);
            if(topicVote != null && topicVote.size() > 0){
                return JSON.toJSONString(Result.response(ErrorCode.UserVoteExist));
            }
            String options[] = option.split(",");
            for(String s : options){
                param.setOption(s);
                addVote = topicDao.addVote(param);
                topicDao.synTopicOptionCount(param);
            }
            topicRecord(userId, topicId);
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error("com.quwan.beebee.service.impl.TopicServiceImpl.addVote exception", e);
            return JSON.toJSONString(Result.response(ErrorCode.ServerError));
        }
        return JSON.toJSONString(Result.okObject(addVote));
    }

    /**
     * 添加哔哔投和哔哔说
     * @param param
     * @return
     * @throws TException
     */
    @Override
    public String addTopic(TopicParam param) throws TException {
        int userId = param.getUserId();
        if(userId <= 0){
            return JSON.toJSONString(Result.response(ErrorCode.TheTypeValueNull));
        }
        String addTopic = null;
        int valueOf = 0;
        try {
            //类型1：哔哔说 3：哔哔投
            if(param.getType() > 3 || param.getType() <= 0){
                return JSON.toJSONString(Result.response(ErrorCode.TheTypeValueNull));
            }

            if(param.getImg () == null){
                param.setImg ("");
            }
            if(param.getContent () == null){
                param.setContent ("");
            }
            Integer addTopicTalk = topicDao.addTopicTalk(param);
            if(addTopicTalk == null){
                return JSON.toJSONString(Result.response(ErrorCode.TheTypeValueNull));
            }

            //极光推送相关
            Integer user = commonDao.queryUser(userId);
            if(user != null && user != 0){
                Integer updateUser = commonDao.updateUserCount(userId);
                if(updateUser == null){
                    return JSON.toJSONString(Result.response(ErrorCode.TheTypeValueNull));
                }
            }else {
                Integer addUser = commonDao.addUser(userId);
                if(addUser == null){
                    return JSON.toJSONString(Result.response(ErrorCode.TheTypeValueNull));
                }
            }
            List<TopicResp> respList = topicDao.getTopicList(param);
            if(respList == null){
                return JSON.toJSONString(Result.response(ErrorCode.TheTypeValueNull));
            }

            TopicResp resp = respList.get(0);
            if(resp == null){
                return JSON.toJSONString(Result.response(ErrorCode.TheTypeValueNull));
            }

            if(param.getType() == 3){
                List<TopicOptionParam> topicOptionParamList = new ArrayList<>();

                String option = param.getOption();
                if(option == null){
                    return JSON.toJSONString(Result.response(ErrorCode.TheTypeValueNull));
                }

                JSONArray array = JSONArray.parseArray(option);
                Iterator iterator = array.iterator();
                while(iterator.hasNext()){
                    TopicOptionParam optionParam = new TopicOptionParam();
                    JSONObject ob = (JSONObject) iterator.next();
                    if(ob.getString("topicId") != null){
                        optionParam.setTopicId(Integer.parseInt(ob.getString("topicId")));
                    }
                    if(ob.getString("img") != null){
                        optionParam.setImg(ob.getString("img"));
                    }
                    if(ob.getString("name") != null){
                        optionParam.setName(ob.getString("name"));
                    }
                    topicOptionParamList.add(optionParam);
                }

                if(topicOptionParamList != null){
                    for(TopicOptionParam optionParam : topicOptionParamList){
                        optionParam.setTopicId(resp.getId());
                        topicDao.addTopicThrow(optionParam);
                        valueOf++;
                    }
                }
            }
            addTopic = String.valueOf(valueOf);
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error(
                    "com.quwan.beebee.service.impl.TopicServiceImpl addTopic error",
                    e);
            return JSON.toJSONString(Result.response(ErrorCode.ServerError));
        }
        Result okObject = Result.okObject(addTopic);
        return JSON.toJSONString(okObject);
    }
    
    /**
     * @Title: getHotRecommend 
     * @Description: 获取热门推荐
     * @param type 0：全部 1：哔哔说 2：哔哔投
     * @return String    返回类型 
     * @author 李静
      */
    @Override
    public String getHotRecommend(int type) throws TException {
    	List<TopicResp> hotTopicList = null;
    	try {
    		String cat = "全部";
    		if(TopicTypeEnum.TOPIC_ALL.code == type) cat = TopicTypeEnum.TOPIC_ALL.message;
    		if(TopicTypeEnum.TOPIC_SPEAK.code == type) cat = TopicTypeEnum.TOPIC_SPEAK.message;
    		if(TopicTypeEnum.TOPIC_VOTE.code == type) cat = TopicTypeEnum.TOPIC_VOTE.message;
    		hotTopicList = topicDao.getHotRecommend(cat);
    	} catch (Exception e) {
            e.printStackTrace();
            LOGGER.error(
                    "com.quwan.beebee.service.impl.TopicServiceImpl getHotRecommend error",
                    e);
            return JSON.toJSONString(Result.response(ErrorCode.ServerError));
        }
        return JSON.toJSONString(Result.okObject(hotTopicList));
    }

    /**
     * 获取评论回复最火热的三条回复评论
     * @param commentId
     * @return String
     * @throws TException
     */
    @Override
    public String getCommentReplyThreeList(int commentId) throws TException {
        List<TopicCommentReplyThreeListResp> commentReplyThreeList = null;
        try {
            commentReplyThreeList = topicDao.getTopicCommentThreeList(commentId);
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error("com.quwan.beebee.service.impl.TopicServiceImpl getCommentReplyThreeList error", e);
            return JSON.toJSONString(Result.response(ErrorCode.ServerError));
        }
        return JSON.toJSONString(Result.okObject(commentReplyThreeList));
    }

    /**
     * 获取话题评论回复用户
     * @param param
     * @return
     */
    @Override
    public String getCommentReplyUser(TopicCommentReplyUserParam param) throws TException {
        List<UserCommentResp> userCommentRespList = null;
        try {
            userCommentRespList = topicDao.getCommentReplyUser(param);
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error("com.quwan.beebee.service.impl.TopicServiceImpl getCommentReplyUser error", e);
            return JSON.toJSONString(Result.response(ErrorCode.ServerError));
        }
        return JSON.toJSONString(Result.okObject(userCommentRespList.get(0)));
    }

    /**
     * 添加话题举报
     * @param param
     * @return
     * @throws TException
     */
    @Override
    public String addTopicReport(TopicReportParam param) throws TException {
        int num = 0;
        if(param.getTopicId() <= 0 || param.getUserId() <= 0){
            return JSON.toJSONString(Result.response(ErrorCode.UserIsNull));
        }

        if(param.getType() > 0 && param.getCommentId() <= 0){
            return JSON.toJSONString(Result.response(ErrorCode.TheTypeValueNull));
        }

        if(param.getCommentId() > 0){
            TopicComment topicComment = topicDao.getTopicCommentById(param.getCommentId());
            if(topicComment == null){
                return JSON.toJSONString(Result.response(ErrorCode.TheTypeValueNull));
            }

            //不是指定话题的评论
            if(topicComment.getTopicId() != param.getTopicId()){
                return JSON.toJSONString(Result.response(ErrorCode.TheTypeValueNull));
            }
        }

        try {
            num = topicDao.addTopicReport(param);
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error("server.ip: "+ Constants.serverIpAddress +", com.quwan.beebee.service.impl.TopicServiceImpl addTopicReport error", e);
            return JSON.toJSONString(Result.response(ErrorCode.ServerError));
        }
        return JSON.toJSONString(Result.okObject(num));
    }


}


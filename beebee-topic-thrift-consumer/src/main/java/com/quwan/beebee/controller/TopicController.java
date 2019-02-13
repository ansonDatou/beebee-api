package com.quwan.beebee.controller;

import com.quwan.beebee.common.Method;
import com.quwan.beebee.common.Server;
import com.quwan.beebee.param.topic.*;
import com.quwan.beebee.utils.EurekaUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by anson on 2017/10/9.
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/topic")
public class TopicController {

    private static final Logger logger = Logger.getLogger(TopicController.class);

    @Autowired
    private EurekaUtil eurekaUtil;

    /**
     * 哔哔首页话题列表
     */
    @PostMapping("/getList")
    public String getList(TopicListParam param) {
        return eurekaUtil.remoteInvoke(Server.BEEBEE_TOPIC_THRIFT_PROVIDER_CLIENT, Method.TOPIC_GET_LIST, param);
    }

    /**
     * 获取话题详情
     * @param param
     * @return
     * @author 何飞达
     */
    @PostMapping("/getDetail")
    public String getDetail(TopicDetailParam param){return eurekaUtil.remoteInvoke(Server.BEEBEE_TOPIC_THRIFT_PROVIDER_CLIENT, Method.TOPIC_GET_DETAIL, param);}

    /**
     * 给活动添加评论
     * 陈晓婵
     */
    @PostMapping("/addComment")
    public String addComment(TopicCommentParam param) {
        return eurekaUtil.remoteInvoke(Server.BEEBEE_TOPIC_THRIFT_PROVIDER_CLIENT, Method.TOPIC_ADD_COMMENT, param);
    }

    /**
     * 获取活动评论列表
     * 陈晓婵
     */
    @PostMapping("/getCommentList")
    public String getCommentList(TopicCommentListParam param) {
        return eurekaUtil.remoteInvoke(Server.BEEBEE_TOPIC_THRIFT_PROVIDER_CLIENT, Method.TOPIC_GET_COMMENTLIST, param);
    }

    /**
     * @Description: 获取活动评论回复列表
     * @param param
     * @author 李静
     */
    @PostMapping("/getCommentReplyList")
    public String getCommentReplyList(TopicCommentReplyListParam param) {
        return eurekaUtil.remoteInvoke(Server.BEEBEE_TOPIC_THRIFT_PROVIDER_CLIENT, Method.TOPIC_GET_COMMENT_REPLY_LIST, param);
    }

    /**
     * @Description: 添加活动评论回复
     * @author 李静
     */
    @PostMapping("/addCommentReply")
    public String addCommentReply(TopicCommentReplyParam param) {
        return eurekaUtil.remoteInvoke(Server.BEEBEE_TOPIC_THRIFT_PROVIDER_CLIENT, Method.TOPIC_ADD_COMMENT_REPLY, param);
    }

    /**
     * 获取话题弹幕列表
     * @param param
     * @return
     * @author 何飞达
     */
    @PostMapping("/getBarrageList")
    public String getBarrageList(TopicBarrageListParam param) {
        return eurekaUtil.remoteInvoke(Server.BEEBEE_TOPIC_THRIFT_PROVIDER_CLIENT, Method.TOPIC_GET_BARRAGE_LIST, param);}

    /**
     * 话题投票
     * @param param
     * @return
     * @author 何飞达
     */
    @PostMapping("/addVote")
    public String addVote(TopicVoteParam param) {
        return eurekaUtil.remoteInvoke(Server.BEEBEE_TOPIC_THRIFT_PROVIDER_CLIENT, Method.TOPIC_ADD_VOTE, param);}

    /**
     * 修改评论点赞状态
     * @param param
     * @return
     * @author 于浩
     */
    @PostMapping("/updateCommentPraiseStatus")
    public String updateCommentPraiseStatus(TopicCommentPraiseParam param) {
        return eurekaUtil.remoteInvoke(Server.BEEBEE_TOPIC_THRIFT_PROVIDER_CLIENT, Method.TOPIC_UPDATE_COMMENT_PRAISE_STATUS, param);}

    /**
     * 添加哔哔话题
     * 于浩
     * @param param
     * @return
     */
    @PostMapping("/addTopic")
    public String addTopic(TopicParam param) {return eurekaUtil.remoteInvoke(Server.BEEBEE_TOPIC_THRIFT_PROVIDER_CLIENT, Method.TOPIC_ADD_TOPIC, param);}

    /**
     * @Title: getHotRecommend
     * @Description: 获取热门推荐
     * @param type 0：全部 1：哔哔说 2：哔哔投
     * @return String    返回类型
     * @author 李静
     */
    @PostMapping("/getHotRecommend")
    public String getHotRecommend(Integer type) {
        return eurekaUtil.remoteInvoke(Server.BEEBEE_TOPIC_THRIFT_PROVIDER_CLIENT, Method.TOPIC_GET_HOT_RECOMMEND, type);
    }

    /**
     * 获取活动评论火热的三条回复评论
     * @param param
     * @return
     */
    @PostMapping("/getCommentReplyThreeList")
    public String getCommentReplyThreeList(Integer commentId) {
        return eurekaUtil.remoteInvoke(Server.BEEBEE_TOPIC_THRIFT_PROVIDER_CLIENT, Method.TOPIC_GET_COMMENT_REPLY_THREE_LIST, commentId);
    }

    /**
     * 获取话题评论回复用户
     * @param param
     * @return
     */
    @PostMapping("/getCommentReplyUser")
    public String getCommentReplyUser(TopicCommentReplyUserParam param) {
        return eurekaUtil.remoteInvoke(Server.BEEBEE_TOPIC_THRIFT_PROVIDER_CLIENT, Method.TOPIC_GET_COMMENT_REPLY_USER, param);
    }

    /**
     * 添加话题举报
     * @param param
     * @return
     */
    @PostMapping("/addTopicReport")
    public String addTopicReport(TopicReportParam param) {
        return eurekaUtil.remoteInvoke(Server.BEEBEE_TOPIC_THRIFT_PROVIDER_CLIENT, Method.TOPIC_ADD_REPORT, param);
    }

}

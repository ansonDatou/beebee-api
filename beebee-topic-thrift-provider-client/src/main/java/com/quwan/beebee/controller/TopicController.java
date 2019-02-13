package com.quwan.beebee.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.quwan.beebee.param.topic.*;
import com.quwan.beebee.utils.ThriftUtil;

/**
 * Created by anson on 2017/10/9.
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/topic")
public class TopicController {


    private static final Logger LOGGER = LoggerFactory.getLogger(TopicController.class);

    @Autowired
    private ThriftUtil thriftUtil;

    /**
     * 哔哔首页话题列表
     * @param param
     * @return
     */
    @PostMapping("/getList")
    public String getList(@RequestBody TopicListParam param) {
        return thriftUtil.remoteInvoke("getList", param);
    }

    /**
     * 获取话题详情
     * @param param
     * @return
     * @author 何飞达
     */
    @PostMapping("/getDetail")
    public String getDetail(@RequestBody TopicDetailParam param){
        return thriftUtil.remoteInvoke("getDetail", param);
	}

    /**
     * 给活动添加评论
     * 陈晓婵
     * @param param
     * @return
     */
    @PostMapping("/addComment")
    public String addComment(@RequestBody TopicCommentParam param) {
        return thriftUtil.remoteInvoke("addComment", param);
    }

    /**
     * 获取活动评论列表
     * 陈晓婵
     * @param param
     * @return
     */
    @PostMapping("/getCommentList")
    public String getCommentList(@RequestBody TopicCommentListParam param) {
        return thriftUtil.remoteInvoke("getCommentList", param);
    }

    /**
     * @Description: 获取活动评论回复列表
     * @param param
     * @author 李静
     */
    @PostMapping("/getCommentReplyList")
    public String getCommentReplyList(@RequestBody TopicCommentReplyListParam param) {
        return thriftUtil.remoteInvoke("getCommentReplyList", param);
    }

    /**
     * @Description: 添加活动评论回复
     * @param param
     * @author 李静
     */
    @PostMapping("/addCommentReply")
    public String addCommentReply(@RequestBody TopicCommentReplyParam param) {
        return thriftUtil.remoteInvoke("addCommentReply", param);
    }

    /**
     * 获取话题弹幕列表
     * @param param
     * @return
     * @author 何飞达
     */
    @PostMapping("/getBarrageList")
    public String getBarrageList(@RequestBody TopicBarrageListParam param) {
        return thriftUtil.remoteInvoke("getBarrageList", param);}

    /**
     * 话题投票
     * @param param
     * @return
     * @author 何飞达
     */
    @PostMapping("/addVote")
    public String addVote(@RequestBody TopicVoteParam param) {
        return thriftUtil.remoteInvoke("addVote", param);}

    /**
     * 修改评论点赞状态
     * @param param
     * @return
     * @author 于浩
     */
    @PostMapping("/updateCommentPraiseStatus")
    public String updateCommentPraiseStatus(@RequestBody TopicCommentPraiseParam param) {
        return thriftUtil.remoteInvoke("updateCommentPraiseStatus", param);}

    /**
     * 添加哔哔话题
     * 于浩
     * @param param
     * @return
     */
    @PostMapping("/addTopic")
    public String addTopic(@RequestBody TopicParam param) {return thriftUtil.remoteInvoke("addTopic", param);}

    /**
    * @Title: getHotRecommend
    * @Description: 获取热门推荐
    * @param type 0：全部 1：哔哔说 2：哔哔投
    * @return String    返回类型
    * @author 李静
     */
    @PostMapping("/getHotRecommend")
    public String getHotRecommend(@RequestBody Integer type) {
    	return thriftUtil.remoteInvoke("getHotRecommend", type);
    }

    /**
     *  获取活动评论火热的三条回复评论
     * @param commentId
     * @author 孙新越
     */
    @PostMapping("/getCommentReplyThreeList")
    public String getCommentReplyThreeList(@RequestBody Integer commentId) {
        return thriftUtil.remoteInvoke("getCommentReplyThreeList", commentId);
    }

    /**
     * 获取话题评论回复用户
     * @param param
     * @return
     */
    @PostMapping("/getCommentReplyUser")
    public String getCommentReplyUser(@RequestBody TopicCommentReplyUserParam param) {
        return thriftUtil.remoteInvoke("getCommentReplyUser", param);
    }

    /**
     * 添加话题举报
     * @param param
     * @return
     */
    @PostMapping("/addTopicReport")
    public String addTopicReport(@RequestBody TopicReportParam param) {
        return thriftUtil.remoteInvoke("addTopicReport", param);
    }
}

package com.quwan.beebee.dao;

import java.util.List;

import com.quwan.beebee.resp.topic.*;
import com.quwan.beebee.resp.user.UserCommentResp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import com.quwan.beebee.param.topic.*;
import com.quwan.beebee.entity.topic.TopicComment;
import com.quwan.beebee.mongo.UserIntegral;
import com.quwan.beebee.resp.user.UserIntegralLogResp;


@Mapper
@Repository("topicDao")
public interface TopicDao {

    /* 查询哔哔首页话题列表 何飞达 */
    List<TopicResp> queryTopicList(@Param("param") TopicListParam param, @Param("userIds") List<Integer> userIds);

    /* 查询哔哔首页话题列表总数 何飞达 */
    int queryTopicTotal(@Param("param") TopicListParam param, @Param("userIds") List<Integer> userIds);

    /* 获取活动详情 何飞达 */
    TopicDetailResp getDetail(TopicDetailParam param);

    /* 获取哔哔投内容 */
    List<TopicVoteOptionResp> getVoteOption(TopicDetailParam param);

    /*  查询用户对于哔哔投票的记录 */
    List<Integer> getDeteailVotes(TopicDetailParam param);

    /* 保存用户积分，同步MySQL，因为运营后台有用到 ---暂时保留   李静 */
    void saveUserIntegral(@Param("param") UserIntegral param);

    /* 活动添加评论 陈晓婵 */
    int addComment(TopicComment topicComment);

    /* 获取活动评论列表 陈晓婵 */
    List<TopicCommentResp> getCommentList(@Param("param") TopicCommentListParam param, @Param("userIds") List<Integer> userIds);

    /* 获取活动评论总数  李静*/
    int getCommentTotal(@Param("param") TopicCommentListParam param, @Param("userIds") List<Integer> userIds);
    
    /* 获取哔哔评论回复总数 李静 */
    int getCommentReplyTotal(int commentId);

    /* 获取哔哔评论回复列表 李静 */
    List<TopicCommentReplyListResp> getCommentReplyList(TopicCommentReplyListParam param);

    /* 添加活动评论回复 李静 */
    int addCommentReply(TopicComment topicComment);

    /* 同步活动表 评论数、今日评论数 */
    void syncTopicCommentCount(TopicCommentReplyParam param);

    /* 根据id获取TopicComment 李静 */
    TopicComment getTopicCommentById(int commentId);

   /* 同步投票人个数 何飞达 */
    void synTopicOptionCount(TopicVoteParam param);

    /* 查询用户对活动的投票记录 何飞达 */
    List<TopivVoteResp> getTopicVote(TopicVoteParam param);

    /* 活动投票 何飞达 */
    int addVote(TopicVoteParam param);

     /*获取投票人性别 何飞达*/
    int getUseSex(TopicVoteParam param);

       /*同步投票人数 何飞达*/
     void synTopicSex(TopicVoteParam param);

    /* 活动弹幕列表 何飞达 getUseSex*/
    List<TopicBarrageListResp> getBarrageList(TopicBarrageListParam param);

    /* 活动弹幕列表数量 何飞达 */
    int getBarrageListTotal(TopicBarrageListParam param);

    /* 按条件获取是否有点赞记录 于浩 */
    Integer getCommentPraiseId(TopicCommentPraiseParam param);

    /* 增加评论点赞 于浩 */
    int addCommentPraise(TopicCommentPraiseParam param);

    /* 同步点赞记录 何飞达 */
    Integer syncCommentPraise(TopicCommentPraiseParam param);

    /* 更新评论点赞状态 于浩 */
    Integer updateCommentPraise(TopicCommentPraiseParam param);

    /* 发起哔哔说 */
    Integer addTopicTalk(TopicParam param);

    /* 发起哔哔投 */
    Integer addTopicThrow(TopicOptionParam param);

    /* 获取最新添加话题详情 */
    List<TopicResp> getTopicList(TopicParam param);

    /**
     * 获取用户当天的评论文章的个数-陈晓婵-2018年1月8日15:56:28
     * @param userId
     * @return
     */
    int getArchivesCommentCount(int userId);
    
    /**
     * 获取用户当天的评论哔哔的个数-陈晓婵-2018年1月8日15:58:32
     * @param userId
     * @return
     */
    int getTopicCommentCount(int userId);

    /**
     * 判断今天是否回复别人的评论-陈晓婵-2018年1月8日19:35:24
     * @param userId
     * @return
     */
    int getCommentAnswer(int userId);

    /**
     * 同步评论数-何飞达-2018年1月16日
     * @param param
     * @return
     */
    int syncTopicCommentCount1(TopicCommentParam param);
    
    /**
    * @Title: getHotRecommend 
    * @Description: 获得热门推荐
    * @param cat
    * @return List<TopicResp>    返回类型 
    * @author 李静
     */
	List<TopicResp> getHotRecommend(@Param("cat") String cat);
	
	/**
	 * 新增用户积分日志-陈晓婵-2018年1月17日21:14:27
	 * 
	 * @param param
	 * @return
	 */
	int insertIntegralLog(@Param("param") UserIntegralLogResp param);

    /**
     * 获取哔哔说发布者
     * @param topicId
     * @return
     */
    Integer getFramer(@Param("topicId") int topicId);

    /**
     * 获取评论回复最火热的三条回复评论
     * @param commentId
     */
    List<TopicCommentReplyThreeListResp> getTopicCommentThreeList(Integer commentId);

    /**
     * 获取话题评论回复用户
     * @param param
     */
    List<UserCommentResp> getCommentReplyUser(TopicCommentReplyUserParam param);

    /**
     * 获取话题评论回复用户
     * @param parentUserId
     */
    String getCommentReplyUserNicker(int parentUserId);

    /**
     * 添加话题举报
     * @param param
     * @return
     */
    Integer addTopicReport(@Param("param") TopicReportParam param);


}

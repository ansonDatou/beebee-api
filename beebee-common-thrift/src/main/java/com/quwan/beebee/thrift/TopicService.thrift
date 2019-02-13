namespace java com.quwan.beebee.service.topic

include "TopicEntity.thrift"
include "TopicParam.thrift"

service TopicService {

    // 哔哔首页获取列表
    string getList(1: required TopicParam.TopicListParam param);

    // 获取话题详情
    string getDetail(1: required TopicParam.TopicDetailParam param);

    // 添加话题评论
    string addComment(1: TopicParam.TopicCommentParam param);

    // 获取话题的评论列表
    string getCommentList(1: TopicParam.TopicCommentListParam param);

    // 添加话题评论回复
    string addCommentReply(1: TopicParam.TopicCommentReplyParam param);

    // 获取话题评论的回复列表
    string getCommentReplyList(1: TopicParam.TopicCommentReplyListParam param);

    // 评论，点赞与取消点赞
    string updateCommentPraiseStatus(1: TopicParam.TopicCommentPraiseParam param);

    // 获取活动弹幕
    string getBarrageList(1: TopicParam.TopicBarrageListParam param);

    // 添加投票
    string addVote(1: TopicParam.TopicVoteParam param);

    // 添加话题
    string addTopic(1: TopicParam.TopicParam param);
    
    // 获取热门推荐
    string getHotRecommend(1: required i32 param);

    // 获取话题评论回复的三条火热评论列表
    string getCommentReplyThreeList(1: required i32 param);

    // 获取话题评论回复用户
    string getCommentReplyUser(1: TopicParam.TopicCommentReplyUserParam param);

    // 添加活动举报
    string addTopicReport(1: TopicParam.TopicReportParam param);
}
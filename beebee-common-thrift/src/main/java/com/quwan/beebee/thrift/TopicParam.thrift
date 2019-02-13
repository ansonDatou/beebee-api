namespace java com.quwan.beebee.param.topic

// 获取话题列表参数
struct TopicListParam {
    1:  required i32            sortType,       // 排序规则 1=最新 2=最热
    2:  required i32            pageNumber,     // 页码
    3:  required i32            pageSize,       // 每页数据量
    4:  required i32            type,           // 活动类型
    5:  required i32            userId,         // 用户id
}

// 获取话题详情参数
struct TopicDetailParam {
    1:  required i32            topicId,    // 话题id
    2:  optional i32            userId,     // 用户id
}

// 添加话题评论
struct TopicCommentParam {
    1:  required i32            userId,         // 用户id
    2:  required i32            topicId,        // 话题id
    3:  required string         content,        // 评论内容
    4:  optional string         identity,       // 身份
    5:  optional string         color,          // 显示颜色
    6:  optional string         img,            // 话题图片
}

// 获取活动评论列表-陈晓婵-2017年12月22日11:15:38
struct TopicCommentListParam {
    1:  required i32            topicId,        // 话题id
    2:  required i32            sort,           // 排序类型 1=最新 2=最热
    3:  required i32            pageNumber,     // 页码
    4:  required i32            pageSize,       // 每页数据量
    5:  required i32            userId          // 用户id
}

// 添加话题评论回复
struct TopicCommentReplyParam {
    1:  required i32            userId,         // 用户id
    2:  required i32            topicId,        // 话题id
    3:  required i32            commentId,      // 评论id
    4:  required string         content,        // 回复内容
    5:  optional string         img             // 话题图片
}

// 获取话题评论的回复列表
struct TopicCommentReplyListParam {
    1:  required i32            commentId,      // 评论id
    2:  required i32            pageNumber,     // 页码
    3:  required i32            pageSize,       // 每页数据量
}

// 评论，点赞与取消点赞
struct TopicCommentPraiseParam {
    1:  required i32            userId,         // 用户id
    2:  required i32            commentId,      // 评论id
    3:  required i32            valid,          // 点赞与取消，0 = 点赞，1 = 取消
}

// 获取屏幕点赞
struct TopicBarrageListParam {
    1:  required i32            userId,         // 用户id
    2:  required i32            topicId,        // 话题id
    3:  required i32            sortType,       // 排序规则
    4:  required i32            pageNumber,     // 页码
    5:  required i32            pageSize,       // 每页数据量
}

// 添加投票
struct TopicVoteParam {
    1:  required i32            userId,         // 用户id
    2:  required i32            topicId,        // 话题id
    3:  required string         option          // 选项id
}

// 投票选项
struct TopicOptionParam {
    1:  optional i32            topicId,        // 话题id
    2:  required string         name,           // 选项值
    3:  required string         img,            // 投票选项后面的图片
    4:  required i32            order           // 投票选项排序
}

// 添加哔哔说或者哔哔投
struct TopicParam {
    1:  required i32                    userId,         // 用户id
    2:  required i32                    type,           // 类型：1-问答2-猜猜3-投票
    3:  required string                 title,          // 话题title
    4:  required string                 content,        // 话题内容
    5:  optional string                 img,            // 话题图片
    6:  optional string                 replierIdentity,// 希望回答者身份
    7:  optional i32                    multiSelect,    // 哔哔投，0单选，1多选
    8:  optional string                 option,         // 选项
}

// 获取话题评论回复用户
struct TopicCommentReplyUserParam {
    1:  required i32            userId,         // 用户id
    2:  required i32            topicId,        // 话题id
    3:  required i32            commentId,      // 评论id
}

// 活动举报
struct TopicReportParam {
    1:  required i32             topicId,        // 活动id
    2:  required i32             userId,         // 用户id
    3:  optional i32             commentId,      // 评论id
    4:  required i32             type,           // 类型，0哔哔说、哔哔投 1评论
    5:  required string          reason          // 原因

}


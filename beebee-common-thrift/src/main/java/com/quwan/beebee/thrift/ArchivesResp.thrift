namespace java com.quwan.beebee.param.archives


// 文章评论
struct CommentAnswerListResp {
    1: i32                          archId,                 // 文章id
    2: list<CommentListResp>        commentListResp,        // 文章的评论
}

// 评论的响应
struct CommentListResp {
    1:  required i32                            commentId,              // 评论id
    2:  required i32                            userId,                 // 评论者Userid
    3:  optional string                         username,               // 评论者的名字
    4:  optional string                         content,                // 评论内容
    5:  optional string                         addTime,                // 评论时间
    6:  optional string                         nicker,                 // 评论者昵称
    7:  optional string                         head,                   // 评论者头像
    8:  optional list<CommentAnswerResp>        commentAnswerList,      // 该评论的回复内容
}

// 评论回复响应
struct CommentAnswerResp {
    1:  required i32            userIdAnswer,   // 回复用户id
    2:  required i32            userIdNotify,   // @用户id
    3:  optional string         content,        // 回复内容
    4:  required string         answerTime,     // 回复时间
}


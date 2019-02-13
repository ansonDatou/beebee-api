namespace java com.quwan.beebee.param.archives

// 文章列表参数
struct ArchivesListParam {
    1:  required i32            sourceType,     // 请求源类别 1为图文 2为视频
    2:  required i32            pageNumber,     // 页码
    3:  required i32            pageSize,       // 每页数据量
    4:  required i32            sortId,         // 首页分类id
    5:  required i32            userId,         // 用户id 用于排除用户已看过的文章
}

// 文章详情参数
struct ArchivesContentParam {
    1:  required i32            id,             // id
    2:  optional i32            userId,         // 用户id
    3:  optional string         deviceId,       // 手机设备号
    4:  optional i32            deviceType,     // 类型（1-android；2-ios；3-html5）
    5:  optional string         readUserId,     // 已阅读用户的userid
}

// 文章阅读完成、未完成参数
struct ArchivesReadParam {
    1:  required i32            archId,         // 文章id
    2:  required i32            duration,       // 阅读时长 （秒）
    3:  optional i32            userId,         // 用户id
    4:  required i32            status,         // 1:完成，2：未完成
    5:  required string         deviceId,       // 手机设备号
    6:  required i32            deviceType,     // 类型（1-android；2-ios；3-html5）
}

struct ArchivesUserParam {
    1:  required i32            archId,         // 文章id
    2:  optional i32            userId,         // 用户id
    3:  required string         deviceId,       // 手机设备号
    4:  required i32            deviceType,     // 类型（1-android；2-ios；3-html5）
}

// 文章收藏
struct ArchivesCollectionParam {
    1:  required i32            archId,         // 文章id
    2:  required i32            userId,         // 用户id
    3:  required i32            valid,          // 收藏 valid=1，取消收藏 valid-0
    4:  optional string         modTime,        // 修改时间
}

// 文章点赞
struct ArchivesPraiseParam {
    1:  required i32            archId,         // 文章id
    2:  required i32            userId,         // 用户id
    3:  required i32            valid,          // 点赞 valid=1，取消点赞 valid=0
    4:  required string         deviceId,       // 手机设备地址
    5:  required i32            deviceType,     // 类型 1 = Android，2 = ios
}

// 评论参数回复
struct AnswerParam {
    1:  required i32            archId,         // 文章id
    2:  required i32            userIdAnswer,   // 回复用户id
    3:  required i32            commentId,      // 评论id
    4:  required string         content,        // 回复内容
    5:  required i32            userIdNotify,   // @用户id
    6:  optional string         answerTime,     // 回复时间
}

// 获取评论和回复参数
struct CommentListParam {
    1:  required i32            archId,         // 文章id
    3:  required i32            pageNumber,     // 页码
    4:  required i32            pageSize,       // 每页数据量
    5:  required i32            userId,         // 用户id
}

// 文章举报
struct ArchivesComplainParam {
    1:  required i32            archId,         // 文章id
    2:  optional i32            userId,         // 用户id
    3:  required string         reason,         // 举报原因
    4:  required string         deviceId,       // 手机设备地址
    5:  required i32            deviceType,     // 类型 1 = Android，2 = ios
}

// 文章转发
struct ArchivesShareParam {
    1:  optional i32            archId,         // 文章id
    2:  optional i32            userId,         // 用户id
    3:  required i32            target,         // 转发到 1：新浪，2：微信聊天，3：微信朋友圈，4：QQ聊天
    4:  required string         deviceId,       // 手机设备地址
    5:  required i32            deviceType,     // 类型 1 = Android，2 = ios
    6:  optional i32 			topicId			// 活动id
}

// 文章推荐
struct ArchivesPushParam {
    1:  required i32            userId,          // 用户id
    2:  required i32            pushNum,         // 推荐文章数量
    3:  required i32            pushType,        // 推荐类型，0 = 点击数，1 = 评论数，2 = 收藏数，3 = 转发数，4 = 阅读完成数
}

// 评论
struct ArchivesCommentParam {
    1:  required string         archId,          // 文章id
    2:  required string         deviceId,        // 设备id
    3:  required i32            deviceType,      // 设备类型（1-android；2-ios；3-html5）
    4:  required i32            userId,          // 用户id
    5:  required string         content,         // 内容
}
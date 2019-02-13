namespace java com.quwan.beebee.entity.topic

// 哔哔实体
struct Topic {
    1: required i32         id,                 // 主键
    2: required string      title,              // 话题标题
    3: optional string      content,            // 话题内容
    4: required i32         type,               // 类型：1-问答2-猜猜3-投票
    5: required i32         enable,             // 是否进行中
    6: required i32         click,              // 点击数
    7: required i32         comment,            // 评论数
    8: required i32         collection,         // 收藏数
    9: required i32         relay,              // 转发数
    10: required i32        praise              // 点赞数
    11: required i32        todayClick,         // 今日点击数
    12: required i32        todayComment,       // 今日评论数
    13: required i32        todayCollection,    // 今日收藏数
    14: required i32        todayRelay,         // 今日转发数
    15: required i32        todayPraise,        // 今日点赞数
    16: required i32        male,               // 男生数
    17: required i32        female,             // 女生数
    18: required i32        unknownSex,         // 未知性别数
    19: required string     addTime,            // 添加时间
    20: optional string     stopTime,           // 停止时间
    21: optional string     delTime,            // 删除时间
    22: required i32        addUserId,          // 添加用户id
    23: required i32        addUserType,        // 添加用户类型:1-后台用户；2-app用户
    24: required i32        stopUserId,         // 停止用户id
    25: required i32        delUserId,          // 删除用户id;用户自己删除时不记录，只记录后台用户id
    26: required i32        deleted,            // 是否删除
    27: required i32        sex,                // 性别，1-男2-女3-中性
    28: required string     img,                // 图片
    29: required string     replierIdentity,    // 希望回复者身份
    30: required i32        delType,            // 删除类型，1-正常删除2-举报删除
    31: required i32        multiSelect,        // 是否多选：1多选，0单选
    32: required i32        status,             // 1:发布2:合格3:不合格
    33: required string     unqualifiedReason,  // 不合格原因
    34: required string     pubTime,            // 发布时间
    35: optional string     topubTime,          // 定时发布时间
    36: required string     qualified,          // 审核状态文字合格、不合格、空
}

// 哔哔评论
struct TopicComment {
    1: required i32         id,                 // 主键
    2: required i32         topicId,            // 话题id
    3: required i32         userId,             // 用户id
    4: required string      content,            // 评论内容
    5: optional string      replierIdentity,    // 身份
    6: optional i32         identityId,         // 身份id
    7: required i32         parentId,           // 
    8: required i32         parentUserId,       // 
    9: required i32         praise,             // 点赞数
    10: required string      addTime,            // 添加时间
    11: optional string      img,                // 话题图片
}

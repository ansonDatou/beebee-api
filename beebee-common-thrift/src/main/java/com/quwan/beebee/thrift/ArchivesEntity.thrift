namespace java com.quwan.beebee.entity.archives

struct Archives {
    1:  required i32                    id,                      // 主键
    2:  optional string                 body,                    // 内容
    3:  required i32                    click,                   // 点击量
    4:  required i32                    comment,                 // 手机号
    5:  required i32                    collection,              // 收藏量
    6:  required i32                    relay,                   // 转发数
    7:  required i32                    readFinished,            // 完成阅读数
    8:  required i32                    readUnfinished,          // 未完成阅读数
    9:  required i32                    sortrank,                // 排序，越高的越靠前
    10: required string                 title,                   // 标题
    11: optional string                 shorttitle,              // 小标题
    12: optional string                 writer,                  // 作者
    13: optional string                 source,                  // 来源
    14: optional string                 largepic,                // 大图
    15: optional string                 litpic1                  // 小图1
    16: optional string                 litpic2                  // 小图2
    17: optional string                 litpic3,                 // 小图3
    18: optional string                 kapic,                   // 卡片式图片
    19: optional string                 pubtime,                 // 发布时间
    20: optional string                 addtime                  // 添加时间
    21: optional string                 deltime,                 // 删除时间
    22: optional string                 keywords,                // 关键字
    23: optional string                 tags,                    // 标签
    24: optional string                 adduser,                 // 添加用户
    25: optional i32                    adduserid,               // 添加用户id
    26: optional string                 sourceurl,               // 来源URL
    27: optional string                 cat1,                    // 分类1
    28: optional string                 cat2,                    // 分类2
    29: required i32                    isDelete,                // 是否删除
    30: required i32                    isTop,                   // 是否置顶
    31: optional string                 toptime,                 // 置顶时间
    32: optional string                 sourceKey,               // 源key
    33: optional i32                    pubuserid,               // 发布人id
    34: optional string                 orgTags,                 // 原始标签
    35: required i32                    quality,                 // 内容质量：1-低，2-中，3-高
    36: optional string                 videourl,                // 视频连接
    37: optional string                 content,                 // 自定格式内容
    38: required i32                    sourcetype,              // 内容类型：1-图文，2-视频，3-音频
    39: optional string                 desc,                    // 描述
    40: optional string                 qualified,               // 审核状态：合格-不合格-空
    41: optional i32                    onceUnqualified,         // 曾经不合格
    42: optional i32                    litpic4,                 // 小图4
    43: optional i32                    litpic5,                 // 小图5
    44: optional i32                    litpic6,                 // 小图6
    45: optional string                 unqualifiedReason,       // 不合格原因
    46: optional i32                    sex,                     // 性别
    47: optional i32                    praise,                  // 点赞数
    48: optional string                 readUserId,              // 已阅读该文章的用户id
}


struct Tag {
     1: required i32    id,   // 主键
     2: optional string tags, // 标签
     3: optional string cat1, // 分类
}

struct ArchivesTag {
     1: required i32    archId,   // 主键
     2: optional string tag,      // 标签
}

struct UserBehavior {
    1: required string      userId,         /*用户id*/
    2: required string      actObj,         /*行为对象:文章id*/
    3: required string      objType,        /*行为作用对象的类型 item*/
    4: required string      bhvType,        /*行为类型 view*/
    5: required double      bhvAmt,         /*用户对物品的评分 消费 观看时长*/
    6: required double      bhvCnt,         /*行为次数*/
    7: required string      bhvDateTime,    /*行为发生的时间 UTC格式*/
    8: optional string      content,        /*行为的具体内容*/
    9: optional string      posType,
    10: optional string     position,
    11: optional string     env,
    12: optional string     traceId,
    13: optional string     plates,
}

struct ArchivesCollection {
    1: required i32     id,         /*主键*/
    2: required i32     archId,     /*文章id*/
    3: required i32     userId,     /*用户id*/
    4: required i32     valid,      /*生效状态(0:无效；1:生效))*/
    5: required string  modtime,    /*修改时间*/
    6: required string  addtime,    /*添加时间*/
}

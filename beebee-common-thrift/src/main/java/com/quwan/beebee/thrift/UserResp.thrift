namespace java com.quwan.beebee.resp.user

// 用户历史浏览文章
struct HistoryArchivesResp {
    1:  optional i32            id,             // 文章id
    2:  optional string         cat1,           // 分类1
    3:  optional i32            click,          // 点击数
    4:  optional i32            comment,        // 评论数
    5:  optional string         largePic,       // 大图
    6:  optional string         litPic1,        // 小图1
    7:  optional string         litPic2,        // 小图2
    8:  optional string         litPic3,        // 小图3
    9:  optional string         modTime,        // 修改时间
    10:  optional string        pubTime,        // 发布时间
    11:  optional string        source,         // 来源
    12:  optional string        sourceType,     // 来源类型
    13:  optional string        tags,           // 标签
    14:  optional string        title,          // 标题
    15:  optional string        videoUrl,       // 视频URL
    16:  optional string        writer,         // 作者
}
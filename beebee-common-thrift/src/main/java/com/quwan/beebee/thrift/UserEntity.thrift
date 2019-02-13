namespace java com.quwan.beebee.entity.user

// 用户实体
struct User {
    1:  required i32                    id,                         // 主键
    2:  required string                 pwd,                        // 密码
    3:  required string                 uName,                      // 用户名
    4:  required string                 email,                      // email
    5:  required string                 mobile,                     // 手机
    6:  required string                 nicker,                     // 昵称
    7:  required string                 addTime,                    // 添加时间
    8:  required string                 loginTime,                  // 最后登录时间
    9:  required string                 loginIp,                    // 最后登录ip
    10: required string                 deviceId,                   // 设备id
    11: required i32                    deviceType,                 // 设备类型（1-android；2-ios；3-html5）
    12: optional i32                    age,                        // 年龄
    13: optional i32                    sex,                        // 性别
    14: optional string                 region,                     // 地区
    15: optional i32                    comment,                    // 评论数
    16: optional i32                    collection,                 // 收藏数
    17: optional i32                    relay,                      // 转发数
    18: optional i32                    useDuration,                // 使用时长
    19: optional string                 birthday,                   // 生日
    20: optional string                 head,                       // 头像
    21: optional i32                    integral,                   // 积分
    22: optional i32                    inviteId,                   // 邀请人id
    23: optional i32                    praise,                     // 点赞数
    24: optional string                 platType,                   // 登录平台
    25: optional string                 platuId,                    // 登录平台的用户id
    26: optional string                 openId,                     // 登录平台的openid
    27: optional string                 unionId,                    // 登录平台的unionid
    28: optional string                 accessToken,                // 登录平台的accesstoken
    29: required string                 refreshToken,               // 登录平台的refreshtoken
    30: required string                 expiration,                 // 登录平台的token过期时间
    31: optional string                 signature,                  // 个性签名
    32: optional i32                    todaySignIn,				// 今天是否签到
    33: optional i32                    signInDays					// 签到天数
}

// 用户签到日志
struct UserSigninLog {
    1:  required i32                    id,                         // 主键
    2:  required i32                    userId,                     // 用户id
    3:  required string                 signDate,                   // 签到日期
    4:  required string                 addTime,                    // 添加时间
}

// 用户身份
struct UserIdentity {
    1:  required i32                    id,                         // 主键
    2:  required i32                    userId,                     // 用户id
    3:  required string                 identity,                   // 身份
    4:  required string                 color,                      // 颜色
    5:  required i32                    isHide,                     // 是否隐藏
    6:  required string                 addTime,                    // 添加时间
}
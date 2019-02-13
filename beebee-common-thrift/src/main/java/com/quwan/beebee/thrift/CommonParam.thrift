namespace java com.quwan.beebee.param.common

// 验证码参数
struct AuthcodeParam {
    1:  required string            mobile,          // 用户手机号
    2:  required string            type,            // 验证码类型
    3:  optional string            authcode,        // 验证码
    4:  optional string            addTime,         // 添加时间
    5:  optional string            used,            // 是否已使用
}

// 获取banner
struct GetBannerParam {
	1: required i32               block,			 //模块：1-溜溜;2-哔哔
	2: required i32               type,   			 //类型：1-文章；2-活动；3-广告
	3: required string            classify,          // 分类
}

// 上传图片-陈晓婵-2018年1月9日20:09:20
struct UploadImgParam {
	1: required i32               userId,			 // 用户id
	2: required string            data 				 // 数据流
}

// 文本检测 -2018年1月9日20:09:20
struct CheckTextParam {
	1: required i32               userId,			 // 用户id
	2: required string            content 	         // 文本内容
}

// 图片检测 -2018年1月9日20:09:20
struct CheckImageParam {
	1: required list<string>               url			 // 图片url
}

// 短信下发 -2018年1月15日16:13:43
struct SendMsgParam {
    1:  required string            phone,            // 手机号码
    2:  optional string            msg               // 短信内容
}

// 用户反馈 -2018年2月7日10:49:34
struct UserFeedBackParam {
    1:  required string            content,          // 反馈信息
    2:  optional i32               userId,           // 用户
    3:  optional string            deviceId,         // 手机设备号
    4:  optional i32               deviceType,       // 类型（1-android；2-ios；3-html5）
    5:  optional string            phone,            // 手机号
    6:  optional string            email,            // 邮箱
    7:  optional string            qq                // QQ
}


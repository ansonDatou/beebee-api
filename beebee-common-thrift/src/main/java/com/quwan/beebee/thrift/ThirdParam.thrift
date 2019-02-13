namespace java com.quwan.beebee.param.third

// 验证码参数
struct AuthcodeParam {
    1:  required string            mobile,          // 用户手机号
    2:  required string            type,            // 验证码类型
    3:  optional string            authcode,        // 验证码
    4:  optional string            addTime,         // 添加时间
    5:  optional string            used,            // 是否已使用
}

// 文本检测 -2018年1月9日20:09:20
struct CheckTextParam {
	1: required i32               userId,			 // 用户id
	2: required string            content 	         // 文本内容
}

// 图片检测 -2018年1月9日20:09:20
struct CheckImageParam {
	1: required list<string>       url			     // 图片url
}

// 短信下发 -2018年1月15日16:13:43
struct SendMsgParam {
    1:  required string            phone,            // 手机号码
    2:  optional string            msg               // 短信内容
}


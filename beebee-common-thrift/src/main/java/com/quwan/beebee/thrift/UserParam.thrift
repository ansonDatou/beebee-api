namespace java com.quwan.beebee.param.user

// 用户注册参数
struct RegisterParam {
    1:  required string            mobile,          // 用户手机号
    2:  required string            pwd,             // 用户密码
    3:  required string            authCode,        // 验证码
    4:  required string            deviceId,        // 设备id
    5:  required i32               deviceType,      // 设备类型（1-android；2-ios；3-html5）
    6:  optional string            addTime,         // 注册时间，无需前端传递
}

// 用户登录参数
struct LoginParam {
    1:  required string            mobile,          // 用户手机号
    2:  required string            pwd,             // 用户密码
    3:  required string            deviceId,        // 设备id
    4:  required i32               deviceType,      // 设备类型（1-android；2-ios；3-html5）
    5:  required string            loginIp,         // 登录ip，无需传入
}

// 历史记录参数
struct HistoryArchivesParam {
    1:  required i32            userId,         // 用户id
    2:  required i32            pageNumber,     // 页码
    3:  required i32            pageSize,       // 每页数据量
}

// 用户修改密码
struct ModifyPwdParam {
    1:  required i32               userId,         // 用户id
    2:  required string            mobile,         // 手机号
    3:  required string            oldPwd,         // 旧密码
    4:  required string            pwd,            // 新密码
}

// 更新用户资料
struct UpdateUserParam {
    1:  required i32               userId,         // 用户id
    2:  optional string            nicker,         // 用户昵称
    3:  optional i32               sex,            // 性别
    4:  optional string            birthday,       // 生日
    5:  optional string            region ,        // 地区
    6:  optional string            signature ,     // 个人简介
    7:  optional string            head ,          // 头像
}

// 用户忘记密码
struct RetrievePwdParam {
    1:  required string            mobile,         // 手机号
    2:  required string            authcode,       // 验证码
    3:  required string            pwd,            // 新密码
}

// 查询用户积分列表
struct IntegralListParam {
    1:  required i32            userId,         // 用户id
    2:  required i32            pageNumber,     // 页码
    3:  required i32            pageSize,       // 每页数据量
}


// 更新用户头像-陈晓婵-2017年12月22日15:02:53
struct UpdateHeadParam {
 	1:  required i32            userId,         // 用户id
 	2:  required string         data,           //图片二进制流
 	3:  optional string         type,           //类型
 	4:  optional string         mimeType
}

// 用户开启权限-陈晓婵-2017年12月22日16:24:07
struct SetwitchParam {
    1:  required i32            userId,         // 用户id
    2:  required i32            type,           //打开类型 1:推送；2:定位；3:通讯录
    3:  required i32            valid           //1开启；0关闭
}

// 获得花朵-陈晓婵-2017年12月22日16:50:47
struct GetTaskListParam {
    1:  required i32            userId         // 用户id
}

// 我的收藏
struct CollectionParam {
    1:  required i32            userId,         // 用户id
    2:  required i32            valid,          // 有效
    3:  required i32            pageNumber,     // 页码
    4:  required i32            pageSize,       // 每页数据量
}

// 密封集市-商品列表参数
struct GoodsListParam {
    1:  required i32            pageNumber,     // 页码
    2:  required i32            pageSize,       // 每页数据量
}

// 获取我的订单列表
struct OrderListParam {
    1:  required i32            userId,         // 用户id
    2:  required i32            pageNumber,     // 页码
    3:  required i32            pageSize,       // 每页数据量
}

// 消息模块param-陈晓婵-2017年12月23日10:11:39
struct NotificationParam {
	1:  required i32            pageNumber,     // 页码
    2:  required i32            pageSize,       // 每页数据量
    3:  required i32            userId,         // 用户id
}

// 兑换商品-陈晓婵-2017年12月23日17:04:09
struct ExchangeParam {
	1: required i32            userId,         // 用户id
	2: required string         phone,	       // 电话
	3: required i32            goodsId,        // 商品id
	4: required i32            goodsNumber,    // 商品数量
	5: required string         address,        // 地址
	6: required string         consignee,      //姓名
	7: optional i32            amount          //金额
	8: optional string         sn              //编号
}

// 批量插入或更新用户标签
struct SaveUserTagsParam {
    1:  required i32            userId,         // 用户id
    2:  required string         tag,            // 标签
    3:  required string         modifyTime      // 修改时间
}

// 修改用户积分-陈晓婵-2018年1月12日13:07:28
struct UpdateIntegralParam {
    1:  required i32            userId,         // 用户id
    2:  required i32            integral		//用户积分
}

// 个人主页
struct UserPersonalPageParam {
	1:  required i32            userId,         // 用户id
	2:  required i32            targetUserId    // 目标用户id
}

// 个人主页 - 身份墙 - 修改身份隐藏状态
struct HideUserIdentitysParam {
	1:  required i32            userId,         // 用户id
	2:  required string         identityIds     // 要隐藏的身份，字符串以”，“隔开
}

// 个人主页 - 根据用户id和身份id查询参与的哔哔
struct GetCommentsByUserIdentityParam {
	1:  required i32            targetUserId,   // 目标用户id
	2:  required i32            identityId      // 身份id
    3:  required i32            pageNumber,     // 页码
    4:  required i32            pageSize,       // 每页数据量
}

// 用户动态
struct UserDynamicParam {
	1:  required i32            userId,         // 用户id
	2:  required i32            targetUserId    // 目标用户id
	3:  required i32            type            // 类型：1-参与的哔哔2-发起的哔哔3-进行的回复
	4:  required i32            pageNumber,     // 页码
    5:  required i32            pageSize,       // 每页数据量
}

// 红包
struct RedPacketParam {
    1:  required i32            money,           //红包金额
    2:  required i32            type             //红包类型
}

// 黑名单
struct BlacklistParam {
    1:  required i32            userId,           // 用户id
    2:  required i32            blackUserId,      // 被拉入黑名单的用户id
    3:  required string         blackUserNickname // 被拉入黑名单的用户昵称
}
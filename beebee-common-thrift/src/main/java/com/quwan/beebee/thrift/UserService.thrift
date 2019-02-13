namespace java com.quwan.beebee.service.user

include "UserParam.thrift"
include "UserResp.thrift"
include "UserEntity.thrift"

service UserService {

    // 用户注册接口
    string registering(1: required UserParam.RegisterParam param);

    // 用户登录接口
    string login(1: required UserParam.LoginParam param);

    // 通过userId获取User接口
    string getDetail(1: required i32 userId);

    // 获取用户的历史浏览记录
    string getReadedList(1: UserParam.HistoryArchivesParam param);

    // 用户修改密码
    string modifyPwd(1: UserParam.ModifyPwdParam param);

    // 修改用户资料
    string update(1: UserParam.UpdateUserParam param);

    // 用户忘记密码
    string retrievePwd(1: UserParam.RetrievePwdParam param);

    // 用户签到
    string signed(1: i32 userId);

    // 获取积分列表
    string getIntegralList(1: UserParam.IntegralListParam param);

    // 更换用户头像-陈晓婵-2017年12月22日14:45:00
    string updateHead(1: UserParam.UpdateHeadParam param);

    // 用户开启权限-陈晓婵-2017年12月22日16:28:07
    string setwitch(1: UserParam.SetwitchParam param);

    // 获得花朵-陈晓婵-2017年12月22日20:31:41
    string getTaskList(1: UserParam.GetTaskListParam param);

    // 获取我的收藏
    string getCollectionList(1: UserParam.CollectionParam param);

    // 蜜蜂集市-获取商品列表
    string getGoodsList(1: UserParam.GoodsListParam param);

    // 蜜蜂集市-获取商品详情
    string getGoodsDetail(1: i32 goodsId);

    // 获取我的订单列表
    string getOrderList(1: UserParam.OrderListParam param);

    // 获取我的订单详情
    string getOrderDetail(1: i32 orderId);

    // 系统消息-陈晓婵-2017年12月23日10:15:11
    string getNotificationList(1:UserParam.NotificationParam param);

    // 我的评论-陈晓婵-2017年12月23日10:16:16
    string getMineCommentList(1:UserParam.NotificationParam param);

    // 兑换商品-陈晓婵-2017年12月23日17:08:21
    string exchange(1:UserParam.ExchangeParam param);

    // 个人主页-个人信息
    string getUserPersonalPage(1:UserParam.UserPersonalPageParam param);

    //个人主页 - 身份墙 - 修改身份隐藏状态
    string hideUserIdentitys(1:UserParam.HideUserIdentitysParam param);

    //个人主页 - 根据用户id和身份id查询参与的哔哔
    string getCommentsByUserIdentity(1:UserParam.GetCommentsByUserIdentityParam param);

    // 个人主页-动态
    string getUserDynamic(1:UserParam.UserDynamicParam param);

    // 红包
    string checkRedPacket(1:UserParam.RedPacketParam param);

    // 加入黑名单
    string addBlacklist(1: UserParam.BlacklistParam param);

    // 移除黑名单
    string removeBlackList(1: UserParam.BlacklistParam param);

    // 黑名单列表
    string getBlackList(1: UserParam.NotificationParam param);
}
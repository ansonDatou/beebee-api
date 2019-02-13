package com.quwan.beebee.controller;


import com.quwan.beebee.common.Method;
import com.quwan.beebee.common.Server;
import com.quwan.beebee.param.user.*;
import com.quwan.beebee.utils.EurekaUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * user模块，thrift方式，调用者
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private EurekaUtil eurekaUtil;

    /**
     * 用户注册
     * @param param
     * @return
     */
    @PostMapping("/register")
    public String register(RegisterParam param) {
        return eurekaUtil.remoteInvoke(Server.BEEBEE_USER_THRIFT_PROVIDER_CLIENT, Method.USER_REGISTER, param);
    }

    /**
     * 用户登录
     * @param param
     * @return
     */
    @PostMapping("/login")
    public String login(LoginParam param) {
        return eurekaUtil.remoteInvoke(Server.BEEBEE_USER_THRIFT_PROVIDER_CLIENT, Method.USER_LOGIN, param);
    }

    /**
     * 用户修改密码
     * @param param
     * @return
     */
    @PostMapping("/modifyPwd")
    public String modifyPwd(ModifyPwdParam param) {
        return eurekaUtil.remoteInvoke(Server.BEEBEE_USER_THRIFT_PROVIDER_CLIENT, Method.USER_MODIFY_PWD, param);
    }

    /**
     * 用户登出
     * @param
     * @return
     */
    @PostMapping("/logout")
    public String logout() {
        return eurekaUtil.remoteInvoke(Server.BEEBEE_USER_THRIFT_PROVIDER_CLIENT, Method.USER_LOGOUT, null);
    }

    /**
     * 用户详情
     * @param
     * @return
     */
    @PostMapping("/getDetail")
    public String getDetail(Integer userId) {
        return eurekaUtil.remoteInvoke(Server.BEEBEE_USER_THRIFT_PROVIDER_CLIENT, Method.USER_GET_DETAIL, userId);
    }

    /**
     * 用户浏览历史列表
     * @param
     * @return
     */
    @PostMapping("/getReadedList")
    public String getReadedList(HistoryArchivesParam param) {
        return eurekaUtil.remoteInvoke(Server.BEEBEE_USER_THRIFT_PROVIDER_CLIENT, Method.USER_GET_READED_LIST, param);
    }

    /**
     * 跟新用户资料
     * @param
     * @return
     */
    @PostMapping("/update")
    public String update(UpdateUserParam param) {
        return eurekaUtil.remoteInvoke(Server.BEEBEE_USER_THRIFT_PROVIDER_CLIENT, Method.USER_UPDATE, param);
    }

    /**
     * 忘记密码
     * @param param
     * @return
     */
    @PostMapping("/retrievePwd")
    public String retrievePwd(RetrievePwdParam param) {
        return eurekaUtil.remoteInvoke(Server.BEEBEE_USER_THRIFT_PROVIDER_CLIENT, Method.USER_RETRIEVE_PWD, param);
    }

    /**
     * 用户签到
     * @param userId
     * @return
     */
    @PostMapping("/signed")
    public String signed(Integer userId) {
        return eurekaUtil.remoteInvoke(Server.BEEBEE_USER_THRIFT_PROVIDER_CLIENT, Method.USER_SIGNED, userId);
    }

    /**
     * 查询用户积分列表
     * @param
     * @return
     */
    @PostMapping("/getIntegralList")
    public String getIntegralList(IntegralListParam param) {
        return eurekaUtil.remoteInvoke(Server.BEEBEE_USER_THRIFT_PROVIDER_CLIENT, Method.USER_GET_INTEGRAL_LIST, param);
    }

    /**
     * 更新用户头像
     * 陈晓婵
     * @param param
     * @return
     */
    @PostMapping("/updateHead")
    public String updateHead(UpdateHeadParam param) {
        return eurekaUtil.remoteInvoke(Server.BEEBEE_USER_THRIFT_PROVIDER_CLIENT, Method.USER_UPDATE_HEAD, param);
    }

    /**
     *
     * @param param
     * @return
     */
    @PostMapping("/setwitch")
    public String setwitch(SetwitchParam param) {
        return eurekaUtil.remoteInvoke(Server.BEEBEE_USER_THRIFT_PROVIDER_CLIENT, Method.USER_SET_WITCH, param);
    }

    /**
     * 我的收藏
     * @param param
     * @return
     */
    @PostMapping("/getCollectionList")
    public String getCollectionList(CollectionParam param) {
        return eurekaUtil.remoteInvoke(Server.BEEBEE_USER_THRIFT_PROVIDER_CLIENT, Method.USER_GET_COLLECTION_LIST, param);
    }

    /**
     * 蜜蜂集市-获取商品列表
     * @param param
     * @return
     */
    @PostMapping("/getGoodsList")
    public String getGoodsList(GoodsListParam param) {
        return eurekaUtil.remoteInvoke(Server.BEEBEE_USER_THRIFT_PROVIDER_CLIENT, Method.USER_GET_GOODS_LIST, param);
    }

    /**
     * 蜜蜂集市-获取商品列表
     * @param goodsId
     * @return
     */
    @PostMapping("/getGoodsDetail")
    public String getGoodsDetail(Integer goodsId) {
        return eurekaUtil.remoteInvoke(Server.BEEBEE_USER_THRIFT_PROVIDER_CLIENT, Method.USER_GET_GOODS_DETAIL, goodsId);
    }

    /**
     * 蜜蜂集市-获取商品列表
     * @param param
     * @return
     */
    @PostMapping("/getOrderList")
    public String getOrderList(OrderListParam param) {
        return eurekaUtil.remoteInvoke(Server.BEEBEE_USER_THRIFT_PROVIDER_CLIENT, Method.USER_GET_ORDER_LIST, param);
    }

    /**
     * 蜜蜂集市-获取商品列表
     * @param orderId
     * @return
     */
    @PostMapping("/getOrderDetail")
    public String getOrderDetail(Integer orderId) {
        return eurekaUtil.remoteInvoke(Server.BEEBEE_USER_THRIFT_PROVIDER_CLIENT, Method.USER_GET_ORDER_DETAIL, orderId);
    }

    /**
     * 系统通知
     * 陈晓婵
     * @param param
     * @return
     */
    @PostMapping("/getNotificationList")
    public String getNotificationList(NotificationParam param) {
        return eurekaUtil.remoteInvoke(Server.BEEBEE_USER_THRIFT_PROVIDER_CLIENT, Method.USER_GET_NOTIFICATION_LIST, param);
    }

    /**
     * 我的评论
     * 陈晓婵
     * @param param
     * @return
     */
    @PostMapping("/getMineCommentList")
    public String getMineCommentList(NotificationParam param) {
        return eurekaUtil.remoteInvoke(Server.BEEBEE_USER_THRIFT_PROVIDER_CLIENT, Method.USER_GET_MINE_COMMENT_LIST, param);
    }

    /**
     * 兑换商品
     * 陈晓婵
     * @param param
     * @return
     */
    @PostMapping("/exchange")
    public String exchange(ExchangeParam param) {
        return eurekaUtil.remoteInvoke(Server.BEEBEE_USER_THRIFT_PROVIDER_CLIENT, Method.USER_EXCHANGE, param);
    }

    /**
     * 获取花朵-陈晓婵-2018年1月10日21:46:06
     * @param param
     * @return
     */
    @PostMapping("/getTaskList")
    public String getTaskList(GetTaskListParam param){
        return eurekaUtil.remoteInvoke(Server.BEEBEE_USER_THRIFT_PROVIDER_CLIENT, Method.USER_GET_TASK_LIST, param);
    }

    /**
     * @Title: getUserPersonalPage
     * @Description: 查询用户个人主页信息
     * @author 李静
     */
    @PostMapping("/getUserPersonalPage")
    public String getUserPersonalPage(UserPersonalPageParam param){
        return eurekaUtil.remoteInvoke(Server.BEEBEE_USER_THRIFT_PROVIDER_CLIENT, Method.USER_GET_USER_PERSONAL_PAGE, param);
    }

    /**
     * @Title: hideUserIdentitys
     * @Description: 个人主页 - 身份墙 - 修改身份隐藏状态
     * @param param
     * @return String    返回类型
     * @author 李静
     */
    @PostMapping("/hideUserIdentitys")
    public String hideUserIdentitys(HideUserIdentitysParam param){
        return eurekaUtil.remoteInvoke(Server.BEEBEE_USER_THRIFT_PROVIDER_CLIENT, Method.USER_HIDE_USER_IDENTITYS, param);
    }

    /**
     * @Title: getCommentsByUserIdentity
     * @Description: 根据用户id和身份id查询参与的哔哔
     * @param param
     * @return String    返回类型 
     * @author 李静
     */
    @PostMapping("/getCommentsByUserIdentity")
    public String getCommentsByUserIdentity(GetCommentsByUserIdentityParam param){
        return eurekaUtil.remoteInvoke(Server.BEEBEE_USER_THRIFT_PROVIDER_CLIENT, Method.USER_GET_COMMENTS_BY_USER_IDENTITY, param);
    }


    /**
     * @Title: getUserPersonalPage
     * @Description: 查询用户个人主页信息
     * @author 李静
     */
    @PostMapping("/getUserDynamic")
    public String getUserDynamic(UserDynamicParam param){
        return eurekaUtil.remoteInvoke(Server.BEEBEE_USER_THRIFT_PROVIDER_CLIENT, Method.USER_GET_USER_DYNAMIC, param);
    }

    /**
     * @Title: addBlacklist
     * @Description: 加入黑名单
     * @author 张植富
     */
    @PostMapping("/addBlacklist")
    public String addBlacklist(BlacklistParam param){
        return eurekaUtil.remoteInvoke(Server.BEEBEE_USER_THRIFT_PROVIDER_CLIENT, Method.USER_ADD_BLACKLIST, param);
    }

    /**
     * 移除黑名单
     * @param param
     * @return
     */
    @PostMapping("removeBlacKList")
    public String removeBlacKList(BlacklistParam param){
        return eurekaUtil.remoteInvoke(Server.BEEBEE_USER_THRIFT_PROVIDER_CLIENT, Method.USER_REMOVE_BLACKLIST, param);
    }

    /**
     * 黑名单列表
     * @param param
     * @return
     */
    @PostMapping("getBlacKList")
    public String getBlacKList(BlacklistParam param){
        return eurekaUtil.remoteInvoke(Server.BEEBEE_USER_THRIFT_PROVIDER_CLIENT, Method.USER_GET_BLACKLIST, param);
    }
}

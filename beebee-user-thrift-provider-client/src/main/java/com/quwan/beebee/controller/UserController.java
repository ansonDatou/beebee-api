package com.quwan.beebee.controller;


import com.alibaba.fastjson.JSON;
import com.quwan.beebee.common.Constants;
import com.quwan.beebee.common.Method;
import com.quwan.beebee.common.Server;
import com.quwan.beebee.param.user.*;
import com.quwan.beebee.utils.Result;
import com.quwan.beebee.utils.ThriftUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by anson on 2017/10/9.
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private ThriftUtil thriftUtil;

    /**
     * 用户注册
     * @param param
     * @return
     */
    @PostMapping("/register")
    public String register(@RequestBody RegisterParam param) {
        return thriftUtil.remoteInvoke("register", param);
    }

    /**
     * 用户登录
     * @param param
     * @return
     */
    @PostMapping("/login")
    public String login(@RequestBody LoginParam param, HttpServletRequest request) {
        param.setLoginIp(request.getRemoteHost());
        return thriftUtil.remoteInvoke("login", param);
    }

    /**
     * 用户修改密码
     * @param param
     * @return
     */
    @PostMapping("/modifyPwd")
    public String modifyPwd(@RequestBody ModifyPwdParam param) {
        return thriftUtil.remoteInvoke("modifyPwd", param);
    }

    /**
     * 用户登出
     * @param
     * @return
     */
    @PostMapping("/logout")
    public String logout(HttpServletRequest request) {
        request.getSession().setAttribute(Constants.SESSION_USER, null);
        return JSON.toJSONString(Result.success());
    }

    /**
     * 用户详情 getDetail
     * @param userId
     * @return
     */
    @PostMapping("/getDetail")
    public String getDetail(@RequestBody Integer userId) {
        return thriftUtil.remoteInvoke("getDetail", userId);
    }

    /**
     * 查询用户历史浏览记录
     * @param
     * @return
     */
    @PostMapping("/getReadedList")
    public String getReadedList(@RequestBody HistoryArchivesParam param) {
        return thriftUtil.remoteInvoke("getReadedList", param);
    }

    /**
     * 修改用户资料
     * @param
     * @return
     */
    @PostMapping("/update")
    public String update(@RequestBody UpdateUserParam param) {
        return thriftUtil.remoteInvoke("update", param);
    }

    /**
     * 忘记密码
     * @return
     */
    @PostMapping("/retrievePwd")
    public String retrievePwd(@RequestBody RetrievePwdParam param) {
        return thriftUtil.remoteInvoke("retrievePwd", param);
    }

    /**
     * 用户签到
     * @param userId
     * @return
     */
    @PostMapping("/signed")
    public String signed(@RequestBody Integer userId) {
        return thriftUtil.remoteInvoke("signed", userId);
    }

    /**
     * 获取积分列表
     * @param param
     * @return
     */
    @PostMapping("/getIntegralList")
    public String getIntegralList(@RequestBody IntegralListParam param) {
        return thriftUtil.remoteInvoke("getIntegralList", param);
    }

    /**
     * 更新用户头像-陈晓婵-2017年12月22日15:49:39
     *
     * @param param
     * @return
     */
    @PostMapping("/updateHead")
    public String updateHead(@RequestBody UpdateHeadParam param) {
        return thriftUtil.remoteInvoke("updateHead", param);
    }

    /**
     *修改用户权限-陈晓婵-2018年1月4日15:53:45
     * @param param
     * @return
     */
    @PostMapping("/setwitch")
    public String setwitch(@RequestBody SetwitchParam param) {
        return thriftUtil.remoteInvoke("setwitch", param);
    }

    /**
     * 我的收藏
     *
     * @param param
     * @return
     */
    @PostMapping("/getCollectionList")
    public String getCollectionList(@RequestBody CollectionParam param) {
        return thriftUtil.remoteInvoke("getCollectionList", param);
    }

    /**
     * 蜜蜂集市-获取商品列表
     *
     * @param param
     * @return
     */
    @PostMapping("/getGoodsList")
    public String getGoodsList(@RequestBody GoodsListParam param) {
        return thriftUtil.remoteInvoke("getGoodsList", param);
    }

    /**
     * 蜜蜂集市-获取商品列表
     *
     * @param goodsId
     * @return
     */
    @PostMapping("/getGoodsDetail")
    public String getGoodsDetail(@RequestBody Integer goodsId) {
        return thriftUtil.remoteInvoke("getGoodsDetail", goodsId);
    }

    /**
     * 蜜蜂集市-获取商品列表
     *
     * @param param
     * @return
     */
    @PostMapping("/getOrderList")
    public String getOrderList(@RequestBody OrderListParam param) {
        return thriftUtil.remoteInvoke("getOrderList", param);
    }

    /**
     * 蜜蜂集市-获取商品列表
     *
     * @param orderId
     * @return
     */
    @PostMapping("/getOrderDetail")
    public String getOrderDetail(@RequestBody Integer orderId) {
        return thriftUtil.remoteInvoke("getOrderDetail", orderId);
    }

    /**
     * 系统通知-陈晓婵-2017年12月23日14:17:45
     *
     * @param param
     * @return
     */
    @PostMapping("/getNotificationList")
    public String getNotificationList(@RequestBody NotificationParam param) {
        return thriftUtil.remoteInvoke("getNotificationList", param);
    }

    /**
     * 我的评论-陈晓婵-2017年12月23日14:29:23
     *
     * @param param
     * @return
     */
    @PostMapping("/getMineCommentList")
    public String getMineCommentList(@RequestBody NotificationParam param) {
        return thriftUtil.remoteInvoke("getMineCommentList", param);
    }

    /**
     * 兑换商品-陈晓婵-2017年12月23日19:47:48
     *
     * @param param
     * @return
     */
    @PostMapping("/exchange")
    public String exchange(@RequestBody ExchangeParam param) {
        return thriftUtil.remoteInvoke("exchange", param);
    }
    
    /**
     * 获取花朵-陈晓婵-2018年1月10日21:46:06
     * @param param
     * @return
     */
    @PostMapping("/getTaskList")
    public String getTaskList(@RequestBody GetTaskListParam param){
    	return thriftUtil.remoteInvoke("getTaskList", param);
    }

    /**
	* @Title: getUserPersonalPage
	* @Description: 查询用户个人主页信息
	* @author 李静
	 */
    @PostMapping("/getUserPersonalPage")
    public String getUserPersonalPage(@RequestBody UserPersonalPageParam param){
    	return thriftUtil.remoteInvoke("getUserPersonalPage", param);
    }

    /**
    * @Title: hideUserIdentitys
    * @Description: 个人主页 - 身份墙 - 修改身份隐藏状态
    * @param param
    * @return String    返回类型
    * @author 李静
     */
    @PostMapping("/hideUserIdentitys")
    public String hideUserIdentitys(@RequestBody HideUserIdentitysParam param){
    	return thriftUtil.remoteInvoke("hideUserIdentitys", param);
    }

    /**
    * @Title: getCommentsByUserIdentity 
    * @Description: 根据用户id和身份id查询参与的哔哔  
    * @param param
    * @return String    返回类型 
    * @author 李静
     */
    @PostMapping("/getCommentsByUserIdentity")
    public String getCommentsByUserIdentity(@RequestBody GetCommentsByUserIdentityParam param){
    	return thriftUtil.remoteInvoke("getCommentsByUserIdentity", param);
    }


    /**
     * @Title: getUserPersonalPage
     * @Description: 查询用户个人主页信息
     * @author 李静
     */
    @PostMapping("/getUserDynamic")
    public String getUserDynamic(@RequestBody UserDynamicParam param){
    	return thriftUtil.remoteInvoke("getUserDynamic", param);
    }

    /**
     * 检查红包
     * @param param
     * @return
     */
    @PostMapping("/checkRedPacket")
    public String checkRedPacket(@RequestBody RedPacketParam param) { return thriftUtil.remoteInvoke("checkRedPacket", param);}

    /**
     * @Title: addBlacklist
     * @Description: 加入黑名单
     * @author 张植富
     */
    @PostMapping("/addBlacklist")
    public String addBlacklist(@RequestBody BlacklistParam param){
        return thriftUtil.remoteInvoke("addBlacklist", param);
    }

    /**
     * 移除黑名单
     * @param param
     * @return
     */
    @PostMapping("removeBlackList")
    public String removeBlackList(@RequestBody BlacklistParam param){
        return thriftUtil.remoteInvoke("removeBlackList", param);
    }

    /**
     * 黑名单列表
     * @param param
     * @return
     */
    @PostMapping("getBlackList")
    public String getBlackList(@RequestBody NotificationParam param){
        return thriftUtil.remoteInvoke("getBlackList", param);
    }

}

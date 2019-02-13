
package com.quwan.beebee.user;

import java.util.HashMap;
import java.util.Map;
import com.quwan.beebee.HttpPostService;
import org.junit.Test;

/**
 * 测试User模块
 */
public class JunitTest {

    private static final String PORT = "10321";

    /**
     * 用户注册
     */
    @Test
    public void register() {
        Map<String, String> param = new HashMap<String, String>();
        param.put("mobile", "13132900244");
        param.put("pwd", "111111");
        param.put("authcode", "4736");
        HttpPostService.testService(param, PORT, "/user/register");
    }

    /**
     * 用户登录
     */
    @Test
    public void login() {
        Map<String, String> param = new HashMap<String, String>();
        param.put("mobile", "13132900244");
        param.put("pwd", "111111");
        param.put("deviceId", "123");
        param.put("deviceType", "1");
        param.put("loginIp", "192.168.0.1");
        HttpPostService.testService(param, PORT, "/user/login");
    }

    /**
     * 修改密码
     */
    @Test
    public void modifyPwd() {
        Map<String, String> param = new HashMap<String, String>();
        param.put("userId", "2");
        param.put("mobile", "13132900211");
        param.put("oldPwd", "111111");
        param.put("pwd", "123456");
        HttpPostService.testService(param, PORT, "/user/modifyPwd");
    }

    /**
     * 退出
     */
    @Test
    public void logout() {
        Map<String, String> param = new HashMap<String, String>();
        param.put("userId", "2");
        HttpPostService.testService(param, PORT, "/user/logout");
    }

    /**
     * 获取用户详情
     */
    @Test
    public void getDetail() {
        Map<String, String> param = new HashMap<String, String>();
        param.put("userId", "64");
        HttpPostService.testService(param, PORT, "/user/getDetail");
    }

    /**
     * 用户浏览历史记录
     */
    @Test
    public void getReadedList() {
        Map<String, String> param = new HashMap<String, String>();
        param.put("userId", "487");
        param.put("pageNumber", "1");
        param.put("pageSize", "10");
        HttpPostService.testService(param, PORT, "/user/getReadedList");
    }

    /**
     * 修改用户信息
     */
    @Test
    public void update() {
        Map<String, String> param = new HashMap<String, String>();
        param.put("userId", "2");
        param.put("nickname", "qaz1230");
        param.put("sex", "1");
        param.put("birthday", "1991-09-02");
        param.put("region", "北京");
        HttpPostService.testService(param, PORT, "/user/update");
    }

    /**
     * 忘记密码
     */
    @Test
    public void retrievePwd() {
        Map<String, String> param = new HashMap<String, String>();
        param.put("mobile", "13132900211");
        param.put("authcode", "123456");
        param.put("pwd", "000000");
        HttpPostService.testService(param, PORT, "/user/retrievePwd");
    }

    /**
     * 用户签到
     */
    @Test
    public void signed() {
        Map<String, String> param = new HashMap<String, String>();
        param.put("userId", "2");
        HttpPostService.testService(param, PORT, "/user/signed");
    }

    /**
     * 查询用户积分
     */
    @Test
    public void getIntegralList() {
        Map<String, String> param = new HashMap<String, String>();
        param.put("userId", "2");
        param.put("pageNumber", "1");
        param.put("pageSize", "10");
        HttpPostService.testService(param, PORT, "/user/getIntegralList");
    }

    /**
     * 修改用户头像
     */
    @Test
    public void updateHead() {
        Map<String, String> param = new HashMap<String, String>();
        param.put("userId", "2");
        HttpPostService.testService(param, PORT, "/user/updateHead");
    }

    /**
     *
     */
    @Test
    public void setwitch() {
        Map<String, String> param = new HashMap<String, String>();
        param.put("userId", "2");
        param.put("type", "1");
        param.put("valid", "0");
        HttpPostService.testService(param, PORT, "/user/setwitch");
    }

    /**
     * 我的收藏
     */
    @Test
    public void getCollectionList() {
        Map<String, String> param = new HashMap<String, String>();
        param.put("userId", "2");
        param.put("valid", "1");
        param.put("pageNumber", "1");
        param.put("pageSize", "10");
        HttpPostService.testService(param, PORT, "/user/getCollectionList");
    }

    /**
     * 获取商品列表
     */
    @Test
    public void getGoodsList() {
        Map<String, String> param = new HashMap<String, String>();
        param.put("pageNumber", "1");
        param.put("pageSize", "10");
        HttpPostService.testService(param, PORT, "/user/getGoodsList");
    }

    /**
     * 我的收藏
     */
    @Test
    public void getGoodsDetail() {
        Map<String, String> param = new HashMap<String, String>();
        param.put("goodsId", "2");
        HttpPostService.testService(param, PORT, "/user/getGoodsDetail");
    }

    /**
     * 获取订单列表
     */
    @Test
    public void getOrderList() {
        Map<String, String> param = new HashMap<String, String>();
        param.put("userId", "2");
        param.put("pageNumber", "1");
        param.put("pageSize", "10");
        HttpPostService.testService(param, PORT, "/user/getOrderList");
    }

    /**
     * 获取订单详情
     */
    @Test
    public void getOrderDetail() {
        Map<String, String> param = new HashMap<String, String>();
        param.put("orderId", "2");
        HttpPostService.testService(param, PORT, "/user/getOrderDetail");
    }

    /**
     * 系统通知
     */
    @Test
    public void getNotificationList() {
        Map<String, String> param = new HashMap<String, String>();
        param.put("userId", "2");
        param.put("pageNumber", "1");
        param.put("pageSize", "10");
        HttpPostService.testService(param, PORT, "/user/getNotificationList");
    }

    /**
     * 我的评论
     */
    @Test
    public void getMineCommentList() {
        Map<String, String> param = new HashMap<String, String>();
        param.put("userId", "2");
        param.put("pageNumber", "1");
        param.put("pageSize", "10");
        HttpPostService.testService(param, PORT, "/user/getMineCommentList");
    }

    /**
     * 兑换商品
     */
    @Test
    public void exchange() {
        Map<String, String> param = new HashMap<String, String>();
        param.put("userId", "2");
        param.put("phone", "2");
        param.put("goodsId", "2");
        param.put("goodsNumber", "2");
        param.put("address", "2");
        param.put("consignee", "2");
        param.put("amount", "2");
        param.put("sn", "2");
        HttpPostService.testService(param, PORT, "/user/exchange");
    }

    /**
     * 获取花朵
     */
    @Test
    public void getTaskList() {
        Map<String, String> param = new HashMap<String, String>();
        param.put("userId", "2");
        HttpPostService.testService(param, PORT, "/user/getTaskList");
    }
    
    /**
     * 查询用户个人主页信息
     */
    @Test
    public void getUserPersonalPage() {
    	Map<String, String> param = new HashMap<String, String>();
    	param.put("userId", "2");
    	param.put("targetUserId", "479");
    	HttpPostService.testService(param, PORT, "/user/getUserPersonalPage");
    }
    
    /**
     * 个人主页 - 身份墙 - 修改身份隐藏状态
     */
    @Test
    public void hideUserIdentitys() {
    	Map<String, String> param = new HashMap<String, String>();
    	param.put("userId", "479");
    	param.put("identityIds", "103,104");
    	HttpPostService.testService(param, PORT, "/user/hideUserIdentitys");
    }
    
    /**
     * 根据用户id和身份id查询参与的哔哔  
     */
    @Test
    public void getCommentsByUserIdentity() {
    	Map<String, String> param = new HashMap<String, String>();
    	param.put("userId", "479");
    	param.put("identityId", "103");
    	param.put("pageNumber", "1");
    	param.put("pageSize", "12");
    	HttpPostService.testService(param, PORT, "/user/getCommentsByUserIdentity");
    }
    
    /**
     * 查询用户个人主页-动态
     */
    @Test
    public void getUserDynamic() {
    	Map<String, String> param = new HashMap<String, String>();
    	param.put("userId", "479");
    	param.put("targetUserId", "103");
    	param.put("type", "1");
    	param.put("pageNumber", "1");
    	param.put("pageSize", "12");
    	HttpPostService.testService(param, PORT, "/user/getUserDynamic");
    }

    @Test
    public void addBlacklist() {
        Map<String, String> param = new HashMap<String, String>();
        param.put("userId", "479");
        param.put("blackUserId", "103");
        param.put("blackUserNickname", "afsfedf");
        HttpPostService.testService(param, PORT, "/user/addBlacklist");
    }


}

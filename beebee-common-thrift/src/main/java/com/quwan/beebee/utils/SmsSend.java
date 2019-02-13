package com.quwan.beebee.utils;

import com.alibaba.fastjson.JSON;
import com.quwan.beebee.sms.request.SmsSendRequest;
import com.quwan.beebee.sms.response.SmsSendResponse;
import com.quwan.beebee.sms.util.SmsUtil;

import java.io.UnsupportedEncodingException;


/**
 * @author yuhao
 * @Description:普通短信发送
 */
public class SmsSend {
    public static final String charset = "utf-8";
    // 用户平台API账号(非登录账号,示例:N1234567)
    public static String account = "";
    // 用户平台API密码(非登录密码)
    public static String pswd = "";

    public static void main(String[] args) throws UnsupportedEncodingException {

        //请求地址请登录253云通讯自助通平台查看或者询问您的商务负责人获取
        String smsSingleRequestServerUrl = "http://xxx/msg/send/json";
        // 短信内容
        String msg = "【253云通讯】你好,你的验证码是123456";
        //手机号码
        String phone = "187********";
        //状态报告
        String report= "true";

        SmsSendRequest smsSingleRequest = new SmsSendRequest(account, pswd, msg, phone,report);

        String requestJson = JSON.toJSONString(smsSingleRequest);

        System.out.println("before request string is: " + requestJson);

        String response = SmsUtil.sendSmsByPost(smsSingleRequestServerUrl, requestJson);

        System.out.println("response after request result is :" + response);

        SmsSendResponse smsSingleResponse = JSON.parseObject(response, SmsSendResponse.class);

        System.out.println("response  toString is :" + smsSingleResponse);


    }

}
package com.quwan.beebee.service.impl;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import com.quwan.beebee.dao.ThirdDao;
import com.quwan.beebee.param.third.AuthcodeParam;
import com.quwan.beebee.param.third.CheckImageParam;
import com.quwan.beebee.param.third.CheckTextParam;
import com.quwan.beebee.param.third.SendMsgParam;
import com.quwan.beebee.service.third.ThirdService;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.http.Consts;
import org.apache.http.client.HttpClient;
import org.apache.thrift.TException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.quwan.beebee.common.Constants;
import com.quwan.beebee.dao.CommonDao;
import com.quwan.beebee.exception.ErrorCode;
import com.quwan.beebee.sms.request.SmsSendRequest;
import com.quwan.beebee.sms.response.SmsSendResponse;
import com.quwan.beebee.sms.util.SmsUtil;
import com.quwan.beebee.utils.HttpClient4Utils;
import com.quwan.beebee.utils.Result;
import com.quwan.beebee.utils.SignatureUtils;
import com.quwan.beebee.utils.Sms;

/**
 * common-service 模块
 */
@Service("thirdServiceImpl")
@Transactional
public class ThirdServiceImpl implements ThirdService.Iface {

    @Autowired
    public ThirdDao thirdDao;

    private static final Logger LOGGER = LoggerFactory.getLogger(ThirdServiceImpl.class);

    /**
     * 产品私钥，服务端生成签名信息使用，请严格保管，避免泄露
     */
    public String SECRETKEY = "e4361f801c1e21615434e3187b28caa5";

    // * *实例化HttpClient，发送http请求使用，可根据需要自行调参* /
    public static HttpClient httpClient = HttpClient4Utils.createHttpClient(100, 20, 10000, 2000, 2000);

    /**
     * 发送验证码
     *
     * @param param
     * @return
     * @throws TException
     */
    @Override
    public String sendAuthcode(AuthcodeParam param) throws TException {
        String code = Sms.getCode();
        SendSmsResponse response = null;
        try {
            response = Sms.sendSms(param.getMobile(), code);
        } catch (ClientException e) {
            e.printStackTrace();
            LOGGER.error("Unexpected exception", e);
            return JSON.toJSONString(Result.response(ErrorCode.ServerError));
        }

        if (response.getCode().equals("isv.BUSINESS_LIMIT_CONTROL")) {
            return JSON.toJSONString(Result.response(ErrorCode.AliYunSmsErroe.code, "isv.BUSINESS_LIMIT_CONTROL"));
        }

        if (response.getCode() == null || !response.getCode().equals("OK")) {
            return JSON.toJSONString(Result.error());
        }

        param.setAuthcode(code);
        param.setAddTime(DateFormatUtils.format(System.currentTimeMillis(), Constants.FORMAT_DATETIME));
        param.setUsed("0");
        try {
            thirdDao.addAuthcode(param);
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error("Unexpected exception", e);
            return JSON.toJSONString(Result.response(ErrorCode.ServerError));
        }

        return JSON.toJSONString(Result.okObject(param));
    }

    /**
     * 短信下发
     *
     * @param param
     * @return
     * @throws TException
     */
    @Override
    public String sendMsg(SendMsgParam param) throws TException {
        // 用户平台API账号(非登录账号,示例:N1234567)
        String account = Constants.account;
        // 用户平台API密码(非登录密码)
        String pswd = Constants.pswd;
        //请求地址请登录253云通讯自助通平台查看或者询问您的商务负责人获取
        String smsSingleRequestServerUrl = Constants.smsSingleRequestServerUrl;
        // 短信内容
        String code = Sms.getCode();
        String msg = "您收到的验证码是：" + code;
        //手机号码
        String phone = param.getPhone();

        //状态报告
        String report = "true";
        int total = 0; //记录发送成功数量
        SmsSendResponse smsSingleResponse = null;
        SmsSendRequest smsSingleRequest = null;
        String requestJson = null;
        String response = null;
        try {
            String[] str = phone.split(",");
            for (String s : str) {
                smsSingleRequest = new SmsSendRequest(account, pswd, msg, s, report);
                requestJson = JSON.toJSONString(smsSingleRequest);
                response = SmsUtil.sendSmsByPost(smsSingleRequestServerUrl, requestJson);
                smsSingleResponse = JSON.parseObject(response, SmsSendResponse.class);
                param.setPhone(s);
                param.setMsg(code);
                int num = thirdDao.sendMsg(param);
                total += num;
            }
            Result okObject = Result.okObject(total);
            return JSON.toJSONString(okObject);
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error("Unexpected exception", e);
            return JSON.toJSONString(Result.response(ErrorCode.ServerError));
        }
    }

    /**
     * 文本检测
     * 何飞达
     *
     * @param param
     * @return
     * @throws TException
     */
    @Override
    public String checkText(CheckTextParam param) throws TException {

        // 获取文本请求参数
        Map<String, String> params = getTextParams(param);
        if(params == null || params.isEmpty()){
            return JSON.toJSONString(Result.response(ErrorCode.ParameterMissing));
        }

        // 发送HTTP请求，这里使用的是HttpClient工具包，产品可自行选择自己熟悉的工具包发送请求
        String response = HttpClient4Utils.sendPost(httpClient, Constants.TEXTAPI_URL, params, Consts.UTF_8);

        // 解析文本接口返回值，并返回
        return analyticTextValue(response, param).toString();
    }

    /**
     * 设置文本请求参数
     *
     * @param param
     * @return
     * @throws TException
     */
    public Map<String, String> getTextParams(CheckTextParam param) throws TException {
        Map<String, String> params = new HashMap<String, String>();

        // 设置公共参数
        params.put("secretId", Constants.SECRETID);
        params.put("businessId", Constants.TEXTBUSINESSID);
        params.put("version", "v3");
        params.put("timestamp", String.valueOf(System.currentTimeMillis()));
        params.put("nonce", String.valueOf(new Random().nextInt()));

        // 设置私有参数
        params.put("dataId", String.valueOf(param.getUserId()));
        params.put("content", param.getContent());
        params.put("publishTime", String.valueOf(System.currentTimeMillis()));

        // 生成签名信息
        String signature = null;
        try {
            signature = SignatureUtils.genSignature(SECRETKEY, params);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        params.put("signature", signature);
        return params;
    }

    /**
     * 解析文本接口返回值
     *
     * @param response
     * @return
     * @throws TException
     */
    public JsonObject analyticTextValue(String response, CheckTextParam param) throws TException {

        // 解析文本接口返回值
        JsonObject jObject = new JsonParser().parse(response).getAsJsonObject();
        int code = jObject.get("code").getAsInt();
        JsonObject res = new JsonObject();
        if (code != 200) {
            res.addProperty("error", "500");
            return res;
        }

        JsonObject resultObject = jObject.getAsJsonObject("result");
        res.addProperty("error", "0");
        JsonArray arr = new JsonArray();
        JsonObject object = new JsonObject();
        object.addProperty("key", param.getContent());
        object.add("value", resultObject.get("action"));
        arr.add(object);
        res.add("result", arr);
        res.addProperty("message", "Successful");
        return res;
    }

    /**
     * 图片检测
     * 何飞达
     *
     * @param param
     * @return
     * @throws TException
     */
    @Override
    public String checkImage(CheckImageParam param) throws TException {

        // 设置图片接口请求参数
        Map<String, String> params = getImageParams(param);
        if(params == null || params.isEmpty()){
            return JSON.toJSONString(Result.response(ErrorCode.ParameterMissing));
        }

        // 发送HTTP请求，这里使用的是HttpClient工具包，产品可自行选择自己熟悉的工具包发送请求
        String response = HttpClient4Utils.sendPost(httpClient, Constants.IMAGEAPI_URL, params, Consts.UTF_8);

        // 解析图片接口返回值，并返回
        return analyticImageValue(response).toString();
    }

    /**
     * 设置图片请求参数
     *
     * @param param
     * @return
     * @throws TException
     */
    public Map<String, String> getImageParams(CheckImageParam param) throws TException {
        Map<String, String> params = new HashMap<String, String>();
        List<String> urls = param.getUrl();
        if(urls == null || urls.isEmpty()){
            return params;
        }

        // 设置公共参数
        params.put("secretId", Constants.SECRETID);
        params.put("businessId", Constants.IMAGEBUSINESSID);
        params.put("version", "v3");
        params.put("timestamp", String.valueOf(System.currentTimeMillis()));
        params.put("nonce", String.valueOf(new Random().nextInt()));

        // 设置私有参数，传图片的URL进行检测，名称结构产品自行设计，用于唯一定位该图片数据
        JsonArray jsonArray = new JsonArray();
        for (int i = 0; i < urls.size(); i++) {
            JsonObject image = new JsonObject();
            image.addProperty("name", urls.get(i));
            image.addProperty("type", 1);
            image.addProperty("data", urls.get(i));
            jsonArray.add(image);
        }
        params.put("images", jsonArray.toString());

        // 生成签名信息
        String signature = null;
        try {
            signature = SignatureUtils.genSignature(Constants.SECRETKEY, params);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        params.put("signature", signature);
        return params;
    }

    /**
     * 解析图片接口返回值
     *
     * @param response
     * @return
     * @throws TException
     */
    public JsonObject analyticImageValue(String response) throws TException {

        // 解析接口返回值
        JsonObject resultObject = new JsonParser().parse(response).getAsJsonObject();
        int code = resultObject.get("code").getAsInt();
        JsonObject res = new JsonObject();
        if (code != 200) {
            res.addProperty("error", "500");
            return res;
        }

        res.addProperty("error", "0");
        res.addProperty("message", "Successful");
        JsonArray resultArray = resultObject.getAsJsonArray("result");
        JsonArray resArr = new JsonArray();
        for (JsonElement jsonElement : resultArray) {
            JsonObject jObject = jsonElement.getAsJsonObject();
            JsonArray labelArray = jObject.get("labels").getAsJsonArray();
            int maxLevel = -1;

            // 产品需根据自身需求，自行解析处理，本示例只是简单判断分类级别
            for (JsonElement labelElement : labelArray) {
                JsonObject lObject = labelElement.getAsJsonObject();
                int level = lObject.get("level").getAsInt();
                maxLevel = level > maxLevel ? level : maxLevel;
            }
            JsonObject obj = new JsonObject();
            obj.add("key", jObject.get("name"));
            obj.addProperty("value", maxLevel);
            resArr.add(obj);
            res.add("result", resArr);
        }
        return res;
    }
}

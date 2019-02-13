package com.quwan.beebee.utils;


import cn.jiguang.common.resp.APIConnectionException;
import cn.jiguang.common.resp.APIRequestException;
import cn.jpush.api.JPushClient;
import cn.jpush.api.push.PushResult;
import cn.jpush.api.push.model.Platform;
import cn.jpush.api.push.model.PushPayload;
import cn.jpush.api.push.model.audience.Audience;
import cn.jpush.api.push.model.notification.Notification;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * 使用Java SDK
 *
 * @author yuhao
 */
@SuppressWarnings({ "deprecation", "restriction" })
public class JiguangPush {
    private static final Logger log = LoggerFactory.getLogger(JiguangPush.class);
    private static String masterSecret = "1c78735df4a24250ad33b5b8";

    private static String appKey = "83764f7d1a68c72570f28d20";

    /**
     * 极光推送
     */
    public static void jiguangPush(String tag, String ALERT){
        log.info("对标签" + tag + "的用户推送信息");
        PushResult result = push(tag,ALERT);
        if(result != null && result.isResultOK()){
            log.info("针对标签" + tag + "的信息推送成功！");
        }else{
            log.info("针对标签" + tag + "的信息推送失败！");
        }
    }

    /**
     * 生成极光推送对象PushPayload（采用java SDK）
     * 所有平台，推送目标是标签为 tag，通知内容为 alert。
     * @param tag
     * @param alert
     * @return PushPayload
     */
    public static PushPayload buildPushObject_android_ios_alias_alert(String tag, String alert){
        return PushPayload.newBuilder()
                .setPlatform(Platform.all())
                .setAudience(Audience.tag("id_" + tag))
                .setNotification(Notification.alert(alert))
                .build();
    }
    /**
     * 极光推送方法(采用java SDK)
     * @param tag
     * @param alert
     * @return PushResult
     */
    public static PushResult push(String tag,String alert){
        JPushClient jpushClient = new JPushClient(masterSecret, appKey, 3);
        PushPayload payload = buildPushObject_android_ios_alias_alert(tag,alert);
        try {
            return jpushClient.sendPush(payload);
        } catch (APIConnectionException e) {
            log.error("Connection error. Should retry later. ", e);
            return null;
        } catch (APIRequestException e) {
            log.error("Error response from JPush server. Should review and fix it. ", e);
            log.info("HTTP Status: " + e.getStatus());
            log.info("Error Code: " + e.getErrorCode());
            log.info("Error Message: " + e.getErrorMessage());
            log.info("Msg ID: " + e.getMsgId());
            return null;
        }
    }
}
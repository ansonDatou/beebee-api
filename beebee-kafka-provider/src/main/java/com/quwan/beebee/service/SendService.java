package com.quwan.beebee.service;

import com.alibaba.fastjson.JSON;
import com.quwan.beebee.entity.archives.UserBehavior;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;

import java.util.List;

@EnableBinding(Source.class)
public class SendService {

    @Autowired
    private Source source;

    /**
     * 记录用户通过getlist接口获取的文章
     * @param list 用户行为
     */
    public void recordUserBehavior(List<UserBehavior> list) {
        try {
            String s = JSON.toJSONString(list);
            source.output().send(MessageBuilder.withPayload(s).build());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }









    // -----------------------------------------------------------------------------------------------------

    /**
     * 测试
     * @param ids 文章id
     */
    public void sendList(List<Integer> ids) {
        try {
            source.output().send(MessageBuilder.withPayload(ids).build());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 测试使用
     * @param msg
     */
    public void sendMessage(String msg) {
        try {
            source.output().send(MessageBuilder.withPayload(msg).build());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
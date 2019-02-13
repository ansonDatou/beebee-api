package com.quwan.beebee.service;

import com.alibaba.fastjson.JSON;
import com.quwan.beebee.entity.archives.UserBehavior;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@EnableBinding(Sink.class)
public class MsgSink {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @StreamListener(Sink.INPUT)
    public void process(Message<?> message) {
        List<UserBehavior> list = JSON.parseArray((String) message.getPayload(), UserBehavior.class);
        recordUserBehavior(list);

        Acknowledgment acknowledgment = message.getHeaders().get(KafkaHeaders.ACKNOWLEDGMENT, Acknowledgment.class);
        if (acknowledgment != null) {
            acknowledgment.acknowledge();
        }
    }


    /**
     * 记录用户行为
     * @param list
     */
    private void recordUserBehavior(List<UserBehavior> list) {
        ServiceInstance serviceInstance = this.loadBalancerClient.choose("beebee-archives-provider");
        this.restTemplate.postForObject("http://" + serviceInstance.getServiceId() + "/archives/recordUserBehavior", list, String.class);

    }
}

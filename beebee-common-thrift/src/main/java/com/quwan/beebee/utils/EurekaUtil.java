package com.quwan.beebee.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * 远程调用工具类
 */
@Configuration
public class EurekaUtil {

    @Autowired
    private  RestTemplate restTemplate;

    @Autowired
    private  LoadBalancerClient loadBalancerClient;

    /**
     * 远程调用
     * @param server 调用的服务器
     * @param method 调用的方法
     * @param p 方法的参数
     * @param <P>
     * @return
     */
    public <P> String remoteInvoke(String server, String method, P p) {
        ServiceInstance serviceInstance = loadBalancerClient.choose(server);
        return restTemplate.postForObject("http://" + serviceInstance.getServiceId() + method, p, String.class);
    }
}

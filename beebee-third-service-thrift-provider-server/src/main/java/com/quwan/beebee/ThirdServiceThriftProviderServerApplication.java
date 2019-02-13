package com.quwan.beebee;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication
@MapperScan(value = "com.quwan.beebee.dao")
@EnableScheduling
@EnableEurekaClient // Eureka 客户端 - 服务提供者
public class ThirdServiceThriftProviderServerApplication {

  /* service 层有使用restTemplate */
  @Bean
  @LoadBalanced
  public RestTemplate restTemplate() {
    return new RestTemplate();
  }

  public static void main(String[] args) {
    SpringApplication.run(ThirdServiceThriftProviderServerApplication.class, args);
  }
}

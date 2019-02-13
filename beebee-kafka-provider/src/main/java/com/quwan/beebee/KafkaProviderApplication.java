package com.quwan.beebee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@SpringBootApplication
@EnableEurekaClient // Eureka 客户端 - 服务提供者
public class KafkaProviderApplication {

  public static void main(String[] args) {
    SpringApplication.run(KafkaProviderApplication.class, args);
  }
}

package com.quwan.beebee;

import com.quwan.beebee.entity.PostResponseFilter;
import com.quwan.beebee.entity.PreRequestLogFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableZuulProxy
public class ZuulApplication {

  @Bean
  public PreRequestLogFilter preRequestLogFilter() {
    return new PreRequestLogFilter();
  }

  @Bean
  public PostResponseFilter postResponseFilter() {
    return new PostResponseFilter();
  }

  public static void main(String[] args) {
    SpringApplication.run(ZuulApplication.class, args);
  }
}

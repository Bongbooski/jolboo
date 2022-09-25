package com.jolboo.stock.config;

import feign.Logger;
import feign.RequestInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

public class FeignConfig {
  @Autowired private AccessToken accessToken;

  @Value("${app.oauth.appkey}")
  private String appKey;

  @Value("${app.oauth.appsecret}")
  private String appsecret;

  @Bean
  Logger.Level feignLoggerLevel() {
    return Logger.Level.FULL;
  }

  @Bean
  public RequestInterceptor requestInterceptor() {
    return requestTemplate -> {
      requestTemplate.header("Content-Type", "application/json;charset=UTF-8");
      requestTemplate.header("authorization", accessToken.getAccessToken());
      requestTemplate.header("appkey", appKey);
      requestTemplate.header("appsecret", appsecret);
      requestTemplate.header("tr_id", accessToken.getTrId());
      requestTemplate.header("tr_cont", "");
      requestTemplate.header("custtype", "P");
      requestTemplate.header("mac_address", "1111111");
      requestTemplate.header("hashkey", accessToken.getHashKey());
    };
  }
}

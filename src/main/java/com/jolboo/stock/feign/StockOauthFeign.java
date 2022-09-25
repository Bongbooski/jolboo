package com.jolboo.stock.feign;

import com.jolboo.stock.config.OauthFeignConfig;
import com.jolboo.stock.dto.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(
    name = "stockOauth",
    url = "https://openapivts.koreainvestment.com:29443",
    configuration = OauthFeignConfig.class)
public interface StockOauthFeign {
  @PostMapping(value = "/uapi/hashkey")
  HashResponseDTO getHashKey(
      @RequestHeader("appkey") String appKey,
      @RequestHeader("appsecret") String appSecret,
      @RequestBody HashRequestDTO hashRequestDTO);

  @PostMapping(value = "/oauth2/tokenP")
  AccessTokenResponseDTO getAccessToken(@RequestBody AccessTokenRequestDTO accessTokenRequestDTO);
}

package com.jolboo.stock.feign;

import com.jolboo.stock.config.FeignConfig;
import com.jolboo.stock.dto.HashRequestDTO;
import com.jolboo.stock.dto.HashResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "stock", url = "https://openapivts.koreainvestment.com:29443", configuration = FeignConfig.class)
public interface StockFeign {
    @PostMapping(value = "/uapi/hashkey")
    HashResponseDTO getHashKey(@RequestHeader("appkey") String appKey, @RequestHeader("appsecret") String appSecret, @RequestBody HashRequestDTO hashRequestDTO);
}

package com.jolboo.stock.feign;

import com.jolboo.stock.config.FeignConfig;
import com.jolboo.stock.dto.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "stock", url = "https://openapivts.koreainvestment.com:29443", configuration = FeignConfig.class)
public interface StockFeign {
    @PostMapping(value = "/uapi/hashkey")
    HashResponseDTO getHashKey(@RequestHeader("appkey") String appKey, @RequestHeader("appsecret") String appSecret, @RequestBody HashRequestDTO hashRequestDTO);

    @GetMapping(value = "/uapi/domestic-stock/v1/trading/inquire-balance")
    VtsGetBalanceResponseDTO getVtsBalance(@RequestHeader VtsGetBalanceRequestHeaderDTO headerDTO, @RequestParam VtsGetBalanceRequestParamDTO paramDTO);
}

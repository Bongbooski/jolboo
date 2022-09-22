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
    VtsGetBalanceResponseDTO getVtsBalance(
                                           @RequestHeader String authorization,
                                           @RequestHeader String appkey,
                                           @RequestHeader String appsecret,
                                           @RequestHeader String tr_id,
                                           @RequestParam String CANO,
                                           @RequestParam String ACNT_PRDT_CD,
                                           @RequestParam String AFHR_FLPR_YN,
                                           @RequestParam String OFL_YN,
                                           @RequestParam String INQR_DVSN,
                                           @RequestParam String UNPR_DVSN,
                                           @RequestParam String FUND_STTL_ICLD_YN,
                                           @RequestParam String FNCG_AMT_AUTO_RDPT_YN,
                                           @RequestParam String PRCS_DVSN,
                                           @RequestParam String CTX_AREA_FK100,
                                           @RequestParam String CTX_AREA_NK100);
}

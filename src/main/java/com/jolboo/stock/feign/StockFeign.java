package com.jolboo.stock.feign;

import com.jolboo.stock.config.FeignConfig;
import com.jolboo.stock.dto.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(
        name = "stock",
        url = "https://openapivts.koreainvestment.com:29443",
        configuration = FeignConfig.class)
public interface StockFeign {
    @GetMapping(
            value =
                    "/uapi/domestic-stock/v1/quotations/inquire-price?FID_COND_MRKT_DIV_CODE={fidCondMrktDivCode}&FID_INPUT_ISCD={fidInputIscd}")
    InquirePriceResponseDTO getInquirePrice(
            @PathVariable String fidCondMrktDivCode, @PathVariable String fidInputIscd);

    @GetMapping(value = "/uapi/domestic-stock/v1/trading/inquire-balance")
    VtsGetBalanceResponseDTO getVtsBalance(
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

    @GetMapping(value = "/uapi/domestic-stock/v1/quotations/inquire-daily-itemchartprice")
    PriceDTO getPrice(
            @RequestParam String FID_COND_MRKT_DIV_CODE,
            @RequestParam String FID_INPUT_ISCD,
            @RequestParam String FID_INPUT_DATE_1,
            @RequestParam String FID_INPUT_DATE_2,
            @RequestParam String FID_PERIOD_DIV_CODE,
            @RequestParam String FID_ORG_ADJ_PRC
            );
}

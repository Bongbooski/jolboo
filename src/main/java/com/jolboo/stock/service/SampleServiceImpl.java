package com.jolboo.stock.service;

import com.jolboo.stock.dto.*;
import com.jolboo.stock.feign.StockFeign;
import com.jolboo.stock.repository.SampleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SampleServiceImpl implements SampleService {
    private final StockFeign stockFeign;
    private final SampleRepository sampleRepository;

    private final String appKey = "PSdKEUeekE0RmiocZcnU2D4BbqlGwbWR4nGL";
    private final String appSecret = "SEoigsKllVV4N1PMBBIlNehO0h2BGBo2997P7LbtlZgILRDIXDUkFQYy64A7HneqTJa4PDs7ZRhFs6qUP80mtgHIq1Kohs7tmnQgczh8yVEU6WnWg1tVJ3qjmDvMJQI8FwTF3eaRKTYDcZXOn4bbtZrOMqOQF0GCJA9QfPg1081990TCwQ0=";
    private final String cano = "50070822";

    public HashResponseDTO retrieveSample() {

        HashRequestDTO hashRequestDTO = HashRequestDTO.builder()
                .ORD_PRCS_DVSN_CD("02")
                .CANO(cano)
                .ACNT_PRDT_CD("03")
                .SLL_BUY_DVSN_CD("02")
                .SHTN_PDNO("101S06")
                .ORD_QTY("1")
                .UNIT_PRICE("370")
                .NMPR_TYPE_CD("")
                .KRX_NMPR_CNDT_CD("")
                .CTAC_TLNO("1")
                .FUOP_ITEM_DVSN_CD("")
                .ORD_DVSN_CD("02")
                .build();
        HashResponseDTO result = stockFeign.getHashKey(appKey, appSecret, hashRequestDTO);

        sampleRepository.findById(1);

        return result;
    }

    public String getAuthorization() {

        HashRequestDTO hashRequestDTO = HashRequestDTO.builder()
                .ORD_PRCS_DVSN_CD("02")
                .CANO("계좌번호")
                .ACNT_PRDT_CD("03")
                .SLL_BUY_DVSN_CD("02")
                .SHTN_PDNO("101S06")
                .ORD_QTY("1")
                .UNIT_PRICE("370")
                .NMPR_TYPE_CD("")
                .KRX_NMPR_CNDT_CD("")
                .CTAC_TLNO("1")
                .FUOP_ITEM_DVSN_CD("")
                .ORD_DVSN_CD("02")
                .build();
        HashResponseDTO result = stockFeign.getHashKey(appKey, appSecret, hashRequestDTO);
        return result.getHASH();
    }

    public VtsGetBalanceResponseDTO getVtsGetBalance() {
        VtsGetBalanceRequestHeaderDTO requestHeaderDTO = VtsGetBalanceRequestHeaderDTO.builder()
                .appkey(appKey)
                .appsecret(appSecret)
                .authorization(getAuthorization())
                .build();
        VtsGetBalanceRequestParamDTO requestParamDTO = VtsGetBalanceRequestParamDTO.builder()
                .CANO(cano)
                .ACNT_PRDT_CD("01")
                .AFHR_FLPR_YN("N")
                .OFL_YN("")
                .INQR_DVSN("01")
                .UNPR_DVSN("01")
                .FUND_STTL_ICLD_YN("N")
                .FNCG_AMT_AUTO_RDPT_YN("N")
                .PRCS_DVSN("00")
                .CTX_AREA_NK100("")
                .CTX_AREA_FK100("")
                .build();
        VtsGetBalanceResponseDTO result = stockFeign.getVtsBalance(requestHeaderDTO, requestParamDTO);
return result;
    }
}
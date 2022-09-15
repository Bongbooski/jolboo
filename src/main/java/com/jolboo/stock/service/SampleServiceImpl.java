package com.jolboo.stock.service;

import com.jolboo.stock.dto.HashRequestDTO;
import com.jolboo.stock.dto.HashResponseDTO;
import com.jolboo.stock.feign.StockFeign;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SampleServiceImpl implements SampleService {
    private final StockFeign stockFeign;
    public HashResponseDTO retrieveSample() {

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
        HashResponseDTO result = stockFeign.getHashKey("PSdKEUeekE0RmiocZcnU2D4BbqlGwbWR4nGL", "SEoigsKllVV4N1PMBBIlNehO0h2BGBo2997P7LbtlZgILRDIXDUkFQYy64A7HneqTJa4PDs7ZRhFs6qUP80mtgHIq1Kohs7tmnQgczh8yVEU6WnWg1tVJ3qjmDvMJQI8FwTF3eaRKTYDcZXOn4bbtZrOMqOQF0GCJA9QfPg1081990TCwQ0=", hashRequestDTO);
        return result;
    }
}
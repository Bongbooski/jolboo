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
        HashResponseDTO result = stockFeign.getHashKey("PSr0M4UY4RaqvY9v7tj8TDNT8Dj2ntYFoPAv", "P/i/QQKeEhTKOy6Q7pt6fhPSjvi/54iMTShmIMtJIGIETqvKvtjgDW+TGq26k1K0Z4DDpzClviwBnMBCtBY4HopGjBDH4rlnTS78aXFLZpu1OZXpv89raLq58Oq+bOskxAg7Bo7t80pn2ifG3L60kVIAnF13Qbt7/SGCFNI0Lwl7cDEL9NY=", hashRequestDTO);
        return result;
    }
}
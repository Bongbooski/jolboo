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
        HashResponseDTO result = stockFeign.getHashKey("PSfpiTgQ4YH5OZHp7o5sa15NzNHSirtv6vvP", "qwze/XOZPjW3aLOpSAhTAyVxxKsH5F7Gx9wdXVWWEEf9E1DmA9rue0kxPw5/bxT30oW8sDnVCKLn3hZDBDPx1o2Lxqc8sq+eilmMXqjKl555Gya3OhYhOpi1Vat/Oe0dHUaE/pcM/fOxJfNZVtgsZdzr1fysho6UFvsNkhoXqzbaiyu/z14=", hashRequestDTO);
        return result;
    }
}
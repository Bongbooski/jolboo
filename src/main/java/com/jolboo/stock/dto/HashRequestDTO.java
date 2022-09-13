package com.jolboo.stock.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Builder
@Data
public class HashRequestDTO {
    private String ORD_PRCS_DVSN_CD;
    private String CANO;
    private String ACNT_PRDT_CD;
    private String SLL_BUY_DVSN_CD;
    private String SHTN_PDNO;
    private String ORD_QTY;
    private String UNIT_PRICE;
    private String NMPR_TYPE_CD;
    private String KRX_NMPR_CNDT_CD;
    private String CTAC_TLNO;
    private String FUOP_ITEM_DVSN_CD;
    private String ORD_DVSN_CD;
}

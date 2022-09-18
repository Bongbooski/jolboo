package com.jolboo.stock.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
public class VtsGetBalanceRequestParamDTO {
    private String CANO;
    private String ACNT_PRDT_CD;
    private String AFHR_FLPR_YN;
    private String OFL_YN;
    private String INQR_DVSN;
    private String UNPR_DVSN;
    private String FUND_STTL_ICLD_YN;
    private String FNCG_AMT_AUTO_RDPT_YN;
    private String PRCS_DVSN;
    private String CTX_AREA_FK100;
    private String CTX_AREA_NK100;
}

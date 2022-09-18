package com.jolboo.stock.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BalanceDetail {
    private String dnca_tot_amt;
    private String nxdy_excc_amt;
    private String prvs_rcdl_excc_amt;
    private String cma_evlu_amt;
    private String bfdy_buy_amt;
    private String thdt_buy_amt;
    private String nxdy_auto_rdpt_amt;
    private String bfdy_sll_amt;
    private String thdt_sll_amt;
    private String d2_auto_rdpt_amt;
    private String bfdy_tlex_amt;
    private String thdt_tlex_amt;
    private String tot_loan_amt;
    private String scts_evlu_amt;
    private String tot_evlu_amt;
    private String nass_amt;
    private String fncg_gld_auto_rdpt_yn;
    private String pchs_amt_smtl_amt;
    private String evlu_amt_smtl_amt;
    private String evlu_pfls_smtl_amt;
    private String tot_stln_slng_chgs;
    private String bfdy_tot_asst_evlu_amt;
    private String asst_icdc_amt;
    private String asst_icdc_erng_rt;
}

package com.jolboo.stock.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StockInfo {
  private String pdno;
  private String prdt_name;
  private String trad_dvsn_name;
  private String bfdy_buy_qty;
  private String bfdy_sll_qty;
  private String thdt_buyqty;
  private String thdt_sll_qty;
  private String hldg_qty;
  private String ord_psbl_qty;
  private String pchs_avg_pric;
  private String pchs_amt;
  private String prpr;
  private String evlu_amt;
  private String evlu_pfls_amt;
  private String evlu_pfls_rt;
  private String evlu_erng_rt;
  private String loan_dt;
  private String loan_amt;
  private String stln_slng_chgs;
  private String expd_dt;
  private String fltt_rt;
  private String bfdy_cprs_icdc;
  private String item_mgna_rt_name;
  private String grta_rt_name;
  private String sbst_pric;
  private String stck_loan_unpr;
}

package com.jolboo.stock.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OpenApiStockInfo {
    private String basDt;
    private String srtnCd;
    private String isinCd;
    private String mrktCtg;
    private String itmsNm;
    private String crno;
    private String corpNm;
}

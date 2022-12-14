package com.jolboo.stock.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class VtsGetBalanceResponseDTO {
    private String ctx_area_fk100;
    private String ctx_area_nk100;
    private List<StockInfo> output1;
    private List<BalanceDetail> output2;
    private String rt_cd;
    private String msg_cd;
    private String msg1;
}

package com.jolboo.stock.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
public class VtsGetBalanceRequestHeaderDTO {
//    private String content-type = "application/json; charset=utf-8";
    private String authorization;
    private String appkey;
    private String appsecret;
    private final String tr_id="VTTC8434R";
    private String tr_cont;
    private final String custtype="P";
    private String seq_no;
    private String mac_address;
    private String phone_number;
    private String ip_addr;
    private String hashKey;
    private String gt_uid;
}

package com.jolboo.stock.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OpenApiHeader {
    private String resultCode;
    private String resultMsg;
}

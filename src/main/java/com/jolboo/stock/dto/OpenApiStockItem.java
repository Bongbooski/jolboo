package com.jolboo.stock.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class OpenApiStockItem {
    private List<OpenApiStockInfo> item;
}

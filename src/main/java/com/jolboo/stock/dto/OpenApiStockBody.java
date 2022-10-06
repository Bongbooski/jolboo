package com.jolboo.stock.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class OpenApiStockBody {
    private String numOfRows;
    private String pageNo;
    private String totalCount;
    private OpenApiStockItem items;
}

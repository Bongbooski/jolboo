package com.jolboo.stock.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OpenApiResponse {
    private OpenApiStockInfoResponseDTO response;
}

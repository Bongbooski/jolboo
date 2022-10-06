package com.jolboo.stock.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OpenApiStockInfoResponseDTO {
    private OpenApiHeader header;
    private OpenApiStockBody body;

}

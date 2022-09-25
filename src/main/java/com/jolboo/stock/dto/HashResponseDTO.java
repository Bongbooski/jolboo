package com.jolboo.stock.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class HashResponseDTO {
  private Object BODY;
  private String HASH;
}

package com.jolboo.stock.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AccessTokenRequestDTO {
  String grant_type;
  String appkey;
  String appsecret;
}

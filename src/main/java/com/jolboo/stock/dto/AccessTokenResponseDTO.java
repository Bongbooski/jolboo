package com.jolboo.stock.dto;

import lombok.Data;

import java.time.OffsetDateTime;

@Data
public class AccessTokenResponseDTO {
    String access_token;
    String token_type;
    String access_token_token_expired;
    Integer expires_in;
}

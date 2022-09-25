package com.jolboo.stock.config;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class AccessToken {
    private String accessToken;
    private String tokenType;
    private String hashKey;
    private String trId; // TODO: 일단 여기 넣고 나중에 필요하면 분리
}

package com.jolboo.stock.model;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ResponseData {
    private String successOrNot;
    private String statusCode;
    private Object data;

    @Builder
    public ResponseData(String successOrNot, String statusCode, Object data) {
        this.successOrNot = successOrNot;
        this.statusCode = statusCode;
        this.data = data;
    }
}

package com.jolboo.stock.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SampleDTO {
    private String sampleId;

    @Builder
    public SampleDTO(String sampleId) {
        this.sampleId = sampleId;
    }
}

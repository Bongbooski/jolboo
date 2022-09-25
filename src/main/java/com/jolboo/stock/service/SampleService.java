package com.jolboo.stock.service;

import com.jolboo.stock.dto.HashResponseDTO;
import com.jolboo.stock.dto.VtsGetBalanceResponseDTO;

public interface SampleService {
    HashResponseDTO retrieveSample();

    void setAccessToken();
    VtsGetBalanceResponseDTO getVtsGetBalance();
}

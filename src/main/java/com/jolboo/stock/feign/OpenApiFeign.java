package com.jolboo.stock.feign;

import com.jolboo.stock.config.FeignConfig;
import com.jolboo.stock.config.OpenApiFeignConfig;
import com.jolboo.stock.dto.OpenApiResponse;
import com.jolboo.stock.dto.OpenApiStockInfoResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "openApiStock", url = "http://apis.data.go.kr", configuration = OpenApiFeignConfig.class)
public interface OpenApiFeign {

    @GetMapping(value = "/1160100/service/GetKrxListedInfoService/getItemInfo")
    OpenApiResponse getOpenApiStockInfo(@RequestParam String numOfRows, @RequestParam String serviceKey, @RequestParam String resultType);
}

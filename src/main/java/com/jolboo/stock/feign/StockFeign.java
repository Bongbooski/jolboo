package com.jolboo.stock.feign;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "stock", url = "https://openapivts.koreainvestment.com:29443")
public interface StockFeign {


}

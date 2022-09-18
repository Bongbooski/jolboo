package com.jolboo.stock.restcontroller;

import com.jolboo.stock.model.ResponseData;
import com.jolboo.stock.service.SampleService;
import com.jolboo.stock.utility.ResponseUtility;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class SampleRestController {
    private final SampleService sampleService;


    @GetMapping(path = "/v1/sample")
    @ResponseBody
    public ResponseEntity<ResponseData> retrieveSample() {
        return ResponseUtility.createGetSuccessResponse(sampleService.retrieveSample());
    }

    @GetMapping(path = "/v1/vts/balance")
    @ResponseBody
    public ResponseEntity<ResponseData> getVtsBalance() {
        return ResponseUtility.createGetSuccessResponse(sampleService.getVtsGetBalance());
    }
}

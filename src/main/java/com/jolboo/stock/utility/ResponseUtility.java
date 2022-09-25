package com.jolboo.stock.utility;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.jolboo.stock.constants.CommonConstants;
import com.jolboo.stock.model.ResponseData;
import lombok.experimental.UtilityClass;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@UtilityClass
public class ResponseUtility {
  @JsonSerialize
  public static class EmptyJsonResponse {}

  public static ResponseEntity<ResponseData> createGetSuccessResponse(Object data) {
    return createSuccessResponse(data, HttpStatus.OK);
  }

  public static ResponseEntity<ResponseData> createSuccessResponse(
      Object data, HttpStatus httpStatus) {
    return createSuccessResponse(
        CommonConstants.DEFAULT_SUCCESS_CODE,
        CommonConstants.DEFAULT_SUCCESS_DESC,
        data,
        httpStatus);
  }

  public static ResponseEntity<ResponseData> createSuccessResponse(
      String statusCode, String description, Object data, HttpStatus httpStatus) {
    return new ResponseEntity<>(
        createSuccessResponseData(statusCode, description, data), httpStatus);
  }

  private static ResponseData createSuccessResponseData(
      String statusCode, String description, Object data) {
    if (data == null) data = new EmptyJsonResponse();

    return ResponseData.builder()
        .successOrNot(CommonConstants.SUCCESS_FLAG)
        .statusCode(statusCode)
        .data(data)
        .build();
  }
}

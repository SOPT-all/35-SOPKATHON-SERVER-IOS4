package com.sopt.ios4.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.sopt.ios4.exception.ErrorCode;

public record ResponseDto<T> (
        int status,
        String message,
        @JsonInclude(JsonInclude.Include.NON_NULL)
        T data
) {
    // 실패니까 응답값 없음
    public static <T> ResponseDto<T> fail(ErrorCode errorCode, String message) {
        return new ResponseDto<>(errorCode.getHttpStatus().value(), message, null);
    }

    // 응답값 있는 성공
    public static <T> ResponseDto<T> success(int status, String message, T data) {
        return new ResponseDto<>(status, message, data);
    }


    // 응답값 없는 성공
    public static ResponseDto<Void> success(int status, String message) {
        return new ResponseDto<>(status, message, null);
    }
}
package com.sopt.ios4.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.sopt.ios4.exception.ErrorCode;

public record ResponseDto<T> (
        int status,
        @JsonInclude(JsonInclude.Include.NON_NULL)
        T data,
        String message

) {
    // 실패니까 응답값 없음
    public static <T> ResponseDto<T> fail(ErrorCode errorCode, String message) {
        return new ResponseDto<>(errorCode.getHttpStatus().value(), null, message);
    }

    // 응답값 있는 성공
    public static <T> ResponseDto<T> success(int status, T data, String message) {
        return new ResponseDto<>(status, data, message);
    }


    // 응답값 없는 성공
    public static ResponseDto<Void> success(int status, String message) {
        return new ResponseDto<>(status, null, message);
    }
}
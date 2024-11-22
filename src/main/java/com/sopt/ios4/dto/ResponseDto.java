package com.sopt.ios4.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.sopt.ios4.exception.ErrorCode;

public record ResponseDto<T> (
        int status,
        @JsonInclude(JsonInclude.Include.NON_NULL) T data
) {
    // 실패: 코드만 내려줌
    public static <T> ResponseDto<T> fail(ErrorCode errorCode) {
        return new ResponseDto<>(errorCode.getHttpStatus().value(), null);
    }

    // 성공: 응답 본문 포함
    public static <T> ResponseDto<T> success(int status, T data) {
        return new ResponseDto<>(status, data);
    }

    // 성공: 응답 본문 없음
    public static ResponseDto<Void> success(int status) {
        return new ResponseDto<>(status, null);
    }
}
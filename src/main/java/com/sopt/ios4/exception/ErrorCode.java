package com.sopt.ios4.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    NOT_FOUND(HttpStatus.NOT_FOUND);

    private final HttpStatus httpStatus;
}

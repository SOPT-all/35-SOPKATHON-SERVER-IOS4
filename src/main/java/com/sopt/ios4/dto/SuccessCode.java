package com.sopt.ios4.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum SuccessCode {

    SUCCESS_CODE(HttpStatus.CREATED);

    private final HttpStatus httpStatus;

}

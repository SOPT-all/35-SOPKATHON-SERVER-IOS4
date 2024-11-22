package com.sopt.ios4.advice;

import com.sopt.ios4.dto.ResponseDto;
import com.sopt.ios4.exception.ErrorCode;
import com.sopt.ios4.exception.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ResponseDto<Void>> handleNotFoundException(NotFoundException e) {
        return ResponseEntity
                .status(e.getErrorCode().getHttpStatus())
                .body(ResponseDto.fail(e.getErrorCode()));
    }
}

package com.sopt.ios4.controller;

import com.sopt.ios4.dto.ResponseDto;
import com.sopt.ios4.exception.ErrorCode;
import com.sopt.ios4.exception.NotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    // 데이터가 있는 성공 응답
    @GetMapping("/api/v1/success-with-data")
    public ResponseDto<String> successWithData(@RequestParam(required = false) String message) {
        if (message == null || message.isBlank()) {
            throw new NotFoundException(ErrorCode.NOT_FOUND);
        }
        // Success 응답 반환 (본문 포함)
        return ResponseDto.success(200, "Success message: " + message);
    }

    // 데이터가 없는 성공 응답
    @GetMapping("/api/v1/success-no-data")
    public ResponseDto<Void> successNoData() {
        return ResponseDto.success(200);
    }

    @GetMapping("/api/v1/test-not-found")
    public void testNotFoundException() {
        throw new NotFoundException(ErrorCode.NOT_FOUND);
    }
}
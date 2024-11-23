package com.sopt.ios4.controller;

import com.sopt.ios4.dto.ResponseDto;
import com.sopt.ios4.exception.ErrorCode;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/test")
public class TestController {

    @GetMapping("/success")
    public ResponseDto<String> getSuccess() {
        return ResponseDto.success(HttpStatus.OK.value(), "Success", "This is a successful response!");
    }

    @GetMapping("/fail")
    public ResponseDto<Void> getFail() {
        return ResponseDto.fail(ErrorCode.NOT_FOUND, "This is a failure response");
    }

    @PostMapping("/post")
    public ResponseDto<String> postData(@RequestBody String input) {
        if (input == null || input.isEmpty()) {
            return ResponseDto.fail(ErrorCode.NOT_FOUND, "Input cannot be null or empty");
        }
        return ResponseDto.success(HttpStatus.CREATED.value(), input, "Data received successfully");
    }
}
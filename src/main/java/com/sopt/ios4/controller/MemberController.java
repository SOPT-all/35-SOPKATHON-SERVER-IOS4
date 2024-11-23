package com.sopt.ios4.controller;

import com.sopt.ios4.dto.ResponseDto;
import com.sopt.ios4.dto.request.MemberJoinDto;
import com.sopt.ios4.dto.response.MemberJoinResponse;
import com.sopt.ios4.service.member.MemberService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class MemberController {

    private final MemberService memberService;

    // 회원 가입
    @PostMapping("/v1/register")
    public ResponseEntity<ResponseDto<MemberJoinResponse>> join(
            @RequestBody @Valid final MemberJoinDto memberJoinDto
    ) {
        // 회원 가입 후 저장된 Member ID 가져옴 -> 클라이언트에게 전달
        Long memberId = memberService.join(memberJoinDto).getId();
        MemberJoinResponse response = new MemberJoinResponse(memberId);

        return ResponseEntity.status(201)
                .body(ResponseDto.success(201, "회원 가입 성공.", response));
    }
}
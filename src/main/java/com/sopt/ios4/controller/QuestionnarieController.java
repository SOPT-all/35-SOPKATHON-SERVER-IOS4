package com.sopt.ios4.controller;

import com.sopt.ios4.dto.SuccessCode;
import com.sopt.ios4.dto.request.QuestionnarieCreateRequest;
import com.sopt.ios4.dto.response.NewQuestionnarieResponse;
import com.sopt.ios4.dto.ResponseDto;
import com.sopt.ios4.service.Questionnarie.QuestionnarieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class QuestionnarieController {

    private final QuestionnarieService questionnarieService;

    @PostMapping("v1/questionnaire")
    public ResponseEntity<ResponseDto<NewQuestionnarieResponse>> makeNewQuestionnarie(
            @RequestHeader("Authorization") Long memberId,
            @RequestBody QuestionnarieCreateRequest questionnarieCreateRequest
    ){
        NewQuestionnarieResponse invitatinoCode = questionnarieService.createQuestionnarie(memberId, questionnarieCreateRequest);
        return ResponseEntity.ok(ResponseDto.success(HttpStatus.CREATED.value(), "질문지가 생성되었습니다.", invitatinoCode)
    }
}

package com.sopt.ios4.controller;

import com.sopt.ios4.domain.NewQuestion;
import com.sopt.ios4.domain.NewQuestionElement;
import com.sopt.ios4.dto.ResponseDto;
import com.sopt.ios4.dto.request.QuestionnarieCreateRequest;
import com.sopt.ios4.service.question.NewQuestionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class QuestionController {

    private final NewQuestionService newQuestionService;

    @PostMapping("/v1/questionnaire")
    public ResponseEntity<ResponseDto<Integer>> createNewQuestion(@RequestBody @Valid QuestionnarieCreateRequest newQuestion
            ) {

        NewQuestion aa = newQuestionService.createQuestionnaire(newQuestion);
        int invitatinoCode = aa.getInvitationCode();
        return ResponseEntity.ok(ResponseDto.success(HttpStatus.CREATED.value(), "질문지가 생성되었습니다.", invitatinoCode));
    }

    @GetMapping("/v1/questionnaire")
    public ResponseEntity<ResponseDto<List<String>>> createNewQuestion(@RequestParam int invitationCode
    ) {
        List<String> aa = newQuestionService.getQuestionsByInvitationCode((int) invitationCode);


        return ResponseEntity.ok(ResponseDto.success(HttpStatus.OK.value(), "질문지가 생성되었습니다.", aa));
    }
}


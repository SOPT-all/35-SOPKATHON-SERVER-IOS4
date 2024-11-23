package com.sopt.ios4.controller;

import com.sopt.ios4.domain.NewQuestion;
import com.sopt.ios4.domain.NewQuestionElement;
import com.sopt.ios4.dto.ResponseDto;
import com.sopt.ios4.dto.request.AnswerListRequest;
import com.sopt.ios4.dto.request.QuestionnarieCreateRequest;
import com.sopt.ios4.service.question.NewQuestionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class QuestionController {

    private final NewQuestionService newQuestionService;

    @PostMapping("/v1/questionnaire")
    public ResponseEntity<ResponseDto<Integer>> createNewQuestion(
            @RequestBody @Valid QuestionnarieCreateRequest newQuestion
            )
    {
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

//    // 질문지 문제 풀기 -> 몇 개 맞았는지 반환
//    @PostMapping("/v1/questionnaire/test")
//    public ResponseEntity<ResponseDto<Integer>> solveQuestionElements(
//            @RequestParam long questionId,
//            @RequestBody AnswerListRequest answerListRequest
//    )
//    {
//        // 질문지(Question) 테이블에서 questionId 에 해당하는 질문 찾아오기
//
//
//
//        int answerCount = 0; //맞은 개수 반환
//        return ResponseEntity.ok(ResponseDto.success(HttpStatus.OK.value(), "요청이 성공했습니다.", answerCount));
//    }
}


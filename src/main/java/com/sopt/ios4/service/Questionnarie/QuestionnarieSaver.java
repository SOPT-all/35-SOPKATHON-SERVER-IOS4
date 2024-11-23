package com.sopt.ios4.service.Questionnarie;

import com.sopt.ios4.domain.Question;
import com.sopt.ios4.domain.QuestionElement;
import com.sopt.ios4.dto.response.NewQuestionnarieResponse;
import com.sopt.ios4.repository.QuestionnarieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class QuestionnarieSaver {
    private final QuestionnarieRepository questionnarieRepository;

    public int save(final Question question) {
        questionnarieRepository.save(question);
        return question.getInvitationCode();
    }

}

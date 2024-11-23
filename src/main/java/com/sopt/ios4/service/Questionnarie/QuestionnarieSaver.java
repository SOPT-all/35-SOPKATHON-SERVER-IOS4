package com.sopt.ios4.service.Questionnarie;

import com.sopt.ios4.domain.Question;
import com.sopt.ios4.domain.QuestionElement;
import com.sopt.ios4.repository.QuestionnarieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class QuestionnarieSaver {
    private final QuestionnarieRepository questionnarieRepository;

    public Question save(final Question question) {
        return questionnarieRepository.save(question);
    }

}

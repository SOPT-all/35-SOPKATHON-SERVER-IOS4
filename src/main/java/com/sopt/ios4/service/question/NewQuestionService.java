package com.sopt.ios4.service.question;

import com.sopt.ios4.domain.NewQuestion;
import com.sopt.ios4.domain.NewQuestionElement;
import com.sopt.ios4.dto.request.QuestionnarieCreateRequest;
import com.sopt.ios4.repository.NewQuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.ThreadLocalRandom;

@Service
@RequiredArgsConstructor
@Transactional
public class NewQuestionService {

    private final NewQuestionRepository newQuestionRepository;

    public NewQuestion createQuestionnaire(final QuestionnarieCreateRequest request) {
        // 1. NewQuestion 생성
        NewQuestion newQuestion = new NewQuestion();
        newQuestion.setTheme(request.theme());
        newQuestion.setInvitationCode(ThreadLocalRandom.current().nextInt(100000, 1000000));

        // 2. NewQuestionElement 생성 및 연관 설정
        for (QuestionnarieCreateRequest.QuestionnarieDto questionDto : request.questions()) {
            NewQuestionElement questionElement = new NewQuestionElement();
            questionElement.setSubject(questionDto.subject());
            questionElement.setIsTrue(questionDto.answer());

            // 연관 관계 설정
            questionElement.setNewQuestion(newQuestion); // 양방향 연관 관계 설정
            newQuestion.getQuestions().add(questionElement);
        }

        // 3. 저장
        return newQuestionRepository.save(newQuestion);
    }
}


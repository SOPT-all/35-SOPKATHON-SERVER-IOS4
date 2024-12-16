package com.sopt.ios4.service.question;

import com.sopt.ios4.domain.NewQuestion;
import com.sopt.ios4.domain.NewQuestionElement;
import com.sopt.ios4.dto.request.AnswerListRequest;
import com.sopt.ios4.dto.request.QuestionnarieCreateRequest;
import com.sopt.ios4.dto.response.QuestionnarieResponse;
import com.sopt.ios4.exception.ErrorCode;
import com.sopt.ios4.exception.NotFoundException;
import com.sopt.ios4.repository.NewQuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class NewQuestionService {

    private final NewQuestionRepository newQuestionRepository;

    // 질문지 만듦
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

    public QuestionnarieResponse getQuestionsByInvitationCode(int invitationCode) {
        NewQuestion newQuestion = newQuestionRepository.findByInvitationCode(invitationCode)
                .orElseThrow(() -> new NotFoundException(ErrorCode.NOT_FOUND));

        return new QuestionnarieResponse (
                newQuestion.getId(),
                newQuestion.getQuestions().stream()
                        .map(NewQuestionElement::getSubject)
                        .collect(Collectors.toList())
        );
    }

    // 질문지 id 에 해당하는 질문들의 답 가져옴
    public List<Boolean> getAnswerByQuestion(final long questionId){
        NewQuestion newQuestion = newQuestionRepository.findById(questionId)
                .orElseThrow(() -> new IllegalArgumentException("올바른 질문지 아이디를 입력해주세요"));

        return newQuestion.getQuestions().stream()
                .map(NewQuestionElement::isTrue)
                .collect(Collectors.toList());
    }

    public int getCounts(final long questionId, AnswerListRequest answerListRequest){
        List<Boolean> array1 = answerListRequest.getAnswerList(); // 상아가 입력한 답
        List<Boolean> array2 = getAnswerByQuestion(questionId); //정답값

        if (array1.size() != array2.size()) {
            throw new IllegalArgumentException("입력한 답과 정답의 개수가 일치하지 않습니다.");
        }

        // 정답 개수를 카운트
        int count = 0;
        for (int i = 0; i < array1.size(); i++) {
            if (array1.get(i).equals(array2.get(i))) {
                count++;
            }
        }
        return count;
    }


}


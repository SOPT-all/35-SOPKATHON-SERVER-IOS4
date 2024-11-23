package com.sopt.ios4.service.Questionnarie;

import com.sopt.ios4.domain.Member;
import com.sopt.ios4.domain.Question;
import com.sopt.ios4.domain.QuestionElement;
import com.sopt.ios4.dto.request.QuestionnarieCreateRequest;
import com.sopt.ios4.dto.response.NewQuestionnarieResponse;
import com.sopt.ios4.repository.MemberRepository;
import com.sopt.ios4.repository.QuestionnarieRepository;
import com.sopt.ios4.service.Member.MemberRetriever;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
@RequiredArgsConstructor
@Transactional(readOnly=true)
public class QuestionnarieService {

    private final QuestionnarieRetriever questionnarieRepository;
    private final MemberRetriever memberRetriever;
    private final QuestionnarieSaver questionnarieSaver;

    @Transactional
    public QuestionnarieCreateRequest createQuestionnarie(final long memberId, final QuestionnarieCreateRequest questionnarieCreateRequest) {

        Member member = memberRetriever.findMemberById(memberId);
        int invitationCode = ThreadLocalRandom.current().nextInt(100000, 1000000);
        List<QuestionElement> questionElementList = new ArrayList<>();

        questionElementList.add(
                QuestionElement.builder()
                        .id()
                        .question()
                        .subject()
                        .isTrue()
                        .build()
        );

        questionElementList.add(
                QuestionElement.builder()
                        .id()
                        .question()
                        .subject()
                        .isTrue()
                        .build()
        );
        questionElementList.add(
                QuestionElement.builder()
                        .id()
                        .question()
                        .subject()
                        .isTrue()
                        .build()
        );



        Question question = new Question(member, invitationCode, questionElementList);

        return questionnarieSaver.save(question);
    }

}

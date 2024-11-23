package com.sopt.ios4.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class QuestionElement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id", nullable = false)
    private Question question;

    @Column(name = "subject")
    private String subject;

    @Column(name = "is_true")
    private boolean isTrue; //영주가 선택한 정답

    @Builder
    public QuestionElement builder(long id, Question question, String subject, boolean isTrue) {
        this.id = id;
        this.question = question;
        this.subject = subject;
        this.isTrue = isTrue;
    }
}

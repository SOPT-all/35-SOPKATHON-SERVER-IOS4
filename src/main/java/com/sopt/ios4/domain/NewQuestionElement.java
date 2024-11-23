package com.sopt.ios4.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class NewQuestionElement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "subject", nullable = false)
    private String subject;

    @Column(name = "is_true", nullable = false)
    private boolean isTrue;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "new_question_id", nullable = false)
    private NewQuestion newQuestion;

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setIsTrue(boolean isTrue) {
        this.isTrue = isTrue;
    }

    public void setNewQuestion(NewQuestion newQuestion) {
        this.newQuestion = newQuestion;
    }
}

package com.sopt.ios4.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PACKAGE)
public class QuestionElement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id", nullable = false)
    private Question question;

    @Column(name = "subject")
    private String subject;

    @Column(name = "is_true")
    private boolean isTrue; //영주가 선택한 정답

    public QuestionElement() {

    }
}

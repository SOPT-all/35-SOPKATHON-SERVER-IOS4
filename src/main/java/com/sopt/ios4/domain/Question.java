package com.sopt.ios4.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    @Column(name = "theme")
    private int theme;

    @Column(name = "invitation_code")
    private int invitationCode;

    @OneToMany
    private List<QuestionElement> questionElementList;

    public Question(Member member, int theme, int invitationCode, List<QuestionElement> questionElementList) {
        this.member = member;
        this.theme = theme;
        this.invitationCode = invitationCode;
        this.questionElementList = questionElementList;
    }
}

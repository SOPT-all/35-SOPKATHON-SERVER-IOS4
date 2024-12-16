package com.sopt.ios4.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PUBLIC )
public class NewQuestion { //질문지

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "theme", nullable = false)
    private int theme;

    @Column(name = "invitation_code", nullable = false)
    private int invitationCode;

    @OneToMany(mappedBy = "newQuestion", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<NewQuestionElement> questions = new ArrayList<>();

    public void setTheme(int theme) {
        this.theme = theme;
    }

    public void setInvitationCode(int invitationCode) {
        this.invitationCode = invitationCode;
    }
}

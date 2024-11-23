package com.sopt.ios4.repository;

import com.sopt.ios4.domain.NewQuestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface NewQuestionRepository extends JpaRepository<NewQuestion, Long> {
    Optional<NewQuestion> findByInvitationCode(int invitationCode);
}

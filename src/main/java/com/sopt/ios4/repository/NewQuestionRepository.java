package com.sopt.ios4.repository;

import com.sopt.ios4.domain.NewQuestion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewQuestionRepository extends JpaRepository<NewQuestion, Long> {
}

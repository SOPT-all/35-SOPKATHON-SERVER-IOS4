package com.sopt.ios4.repository;

import com.sopt.ios4.domain.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionnarieRepository extends JpaRepository<Question, Long> {
}

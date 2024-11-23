package com.sopt.ios4.repository;

import com.sopt.ios4.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}

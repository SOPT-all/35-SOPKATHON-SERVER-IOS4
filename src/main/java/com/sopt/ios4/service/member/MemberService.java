package com.sopt.ios4.service.member;

import com.sopt.ios4.domain.Member;
import com.sopt.ios4.dto.request.MemberJoinDto;
import com.sopt.ios4.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    // 회원 가입
    public Member join(MemberJoinDto memberJoinDto) {
        Member member = Member.builder()
                .nickname(memberJoinDto.nickname())
                .build();
        return memberRepository.save(member);
    }
}
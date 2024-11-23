package com.sopt.ios4.service.Member;

import com.sopt.ios4.domain.Member;
import com.sopt.ios4.exception.ErrorCode;
import com.sopt.ios4.exception.InvalidArgsException;
import com.sopt.ios4.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MemberRetriever {
    private final MemberRepository memberRepository;

    public Member findMemberById(final long memberId) {
        return memberRepository.findById(memberId)
                .orElseThrow(() -> new InvalidArgsException(ErrorCode.NOT_EXISTS_MEMBER_WITH_ID));
    }
}

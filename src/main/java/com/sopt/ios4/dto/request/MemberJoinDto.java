package com.sopt.ios4.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;

@Builder
public record MemberJoinDto(
        @NotBlank(message = "Nickname 은 필수로 입력해야 합니다.")
        String nickname
) {
}

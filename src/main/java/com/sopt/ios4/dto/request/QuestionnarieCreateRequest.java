package com.sopt.ios4.dto.request;

import com.sopt.ios4.domain.NewQuestionElement;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

import java.util.List;

@Builder
public record QuestionnarieCreateRequest(
        @NotNull(message="테마는 반드시 선택되어야 합니다.")
        int theme,
        @NotNull(message="질문과 정답은 반드시 전부 지정되어야 합니다.")
        List<QuestionnarieDto> questions
) {
    @Builder
    public record QuestionnarieDto(
            String subject,
            boolean answer
    ){}
}


package com.example.puddingbe.domain.notice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import jakarta.validation.constraints.NotBlank;

@Getter
@Builder
@AllArgsConstructor
public class NoticeCreateRequest {
    @NotBlank(message="title는 필수입니다.")
    private String title;

    @NotBlank(message = "content는 필수입니다.")
    private String content;
}

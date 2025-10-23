package com.example.puddingbe.domain.notice.presentation.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import jakarta.validation.constraints.NotBlank;

@Getter
@AllArgsConstructor
public class NoticeCreateRequest {
    @NotBlank(message="title는 필수입니다.")
    private String title;

    @NotBlank(message = "content는 필수입니다.")
    private String content;
}

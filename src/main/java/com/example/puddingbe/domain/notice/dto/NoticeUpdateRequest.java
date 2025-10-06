package com.example.puddingbe.domain.notice.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class NoticeUpdateRequest {
    @NotBlank(message="id는 필수입니다.")
    private long id;

    @NotBlank(message="title는 필수입니다.")
    private String title;

    @NotBlank(message="content는 필수입니다.")
    private String content;
}
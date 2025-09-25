package com.example.puddingbe.global.inquiry.domain.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class InquiryResponse {
    private long id;
    private long userId;
    private String title;
    private String content;
    private LocalDateTime createdAt;
    private String reply;

    @Builder
    public InquiryResponse(Long id, Long userId, String title, String content, LocalDateTime createdAt, String reply) {
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.content = content;
        this.createdAt = createdAt;
        this.reply = reply;
    }
}

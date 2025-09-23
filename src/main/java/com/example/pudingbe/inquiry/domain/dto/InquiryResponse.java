package com.example.pudingbe.inquiry.domain.dto;

import com.example.pudingbe.inquiry.domain.entity.Inquiry;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class InquiryResponse {
    private long id;
    private long userId;
    private String title;
    private String content;
    private LocalDateTime createdAt;
    private String reply;

    public InquiryResponse(Inquiry inquiry) {
        this.id = inquiry.getId();
        this.userId = inquiry.getUserId();
        this.title = inquiry.getTitle();
        this.content = inquiry.getContent();
        this.createdAt = inquiry.getCreatedAt();
        this.reply = inquiry.getReply();
    }
}
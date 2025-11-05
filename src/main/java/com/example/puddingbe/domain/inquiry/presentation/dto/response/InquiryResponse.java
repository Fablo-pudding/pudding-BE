package com.example.puddingbe.domain.inquiry.presentation.dto.response;

import com.example.puddingbe.domain.inquiry.domain.Inquiry;
import com.example.puddingbe.domain.user.domain.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class InquiryResponse {
    private long id;
    private User user;
    private String title;
    private String content;
    private LocalDateTime createdAt;
    private String reply;

    public InquiryResponse(Inquiry inquiry) {
        this.id = inquiry.getId();
        this.user = inquiry.getUser();
        this.title = inquiry.getTitle();
        this.content = inquiry.getContent();
        this.createdAt = inquiry.getCreatedAt();
        this.reply = inquiry.getReply();
    }
}

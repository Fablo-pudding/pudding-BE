package com.example.puddingbe.domain.notice.presentation.dto;

import com.example.puddingbe.domain.notice.domain.NoticeUser;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class NoticeCheckResponse {
    private Long id;
    private String registerEmployeeNo;
    private String title;
    private String content;
    private LocalDateTime createdAt;

    public NoticeCheckResponse(NoticeUser noticeUser) {
        this.id = noticeUser.getId();
        this.registerEmployeeNo = noticeUser.getRegisterEmployeeNo();
        this.title = noticeUser.getTitle();
        this.content = noticeUser.getContent();
        this.createdAt = LocalDateTime.now();
    }
}

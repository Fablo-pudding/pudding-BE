package com.example.puddingbe.domain.notice.presentation.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import java.time.LocalDateTime;
import com.example.puddingbe.domain.notice.domain.NoticeUser;

@Getter
@AllArgsConstructor
public class NoticeReadResponse {

    private long id;
    private String title;
    private String registerEmployeeNo;
    private LocalDateTime createdAt;

    public NoticeReadResponse(NoticeUser noticeUser) {
        this.id = noticeUser.getId();
        this.title = noticeUser.getTitle();
        this.createdAt = noticeUser.getRegisterDatetime();
        this.registerEmployeeNo = noticeUser.getRegisterEmployeeNo();
    }
}

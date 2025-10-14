package com.example.puddingbe.domain.notice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import java.time.LocalDateTime;
import com.example.puddingbe.domain.notice.domain.NoticeUser;

@Getter
@AllArgsConstructor
public class NoticeReadResponse {

    private long id;
    private String title;
    private String content;
    private LocalDateTime registerDateTime;
    private LocalDateTime updateDateTime;
    private String registerEmployeeNo;
    private String updateEmployeeNo;

    public NoticeReadResponse(NoticeUser noticeUser) {
        this.id = noticeUser.getId();
        this.title = noticeUser.getTitle();
        this.content = noticeUser.getContent();
        this.registerDateTime = noticeUser.getRegisterDatetime();
        this.updateDateTime = noticeUser.getUpdateDatetime();
        this.registerEmployeeNo = noticeUser.getRegisterEmployeeNo();
        this.updateEmployeeNo = noticeUser.getUpdateEmployeeNo();
    }
}

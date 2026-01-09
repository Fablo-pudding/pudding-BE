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
    private String profileImageUrl;

    public NoticeCheckResponse(NoticeUser noticeUser) {
        this.id = noticeUser.getId();
<<<<<<< HEAD
        this.profileImageUrl = noticeUser.getUser().getProfileImageUrl();
=======
>>>>>>> 89443cb (refacotring 공지사항 작성자추가)
        this.registerEmployeeNo = noticeUser.getRegisterEmployeeNo();
        this.title = noticeUser.getTitle();
        this.content = noticeUser.getContent();
        this.createdAt = LocalDateTime.now();
    }
}

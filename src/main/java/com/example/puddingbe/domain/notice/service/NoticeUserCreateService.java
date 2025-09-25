package com.example.puddingbe.domain.notice.service;

import com.example.puddingbe.domain.notice.repository.NoticeUserRepository;
import com.example.puddingbe.domain.notice.domain.NoticeUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
@Service

public class NoticeUserCreateService {
    @Autowired
    private NoticeUserRepository noticeUserRepository;
    private LocalDateTime localDateTime = LocalDateTime.now();

    public ResponseEntity<NoticeUser> createNotice(NoticeUser noticeUser) {
        noticeUser.setUpdateDatetime(localDateTime);
        noticeUser.setRegisterDatetime(localDateTime);

        this.noticeUserRepository.save(noticeUser);

        return ResponseEntity.ok().build();
    }
}

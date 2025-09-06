package com.example.pudingbe.notice.service;

import com.example.pudingbe.notice.domain.NoticeUser;
import com.example.pudingbe.notice.repository.NoticeUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class NoticeUserService {
    @Autowired
    private NoticeUserRepository noticeUserRepository;
    private LocalDateTime localDateTime = LocalDateTime.now();

    public ResponseEntity<NoticeUser> PostNotice(NoticeUser noticeUser) {
        noticeUser.setUpdateDatetime(localDateTime);
        noticeUser.setRegisterDatetime(localDateTime);

        this.noticeUserRepository.save(noticeUser);

        return ResponseEntity.ok().build();
    }
    public List<NoticeUser> GetNotices() {
        return this.noticeUserRepository.findAll();
    }
}

package com.example.puddingbe.domain.notice.service;

import com.example.puddingbe.domain.notice.domain.NoticeUser;
import com.example.puddingbe.domain.notice.repository.NoticeUserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class NoticeUserDeleteService {

    private final NoticeUserRepository noticeUserRepository;

    public NoticeUserDeleteService(NoticeUserRepository noticeUserRepository) {
        this.noticeUserRepository = noticeUserRepository;
    }

    public ResponseEntity<NoticeUser> deleteNotice(Long id) {
        Optional<NoticeUser> optNoticeUser = this.noticeUserRepository.findById(id);
        if (optNoticeUser.isEmpty()) {
            System.out.println("[Error:DeletedNoticeId] There is no notice user with id (" + id + ")");
            TODO:
            return ResponseEntity.notFound().build();
        } else {
            this.noticeUserRepository.delete(optNoticeUser.get());
        }
        return ResponseEntity.ok().build();
    }
}

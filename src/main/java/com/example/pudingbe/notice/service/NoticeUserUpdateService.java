package com.example.pudingbe.notice.service;

import com.example.pudingbe.notice.domain.NoticeUser;
import com.example.pudingbe.notice.repository.NoticeUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor

public class NoticeUserUpdateService {
    private final NoticeUserRepository noticeUserRepository;
    public ResponseEntity<NoticeUser> updateNotice(NoticeUser noticeUser, long id) {
        Optional<NoticeUser> optNoticeUser = this.noticeUserRepository.findById(id);
        if(optNoticeUser.isEmpty()) {
            System.out.println("[Error:PutNoticeId] There is no data of id (" + id + ")");
            TODO:
            return ResponseEntity.notFound().build();
        }
        else{
            NoticeUser afterNoticeUser = optNoticeUser.get();
            System.out.println("afterNoticeUser: " + afterNoticeUser.toString());

            afterNoticeUser.setUpdateDatetime(LocalDateTime.now());
            afterNoticeUser.setUpdateEmployeeNo(noticeUser.getUpdateEmployeeNo());

            afterNoticeUser.setTitle(noticeUser.getTitle());
            afterNoticeUser.setContent(noticeUser.getContent());

            this.noticeUserRepository.save(afterNoticeUser);
        }
        return ResponseEntity.ok().build();
    }
}

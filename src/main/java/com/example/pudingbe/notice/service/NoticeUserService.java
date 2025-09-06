package com.example.pudingbe.notice.service;

import com.example.pudingbe.notice.domain.NoticeUser;
import com.example.pudingbe.notice.repository.NoticeUserRepository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

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


    public ResponseEntity<NoticeUser> PutNoticeById(NoticeUser noticeUser, long id) {
        Optional<NoticeUser> optNoticeUser = this.noticeUserRepository.findById(id);
    if(optNoticeUser.isEmpty()) {
        System.out.println("[Error:PutNoticeId] There is no data of id (" + id + ")");
        TODO:
            return ResponseEntity.notFound().build();
    }
    else{
        NoticeUser afterNoticeUser = optNoticeUser.get();
        System.out.println("afterNoticeUser: " + afterNoticeUser.toString());

        afterNoticeUser.setUpdateDatetime(localDateTime);
        afterNoticeUser.setUpdateEmployeeNo(noticeUser.getUpdateEmployeeNo());

        afterNoticeUser.setTitle(noticeUser.getTitle());
        afterNoticeUser.setContent(noticeUser.getContent());

        this.noticeUserRepository.save(afterNoticeUser);
    }
    return ResponseEntity.ok().build();
    }

    public ResponseEntity<NoticeUser> DeleteNotice(Long id) {
        Optional<NoticeUser> optNoticeUser = this.noticeUserRepository.findById(id);

        if(optNoticeUser.isEmpty()){
        System.out.println("[Error:DeletedNoticeId] There is no notice user with id (" + id + ")");
        TODO:
            return ResponseEntity.notFound().build();
        }
        else{
            this.noticeUserRepository.delete(optNoticeUser.get());
        }
        return ResponseEntity.ok().build();
    }
}

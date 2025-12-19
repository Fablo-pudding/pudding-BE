package com.example.puddingbe.domain.notice.service;

import com.example.puddingbe.domain.notice.domain.NoticeUser;
import com.example.puddingbe.domain.notice.domain.repository.NoticeUserRepository;
import com.example.puddingbe.domain.notice.exception.NoticeAdminCanDelete;
import com.example.puddingbe.domain.notice.exception.NoticeNotFoundException;
import com.example.puddingbe.global.detail.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class NoticeUserDeleteService {

    private final NoticeUserRepository noticeUserRepository;
    private final UserFacade userFacade;

    public ResponseEntity<NoticeUser> deleteNotice(Long id) {
        Boolean isAdmin = userFacade.isAdmin();
        if (!isAdmin) {
            throw NoticeAdminCanDelete.EXCEPTION;
        }

        Optional<NoticeUser> optNoticeUser = this.noticeUserRepository.findById(id);
        if (optNoticeUser.isEmpty()) {
            throw NoticeNotFoundException.EXCEPTION;
        } else {
            this.noticeUserRepository.delete(optNoticeUser.get());
        }
        return ResponseEntity.ok().build();
    }
}

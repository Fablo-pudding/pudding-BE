package com.example.puddingbe.domain.notice.service;

import com.example.puddingbe.domain.notice.domain.NoticeUser;
import com.example.puddingbe.domain.notice.domain.repository.NoticeUserRepository;
import com.example.puddingbe.domain.notice.exception.NoticeAdminCanDelete;
import com.example.puddingbe.domain.notice.exception.NoticeNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class NoticeUserDeleteService {

    private final NoticeUserRepository noticeUserRepository;

    public NoticeUserDeleteService(NoticeUserRepository noticeUserRepository) {
        this.noticeUserRepository = noticeUserRepository;
    }

    public ResponseEntity<NoticeUser> deleteNotice(Long id) {
        Boolean isAdmin = SecurityContextHolder.getContext().getAuthentication()
                .getAuthorities()
                .stream()
                .anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN"));
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

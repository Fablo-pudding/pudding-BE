package com.example.puddingbe.domain.notice.service;

import com.example.puddingbe.domain.inquiry.exception.UnauthorizedException;
import com.example.puddingbe.domain.notice.domain.NoticeUser;
import com.example.puddingbe.domain.notice.domain.repository.NoticeUserRepository;
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
            throw new UnauthorizedException("관리자만 공지를 삭제할 수 있습니다.");
        }

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

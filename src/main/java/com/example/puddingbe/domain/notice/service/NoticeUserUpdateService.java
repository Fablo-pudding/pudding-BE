package com.example.puddingbe.domain.notice.service;

import com.example.puddingbe.domain.inquiry.exception.UnauthorizedException;
import com.example.puddingbe.domain.notice.domain.NoticeUser;
import com.example.puddingbe.domain.notice.presentation.dto.NoticeUpdateRequest;
import com.example.puddingbe.domain.notice.domain.repository.NoticeUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NoticeUserUpdateService {

    private final NoticeUserRepository noticeUserRepository;

    public void updateNotice(Long id, NoticeUpdateRequest request) {
        Boolean isAdmin = SecurityContextHolder.getContext().getAuthentication()
                .getAuthorities()
                .stream()
                .anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN"));
        if (!isAdmin) {
            throw new UnauthorizedException("관리자만 공지를 수정할 수 있습니다.");
        }

        NoticeUser noticeUser = noticeUserRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 공지가 존재하지 않습니다."));

        noticeUser.setTitle(request.getTitle());
        noticeUser.setContent(request.getContent());
        noticeUser.setRegisterEmployeeNo("admin");
        noticeUser.setUpdateEmployeeNo("admin");

        noticeUserRepository.save(noticeUser);
    }
}

package com.example.puddingbe.domain.notice.service;

import com.example.puddingbe.domain.inquiry.exception.UnauthorizedException;
import com.example.puddingbe.domain.notice.domain.NoticeUser;
import com.example.puddingbe.domain.notice.presentation.dto.NoticeCreateRequest;
import com.example.puddingbe.domain.notice.domain.repository.NoticeUserRepository;
import com.example.puddingbe.global.detail.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class NoticeUserCreateService {

    private final NoticeUserRepository noticeUserRepository;
    private final UserFacade userFacade;

    public void createNotice(NoticeCreateRequest request) {
        Boolean isAdmin = SecurityContextHolder.getContext().getAuthentication()
                .getAuthorities()
                .stream()
                .anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN"));
        if (!isAdmin) {
            throw new UnauthorizedException("관리자만 공지를 작성할 수 있습니다.");
        }

        NoticeUser noticeUser = NoticeUser.builder()
                .title(request.getTitle())
                .content(request.getContent())
                .registerEmployeeNo("admin")
                .updateEmployeeNo("admin")
                .registerDatetime(LocalDateTime.now())
                .updateDatetime(LocalDateTime.now())
                .build();

        noticeUserRepository.save(noticeUser);
        }
    }

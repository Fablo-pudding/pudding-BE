package com.example.puddingbe.domain.notice.service;

import com.example.puddingbe.domain.notice.domain.NoticeUser;
import com.example.puddingbe.domain.notice.exception.NoticeAdminCanCreate;
import com.example.puddingbe.domain.notice.presentation.dto.NoticeCreateRequest;
import com.example.puddingbe.domain.notice.domain.repository.NoticeUserRepository;
import com.example.puddingbe.domain.user.domain.User;
import com.example.puddingbe.domain.user.domain.repository.UserRepository;
import com.example.puddingbe.global.detail.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class NoticeUserCreateService {

    private final NoticeUserRepository noticeUserRepository;
    private final UserFacade userFacade;
    private final UserRepository userRepository;

    public void createNotice(NoticeCreateRequest request) {
        Boolean isAdmin = userFacade.isAdmin();
        if (!isAdmin) {
            throw NoticeAdminCanCreate.EXCEPTION;
        }
        Long currentUserId = userFacade.getUserId();

        User user = userRepository.findById(currentUserId)
                .orElseThrow(()->new IllegalArgumentException("유효하지 않은 사용자 정보입니다."));

        NoticeUser noticeUser = NoticeUser.builder()
                .title(request.getTitle())
                .content(request.getContent())
                .user(user)
                .registerEmployeeNo("Admin")
                .updateEmployeeNo("Admin")
                .registerDatetime(LocalDateTime.now())
                .updateDatetime(LocalDateTime.now())
                .build();

        noticeUserRepository.save(noticeUser);
        }
    }

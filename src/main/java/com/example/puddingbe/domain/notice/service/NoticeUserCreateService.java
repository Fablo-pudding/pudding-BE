package com.example.puddingbe.domain.notice.service;

import com.example.puddingbe.domain.notice.domain.NoticeUser;
import com.example.puddingbe.domain.notice.exception.NoticeAdminCanCreate;
import com.example.puddingbe.domain.notice.presentation.dto.NoticeCreateRequest;
import com.example.puddingbe.domain.notice.domain.repository.NoticeUserRepository;
import com.example.puddingbe.global.detail.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class NoticeUserCreateService {

    private final NoticeUserRepository noticeUserRepository;
    private final UserFacade userFacade;

    public void createNotice(NoticeCreateRequest request) {
        Boolean isAdmin = userFacade.isAdmin();
        if (!isAdmin) {
            throw NoticeAdminCanCreate.EXCEPTION;
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

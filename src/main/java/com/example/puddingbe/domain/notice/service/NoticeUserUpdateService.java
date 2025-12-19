package com.example.puddingbe.domain.notice.service;

import com.example.puddingbe.domain.inquiry.exception.UnauthorizedException;
import com.example.puddingbe.domain.notice.domain.NoticeUser;
import com.example.puddingbe.domain.notice.exception.NoticeAdminCanUpdate;
import com.example.puddingbe.domain.notice.exception.NoticeNotFoundException;
import com.example.puddingbe.domain.notice.presentation.dto.NoticeUpdateRequest;
import com.example.puddingbe.domain.notice.domain.repository.NoticeUserRepository;
import com.example.puddingbe.global.detail.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NoticeUserUpdateService {

    private final NoticeUserRepository noticeUserRepository;
    private final UserFacade userFacade;

    public void updateNotice(Long id, NoticeUpdateRequest request) {
        Boolean isAdmin = userFacade.isAdmin();
        if (!isAdmin) {
            throw (NoticeAdminCanUpdate.EXCEPTION);
        }

        NoticeUser noticeUser = noticeUserRepository.findById(id)
                .orElseThrow(() -> NoticeNotFoundException.EXCEPTION);

        noticeUser.setTitle(request.getTitle());
        noticeUser.setContent(request.getContent());
        noticeUser.setRegisterEmployeeNo("admin");
        noticeUser.setUpdateEmployeeNo("admin");

        noticeUserRepository.save(noticeUser);
    }
}

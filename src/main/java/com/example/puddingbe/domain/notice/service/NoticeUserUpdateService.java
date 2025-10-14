package com.example.puddingbe.domain.notice.service;

import com.example.puddingbe.domain.notice.domain.NoticeUser;
import com.example.puddingbe.domain.notice.dto.NoticeUpdateRequest;
import com.example.puddingbe.domain.notice.repository.NoticeUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NoticeUserUpdateService {

    private final NoticeUserRepository noticeUserRepository;

    public void updateNotice(Long id, NoticeUpdateRequest request) {
        NoticeUser noticeUser = noticeUserRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 공지가 존재하지 않습니다."));

        noticeUser.setTitle(request.getTitle());
        noticeUser.setContent(request.getContent());
        noticeUser.setRegisterEmployeeNo("admin");
        noticeUser.setUpdateEmployeeNo("admin");

        noticeUserRepository.save(noticeUser);
    }
}
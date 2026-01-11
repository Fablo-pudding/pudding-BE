package com.example.puddingbe.domain.notice.service;

import com.example.puddingbe.domain.notice.domain.NoticeUser;
import com.example.puddingbe.domain.notice.domain.repository.NoticeUserRepository;
import com.example.puddingbe.domain.notice.exception.NoticeNotFoundException;
import com.example.puddingbe.domain.notice.presentation.dto.NoticeCheckResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class NoticeUserCheckService {
    private final NoticeUserRepository noticeUserRepository;

    @Transactional(readOnly = true)
    public NoticeCheckResponse readOne(Long id) {
        NoticeUser noticeUser = noticeUserRepository.findById(id)
                .orElseThrow(() -> NoticeNotFoundException.EXCEPTION);
        return new NoticeCheckResponse(noticeUser);
    }

}
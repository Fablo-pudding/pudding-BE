package com.example.puddingbe.domain.notice.service;

import com.example.puddingbe.domain.notice.domain.NoticeUser;
import com.example.puddingbe.domain.notice.domain.repository.NoticeUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.example.puddingbe.domain.notice.presentation.dto.NoticeReadResponse;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor

public class NoticeUserReadService {
    private final NoticeUserRepository noticeUserRepository;

    @Transactional(readOnly = true)
    public List<NoticeReadResponse> readNotices() {
        List<NoticeUser> notices = noticeUserRepository.findAll();
        return notices.stream()
                .map(NoticeReadResponse::new)
                .collect(Collectors.toList());
    }

}

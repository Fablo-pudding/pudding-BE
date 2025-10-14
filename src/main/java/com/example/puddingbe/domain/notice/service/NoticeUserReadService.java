package com.example.puddingbe.domain.notice.service;

import com.example.puddingbe.domain.notice.domain.NoticeUser;
import com.example.puddingbe.domain.notice.repository.NoticeUserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class NoticeUserReadService {
    private final NoticeUserRepository noticeUserRepository;

    public NoticeUserReadService(NoticeUserRepository noticeUserRepository) {
        this.noticeUserRepository = noticeUserRepository;
    }

    public List<NoticeUser> readNotices() {
        return this.noticeUserRepository.findAll();
    }
}

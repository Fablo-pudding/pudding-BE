package com.example.puddingbe.domain.notice.service;

import com.example.puddingbe.domain.notice.domain.NoticeUser;
import com.example.puddingbe.domain.notice.dto.NoticeCreateRequest;
import com.example.puddingbe.domain.notice.repository.NoticeUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class NoticeUserCreateService {

    private final NoticeUserRepository noticeUserRepository;
    public void createNotice(NoticeCreateRequest request) {
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

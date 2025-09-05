package com.example.pudingbe.notice.controller;

import com.example.pudingbe.notice.domain.NoticeUser;
import com.example.pudingbe.notice.service.NoticeUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/notice")
public class NoticeUserController {
    @Autowired
    private NoticeUserService noticeUserService;

    @PostMapping("")
    public ResponseEntity<NoticeUser> PostNotice(@RequestBody NoticeUser noticeUser) {
        System.out.println("[NoticeUser:PostNotice]" + noticeUser);

        return this.noticeUserService.PostNotice(noticeUser);

    }
}

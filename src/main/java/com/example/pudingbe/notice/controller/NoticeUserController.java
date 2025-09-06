package com.example.pudingbe.notice.controller;

import com.example.pudingbe.notice.domain.NoticeUser;
import com.example.pudingbe.notice.service.NoticeUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @GetMapping("")
    public List<NoticeUser> GetNotices(){
        System.out.println("[NoticeUser:GetNotices]");
        return this.noticeUserService.GetNotices();
    }

    @PutMapping("/{id}")
    public ResponseEntity<NoticeUser> PutNoticeById(@RequestBody NoticeUser noticeUser, @PathVariable Long id) {
        System.out.println("[NoticeUser:PutNoticeById]" + noticeUser);

        return this.noticeUserService.PutNoticeById(noticeUser, id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<NoticeUser> DeleteNotice(@PathVariable Long id) {
        System.out.println("[NoticeUser:DeleteNotice]" + id);

        return this.noticeUserService.DeleteNotice(id);
    }
}

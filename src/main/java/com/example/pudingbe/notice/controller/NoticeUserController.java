package com.example.pudingbe.notice.controller;

import com.example.pudingbe.notice.domain.NoticeUser;
import com.example.pudingbe.notice.service.NoticeUserCreateService;
import com.example.pudingbe.notice.service.NoticeUserDeleteService;
import com.example.pudingbe.notice.service.NoticeUserReadService;
import com.example.pudingbe.notice.service.NoticeUserUpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/notice")
public class NoticeUserController {
    @Autowired
    private NoticeUserCreateService noticeUserCreateService;
    @Autowired
    private NoticeUserReadService noticeUserReadService;
    @Autowired
    private NoticeUserUpdateService noticeUserUpdateService;
    @Autowired
    private NoticeUserDeleteService noticeUserDeleteService;


    //create
    @PostMapping("")
    public ResponseEntity<NoticeUser> PostNotice(@RequestBody NoticeUser noticeUser) {
        System.out.println("[NoticeUser:PostNotice]" + noticeUser);
        return this.noticeUserCreateService.PostNotice(noticeUser);
    }

    //read
    @GetMapping("")
    public List<NoticeUser> GetNotices(){
        System.out.println("[NoticeUser:GetNotices]");
        return this.noticeUserReadService.GetNotices();
    }

    //update
    @PutMapping("/{id}")
    public ResponseEntity<NoticeUser> PutNoticeById(@RequestBody NoticeUser noticeUser, @PathVariable Long id) {
        System.out.println("[NoticeUser:PutNoticeById]" + noticeUser);
        return this.noticeUserUpdateService.PutNoticeById(noticeUser, id);
    }

    //delete
    @DeleteMapping("/{id}")
    public ResponseEntity<NoticeUser> deleteNotice(@PathVariable Long id) {
        System.out.println("[NoticeUser:DeleteNotice] id (" + id + ")");
        return this.noticeUserDeleteService.DeleteNotice(id);
    }
}

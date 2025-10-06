package com.example.puddingbe.domain.notice.controller;

import com.example.puddingbe.domain.notice.domain.NoticeUser;
import com.example.puddingbe.domain.notice.service.NoticeUserCreateService;
import com.example.puddingbe.domain.notice.service.NoticeUserDeleteService;
import com.example.puddingbe.domain.notice.service.NoticeUserReadService;
import com.example.puddingbe.domain.notice.service.NoticeUserUpdateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/notice")
@RequiredArgsConstructor
public class NoticeUserController {

    private final NoticeUserCreateService noticeUserCreateService;
    private final NoticeUserReadService noticeUserReadService;
    private final NoticeUserUpdateService noticeUserUpdateService;
    private final NoticeUserDeleteService noticeUserDeleteService;


    //create
    @PostMapping("")
    public ResponseEntity<NoticeUser> createNotice(@RequestBody NoticeUser noticeUser) {
        return this.noticeUserCreateService.createNotice(noticeUser);
    }

    //read
    @GetMapping("")
    public List<NoticeUser> readNotices(){
        return this.noticeUserReadService.readNotices();
    }

    //update
    @PutMapping("/{id}")
    public ResponseEntity<NoticeUser> updateNotice(@RequestBody NoticeUser noticeUser, @PathVariable Long id) {
        return this.noticeUserUpdateService.updateNotice(noticeUser, id);
    }

    //delete
    @DeleteMapping("/{id}")
    public ResponseEntity<NoticeUser> deleteNotice(@PathVariable Long id) {
        return this.noticeUserDeleteService.deleteNotice(id);
    }
}
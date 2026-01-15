package com.example.puddingbe.domain.notice.presentation;

import com.example.puddingbe.domain.notice.domain.NoticeUser;
import com.example.puddingbe.domain.notice.presentation.dto.*;
import com.example.puddingbe.domain.notice.service.*;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/notice")
@RequiredArgsConstructor
public class NoticeUserController {

    private final NoticeUserCreateService noticeUserCreateService;
    private final NoticeUserReadService noticeUserReadService;
    private final NoticeUserUpdateService noticeUserUpdateService;
    private final NoticeUserDeleteService noticeUserDeleteService;
    private final NoticeUserCheckService noticeUserCheckService;


    //create
    @PostMapping("/create")
    public NoticeCreateResponse createNotice(@Valid @RequestBody NoticeCreateRequest request) {
        return noticeUserCreateService.createNotice(request);
    }

    //read
    @GetMapping("/get-list")
    public List<NoticeReadResponse> readNotices(){
        return noticeUserReadService.readNotices();
    }

    //update
    @PatchMapping("/update/{id}")
    public ResponseEntity<Void> updateNotice(@PathVariable Long id, @Valid @RequestBody NoticeUpdateRequest request) {
        noticeUserUpdateService.updateNotice(id, request);
        return ResponseEntity.ok().build();
    }

    //delete
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<NoticeUser> deleteNotice(@PathVariable Long id) {
        return noticeUserDeleteService.deleteNotice(id);
    }

    @GetMapping("/read/{id}")
    public ResponseEntity<NoticeCheckResponse> checkNotice(@PathVariable Long id) {
        return ResponseEntity.ok(noticeUserCheckService.readOne(id));
    }
}

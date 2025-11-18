package com.example.puddingbe.domain.notice.presentation;

import com.example.puddingbe.domain.notice.domain.NoticeUser;
import com.example.puddingbe.domain.notice.presentation.dto.NoticeCreateRequest;
import com.example.puddingbe.domain.notice.presentation.dto.NoticeReadResponse;
import com.example.puddingbe.domain.notice.presentation.dto.NoticeUpdateRequest;
import com.example.puddingbe.domain.notice.service.NoticeUserCreateService;
import com.example.puddingbe.domain.notice.service.NoticeUserDeleteService;
import com.example.puddingbe.domain.notice.service.NoticeUserReadService;
import com.example.puddingbe.domain.notice.service.NoticeUserUpdateService;
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


    //create
    @PostMapping("/create")
    public ResponseEntity<Void> createNotice(@Valid @RequestBody NoticeCreateRequest request) {
        noticeUserCreateService.createNotice(request);
        return ResponseEntity.ok().build();
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
}

package com.example.pudingbe.inquiry.controller;

import com.example.pudingbe.inquiry.domain.dto.InquiryReplyRequest;
import com.example.pudingbe.inquiry.domain.dto.InquiryResponse;
import com.example.pudingbe.inquiry.service.InquiryUpdateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/inquiry")
@RequiredArgsConstructor
public class InquiryController {
    private final InquiryUpdateService inquiryUpdateService;

    @PostMapping("/{id}/reply")
    @ResponseStatus(HttpStatus.CREATED)
    public void replyToInquiry(@PathVariable Long id, @RequestBody InquiryReplyRequest request) {
        //TODO: ADMIN 권한 체크
        boolean isAdmin = true; //임시
        inquiryUpdateService.replyToInquiry(id, request, isAdmin);
    }
}

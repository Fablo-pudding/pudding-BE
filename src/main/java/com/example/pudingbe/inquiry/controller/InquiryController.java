package com.example.pudingbe.inquiry.controller;

import com.example.pudingbe.inquiry.service.InquiryDeleteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/inquiry")
@RequiredArgsConstructor
public class InquiryController {
    private final InquiryDeleteService inquiryDeleteService;

    @DeleteMapping("/{inquiry-id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteInquiry(@PathVariable("inquiry-id") Long id) {
        Long currentUserId = 0L; //임시 값 TODO: 로그인 사용자 ID 체크
        boolean isAdmin = false; //임시 값 TODO: 로그인 사용자 권한 체크
        inquiryDeleteService.deleteInquiry(id, currentUserId, isAdmin);
    }
}

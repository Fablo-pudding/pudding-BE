package com.example.puddingbe.domain.inquiry.controller;

import com.example.puddingbe.domain.inquiry.domain.dto.InquiryReplyRequest;
import com.example.puddingbe.domain.inquiry.service.InquiryUpdateService;
import com.example.puddingbe.domain.inquiry.domain.dto.InquiryResponse;
import com.example.puddingbe.domain.inquiry.service.InquiryReadService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.example.puddingbe.domain.inquiry.service.InquiryDeleteService;
import com.example.puddingbe.domain.inquiry.domain.dto.InquiryRequest;
import com.example.puddingbe.domain.inquiry.service.InquiryCreateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/inquiry")
@RequiredArgsConstructor
public class InquiryController {
    private final InquiryReadService inquiryReadService;
    private final InquiryDeleteService inquiryDeleteService;
    private final InquiryCreateService inquiryCreateService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<InquiryResponse> getAllInquiries() {
        //TODO: ADMIN 권한 체크
        return inquiryReadService.getAllInquiries();
    }

    @GetMapping("/{inquiry-id}")
    @ResponseStatus(HttpStatus.OK)
    public InquiryResponse getInquiryById(@PathVariable("inquiry-id") Long id) {
        //TODO: ADMIN, 작성자 권한 체크
        return inquiryReadService.getInquiryById(id);
    }

    @GetMapping("/my/{user-id}")
    @ResponseStatus(HttpStatus.OK)
    public List<InquiryResponse> getMyInquiries(@PathVariable("user-id") Long userId) {
        //TODO: 작성자 권한 체크
        return inquiryReadService.getMyInquiries(userId);
    }
  
    @PostMapping("/{inquiry-id}/reply")
    @ResponseStatus(HttpStatus.CREATED)
    public void replyToInquiry(@PathVariable("inquiry-id") Long id, @RequestBody InquiryReplyRequest request) {
        //TODO: ADMIN 권한 체크
        boolean isAdmin = true; //임시
        inquiryUpdateService.replyToInquiry(id, request, isAdmin);
    }
  
    @DeleteMapping("/{inquiry-id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteInquiry(@PathVariable("inquiry-id") Long id) {
        Long currentUserId = 0L; //임시 값 TODO: 로그인 사용자 ID 체크
        boolean isAdmin = false; //임시 값 TODO: 로그인 사용자 권한 체크
        inquiryDeleteService.deleteInquiry(id, currentUserId, isAdmin);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createInquiry(@RequestBody InquiryRequest request) {
        inquiryCreateService.createInquiry(request);
    }
}

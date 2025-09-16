package com.example.pudingbe.inquiry.controller;

import com.example.pudingbe.inquiry.domain.dto.InquiryReplyRequest;
import com.example.pudingbe.inquiry.domain.dto.InquiryRequest;
import com.example.pudingbe.inquiry.domain.dto.InquiryResponse;
import com.example.pudingbe.inquiry.service.InquiryCreateService;
import com.example.pudingbe.inquiry.service.InquiryDeleteService;
import com.example.pudingbe.inquiry.service.InquiryReadService;
import com.example.pudingbe.inquiry.service.InquiryUpdateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/inquiry")
@RequiredArgsConstructor
public class InquiryController {
    private final InquiryCreateService inquiryCreateService;
    private final InquiryReadService inquiryReadService;
    private final InquiryUpdateService inquiryUpdateService;
    private final InquiryDeleteService inquiryDeleteService;

    @PostMapping
    public ResponseEntity<InquiryResponse> createInquiry(@RequestBody InquiryRequest request) {
        return ResponseEntity.ok(inquiryCreateService.createInquiry((request)));
    }

    @GetMapping
    public ResponseEntity<List<InquiryResponse>> getAllInquiries() {
        //TODO: ADMIN 권한 체크
        return ResponseEntity.ok(inquiryReadService.getAllInquiries());
    }

    @GetMapping("/{id}")
    public ResponseEntity<InquiryResponse> getInquiryById(@PathVariable Long id) {
        return ResponseEntity.ok(inquiryReadService.getInquiryById(id));
    }

    @PostMapping("/{id}/reply")
    public ResponseEntity<InquiryResponse> replyToInquiry(@PathVariable Long id, @RequestBody InquiryReplyRequest request) {
        //TODO: ADMIN 권한 체크
        boolean isAdmin = true; //임시
        return ResponseEntity.ok(inquiryUpdateService.replyToInquiry(id, request, isAdmin));
    }

    @GetMapping("/my/{userId}")
    public ResponseEntity<List<InquiryResponse>> getMyInquiries(@PathVariable Long userId) {
        return ResponseEntity.ok(inquiryReadService.getMyInquiries(userId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInquiry(@PathVariable Long id) {
        Long currentUserId = 0L; //임시 값 TODO: 로그인 사용자 ID 체크
        boolean isAdmin = false; //임시 값 TODO: 로그인 사용자 권한 체크
        inquiryDeleteService.deleteInquiry(id, currentUserId, isAdmin);
        return ResponseEntity.noContent().build();
    }
}

package com.example.pudingbe.inquiry.controller;

import com.example.pudingbe.inquiry.domain.dto.InquiryResponse;
import com.example.pudingbe.inquiry.service.InquiryReadService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/inquiry")
@RequiredArgsConstructor
public class InquiryController {
    private final InquiryReadService inquiryReadService;

    @GetMapping
    public ResponseEntity<List<InquiryResponse>> getAllInquiries() {
        //TODO: ADMIN 권한 체크
        return ResponseEntity.ok(inquiryReadService.getAllInquiries());
    }

    @GetMapping("/{id}")
    public ResponseEntity<InquiryResponse> getInquiryById(@PathVariable Long id) {
        return ResponseEntity.ok(inquiryReadService.getInquiryById(id));
    }

    @GetMapping("/my/{userId}")
    public ResponseEntity<List<InquiryResponse>> getMyInquiries(@PathVariable Long userId) {
        return ResponseEntity.ok(inquiryReadService.getMyInquiries(userId));
    }
}

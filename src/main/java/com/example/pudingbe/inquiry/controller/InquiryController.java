package com.example.pudingbe.inquiry.controller;

import com.example.pudingbe.inquiry.domain.dto.InquiryRequest;
import com.example.pudingbe.inquiry.domain.dto.InquiryResponse;
import com.example.pudingbe.inquiry.service.InquiryCreateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/inquiry")
@RequiredArgsConstructor
public class InquiryController {
    private final InquiryCreateService inquiryCreateService;

    @PostMapping
    public ResponseEntity<InquiryResponse> createInquiry(@RequestBody InquiryRequest request) {
        return ResponseEntity.ok(inquiryCreateService.createInquiry((request)));
    }
}

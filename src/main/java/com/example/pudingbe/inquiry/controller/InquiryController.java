package com.example.pudingbe.inquiry.controller;

import com.example.pudingbe.inquiry.domain.dto.InquiryRequest;
import com.example.pudingbe.inquiry.service.InquiryCreateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/inquiry")
@RequiredArgsConstructor
public class InquiryController {
    private final InquiryCreateService inquiryCreateService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createInquiry(@RequestBody InquiryRequest request) {
        inquiryCreateService.createInquiry(request);
    }
}

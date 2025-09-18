package com.example.pudingbe.inquiry.controller;

import com.example.pudingbe.inquiry.domain.dto.InquiryResponse;
import com.example.pudingbe.inquiry.service.InquiryReadService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/inquiry")
@RequiredArgsConstructor
public class InquiryController {
    private final InquiryReadService inquiryReadService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<InquiryResponse> getAllInquiries() {
        //TODO: ADMIN 권한 체크
        return inquiryReadService.getAllInquiries();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public InquiryResponse getInquiryById(@PathVariable Long id) {
        //TODO: ADMIN, 작성자 권한 체크
        return inquiryReadService.getInquiryById(id);
    }

    @GetMapping("/my/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public List<InquiryResponse> getMyInquiries(@PathVariable Long userId) {
        //TODO: 작성자 권한 체크
        return inquiryReadService.getMyInquiries(userId);
    }
}

package com.example.puddingbe.domain.inquiry.controller;

import com.example.puddingbe.domain.inquiry.domain.dto.InquiryReplyRequest;
import com.example.puddingbe.domain.inquiry.domain.dto.InquiryResponse;
import com.example.puddingbe.domain.inquiry.service.InquiryReadService;
import com.example.puddingbe.domain.inquiry.service.InquiryUpdateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.example.puddingbe.domain.inquiry.service.InquiryDeleteService;
import com.example.puddingbe.domain.inquiry.domain.dto.InquiryRequest;
import com.example.puddingbe.domain.inquiry.service.InquiryCreateService;


@RestController
@RequestMapping("/inquiry")
@RequiredArgsConstructor
public class InquiryController {
    private final InquiryReadService inquiryReadService;
    private final InquiryDeleteService inquiryDeleteService;
    private final InquiryCreateService inquiryCreateService;
    private final InquiryUpdateService inquiryUpdateService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<InquiryResponse> getAllInquiries() {
        return inquiryReadService.getAllInquiries();
    }

    @GetMapping("/{inquiry-id}")
    @ResponseStatus(HttpStatus.OK)
    public InquiryResponse getInquiryById(@PathVariable("inquiry-id") Long id) {
        return inquiryReadService.getInquiryById(id);
    }

    @GetMapping("/my/{user-id}")
    @ResponseStatus(HttpStatus.OK)
    public List<InquiryResponse> getMyInquiries() {
        return inquiryReadService.getMyInquiries();
    }

    @PostMapping("/{inquiry-id}/reply")
    @ResponseStatus(HttpStatus.CREATED)
    public void replyToInquiry(@PathVariable("inquiry-id") Long id, @RequestBody InquiryReplyRequest request) {
        inquiryUpdateService.replyToInquiry(id, request);
    }

    @DeleteMapping("/{inquiry-id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteInquiry(@PathVariable("inquiry-id") Long id) {
        inquiryDeleteService.deleteInquiry(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createInquiry(@RequestBody InquiryRequest request) {
        inquiryCreateService.createInquiry(request);
    }
}

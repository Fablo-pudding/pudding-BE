package com.example.puddingbe.domain.inquiry.presentation;

import com.example.puddingbe.domain.inquiry.presentation.dto.request.InquiryReplyRequest;
import com.example.puddingbe.domain.inquiry.presentation.dto.request.InquiryRequest;
import com.example.puddingbe.domain.inquiry.presentation.dto.response.InquiryCreateResponse;
import com.example.puddingbe.domain.inquiry.presentation.dto.response.InquiryResponse;
import com.example.puddingbe.domain.inquiry.service.InquiryReadService;
import com.example.puddingbe.domain.inquiry.service.InquiryUpdateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.example.puddingbe.domain.inquiry.service.InquiryDeleteService;
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

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public InquiryResponse getInquiryById(@PathVariable("id") Long id) {
        return inquiryReadService.getInquiryById(id);
    }

    @GetMapping("/my")
    @ResponseStatus(HttpStatus.OK)
    public List<InquiryResponse> getMyInquiries() {
        return inquiryReadService.getMyInquiries();
    }

    @PostMapping("/{id}/reply")
    @ResponseStatus(HttpStatus.CREATED)
    public void replyToInquiry(@PathVariable("id") Long id, @RequestBody InquiryReplyRequest request) {
        inquiryUpdateService.replyToInquiry(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteInquiry(@PathVariable("id") Long id) {
        inquiryDeleteService.deleteInquiry(id);
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public InquiryCreateResponse createInquiry(@RequestBody InquiryRequest request) {
        inquiryCreateService.createInquiry(request);
        return inquiryCreateService.createInquiry(request);
    }
}

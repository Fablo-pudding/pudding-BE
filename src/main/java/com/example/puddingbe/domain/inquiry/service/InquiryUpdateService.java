package com.example.puddingbe.domain.inquiry.service;

import com.example.puddingbe.domain.inquiry.domain.Inquiry;
import com.example.puddingbe.domain.inquiry.domain.repository.InquiryRepository;
import com.example.puddingbe.domain.inquiry.exception.InquiryNotFoundException;
import com.example.puddingbe.domain.inquiry.presentation.dto.request.InquiryReplyRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class InquiryUpdateService {
    private final InquiryRepository inquiryRepository;

    public void replyToInquiry(Long id, InquiryReplyRequest request) {
        Inquiry inquiry = inquiryRepository.findById(id)
                .orElseThrow(()->new InquiryNotFoundException(id));
        inquiry.replyToInquiry(request.getReply());
        inquiryRepository.save(inquiry);
    }
}
package com.example.puddingbe.domain.inquiry.service;

import com.example.puddingbe.domain.inquiry.domain.dto.InquiryReplyRequest;
import com.example.puddingbe.domain.inquiry.repository.InquiryRepository;
import com.example.puddingbe.global.exception.InquiryNotFoundException;
import com.example.puddingbe.domain.inquiry.domain.entity.Inquiry;
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
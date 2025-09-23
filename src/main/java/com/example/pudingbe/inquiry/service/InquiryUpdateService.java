package com.example.pudingbe.inquiry.service;

import com.example.pudingbe.exception.InquiryNotFoundException;
import com.example.pudingbe.inquiry.domain.dto.InquiryReplyRequest;
import com.example.pudingbe.inquiry.domain.entity.Inquiry;
import com.example.pudingbe.inquiry.repository.InquiryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class InquiryUpdateService {
    private final InquiryRepository inquiryRepository;

    public void replyToInquiry(Long id, InquiryReplyRequest request, boolean isAdmin) {
        Inquiry inquiry = inquiryRepository.findById(id)
                .orElseThrow(()->new InquiryNotFoundException(id));
        //TODO: admin 권한 체크
        inquiry.replyToInquiry(request.getReply());
        inquiryRepository.save(inquiry);
    }
}
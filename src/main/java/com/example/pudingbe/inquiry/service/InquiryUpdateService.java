package com.example.pudingbe.inquiry.service;

import com.example.pudingbe.exception.InquiryNotFoundException;
import com.example.pudingbe.inquiry.domain.mapper.InquiryMapper;
import com.example.pudingbe.inquiry.domain.dto.InquiryReplyRequest;
import com.example.pudingbe.inquiry.domain.dto.InquiryResponse;
import com.example.pudingbe.inquiry.domain.entity.Inquiry;
import com.example.pudingbe.inquiry.repository.InquiryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class InquiryUpdateService {
    private final InquiryRepository inquiryRepository;
    private final InquiryMapper inquiryMapper;

    public InquiryResponse replyToInquiry(Long id, InquiryReplyRequest request, boolean isAdmin) {
        Inquiry inquiry = inquiryRepository.findById(id)
                .orElseThrow(()->new InquiryNotFoundException(id));
        inquiry.replyToInquiry(request.getReply());
        Inquiry saved = inquiryRepository.save(inquiry);
        return inquiryMapper.toResponse(saved);
    }
}

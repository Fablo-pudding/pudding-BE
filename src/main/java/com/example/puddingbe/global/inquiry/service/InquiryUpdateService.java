package com.example.puddingbe.global.inquiry.service;

import com.example.puddingbe.global.exception.InquiryNotFoundException;
import com.example.puddingbe.global.inquiry.domain.dto.InquiryReplyRequest;
import com.example.puddingbe.global.inquiry.domain.mapper.InquiryMapper;
import com.example.puddingbe.global.inquiry.domain.dto.InquiryResponse;
import com.example.puddingbe.global.inquiry.domain.entity.Inquiry;
import com.example.puddingbe.global.inquiry.repository.InquiryRepository;
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

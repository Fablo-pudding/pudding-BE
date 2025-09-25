package com.example.puddingbe.global.inquiry.service;

import com.example.puddingbe.global.inquiry.domain.dto.InquiryRequest;
import com.example.puddingbe.global.inquiry.domain.entity.Inquiry;
import com.example.puddingbe.global.inquiry.domain.mapper.InquiryMapper;
import com.example.puddingbe.global.inquiry.repository.InquiryRepository;
import com.example.puddingbe.global.inquiry.domain.dto.InquiryResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class InquiryCreateService {
    private final InquiryRepository inquiryRepository;
    private final InquiryMapper inquiryMapper;

    public InquiryResponse createInquiry(InquiryRequest request) {
        Inquiry inquiry = Inquiry.builder()
                .userId(request.getUserId())
                .title(request.getTitle()   )
                .content(request.getContent())
                .createdAt(LocalDateTime.now())
                .build();
        Inquiry saved = inquiryRepository.save(inquiry);
        return inquiryMapper.toResponse(saved);
    }
}

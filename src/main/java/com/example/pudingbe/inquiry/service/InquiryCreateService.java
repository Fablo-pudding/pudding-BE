package com.example.pudingbe.inquiry.service;

import com.example.pudingbe.inquiry.domain.mapper.InquiryMapper;
import com.example.pudingbe.inquiry.domain.dto.InquiryRequest;
import com.example.pudingbe.inquiry.domain.dto.InquiryResponse;
import com.example.pudingbe.inquiry.domain.entity.Inquiry;
import com.example.pudingbe.inquiry.repository.InquiryRepository;
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

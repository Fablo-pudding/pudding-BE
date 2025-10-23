package com.example.puddingbe.domain.inquiry.service;

import com.example.puddingbe.domain.inquiry.domain.Inquiry;
import com.example.puddingbe.domain.inquiry.domain.repository.InquiryRepository;
import com.example.puddingbe.domain.inquiry.presentation.dto.request.InquiryRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class InquiryCreateService {
    private final InquiryRepository inquiryRepository;

    public void createInquiry(InquiryRequest request) {
        Inquiry inquiry = Inquiry.builder()
                .userId(request.getUserId())
                .title(request.getTitle())
                .content(request.getContent())
                .createdAt(LocalDateTime.now())
                .build();
        inquiryRepository.save(inquiry);
    }
}

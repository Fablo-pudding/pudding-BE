package com.example.pudingbe.inquiry.service;

import com.example.pudingbe.exception.InquiryNotFoundException;
import com.example.pudingbe.inquiry.domain.dto.InquiryResponse;
import com.example.pudingbe.inquiry.domain.entity.Inquiry;
import com.example.pudingbe.inquiry.repository.InquiryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class InquiryReadService {
    private final InquiryRepository inquiryRepository;

    public List<InquiryResponse> getAllInquiries() {
        return inquiryRepository.findAll().stream()
                .map(InquiryResponse::new)
                .collect(Collectors.toList());
    }

    public List<InquiryResponse> getMyInquiries(Long userId) {
        return inquiryRepository.findByUserId(userId).stream()
                .map(InquiryResponse::new)
                .collect(Collectors.toList());
    }

    public InquiryResponse getInquiryById(Long id) {
        Inquiry inquiry = inquiryRepository.findById(id)
                .orElseThrow(()->new InquiryNotFoundException(id));
        return new InquiryResponse(inquiry);
    }
}

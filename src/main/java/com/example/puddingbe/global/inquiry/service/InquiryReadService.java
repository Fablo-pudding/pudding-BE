package com.example.puddingbe.global.inquiry.service;

import com.example.puddingbe.global.exception.InquiryNotFoundException;
import com.example.puddingbe.global.inquiry.domain.entity.Inquiry;
import com.example.puddingbe.global.inquiry.domain.mapper.InquiryMapper;
import com.example.puddingbe.global.inquiry.domain.dto.InquiryResponse;
import com.example.puddingbe.global.inquiry.repository.InquiryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class InquiryReadService {
    private final InquiryRepository inquiryRepository;
    private final InquiryMapper inquiryMapper;

    public List<InquiryResponse> getAllInquiries() {
        return inquiryRepository.findAll().stream()
                .map(inquiryMapper::toResponse)
                .collect(Collectors.toList());
    }

    public List<InquiryResponse> getMyInquiries(Long userId) {
        return inquiryRepository.findByUserId(userId).stream()
                .map(inquiryMapper::toResponse)
                .collect(Collectors.toList());
    }

    public InquiryResponse getInquiryById(Long id) {
        Inquiry inquiry = inquiryRepository.findById(id)
                .orElseThrow(()->new InquiryNotFoundException(id));
        return inquiryMapper.toResponse(inquiry);
    }
}

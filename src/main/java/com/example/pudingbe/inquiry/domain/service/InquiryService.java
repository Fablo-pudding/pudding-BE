package com.example.pudingbe.inquiry.domain.service;

import com.example.pudingbe.inquiry.domain.dto.InquiryReplyRequest;
import com.example.pudingbe.inquiry.domain.dto.InquiryRequest;
import com.example.pudingbe.inquiry.domain.dto.InquiryResponse;
import com.example.pudingbe.inquiry.domain.entity.Inquiry;
import com.example.pudingbe.inquiry.domain.repository.InquiryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class InquiryService {
    private final InquiryRepository inquiryRepository;

    public InquiryResponse createInquiry(InquiryRequest request) {
        Inquiry inquiry = Inquiry.builder()
                .userId(request.getUserId())
                .title(request.getTitle()   )
                .content(request.getContent())
                .createdAt(LocalDateTime.now())
                .build();
        Inquiry saved = inquiryRepository.save(inquiry);
        return mapToResponse(saved);
    }

    public List<InquiryResponse> getAllInquiries() {
        return inquiryRepository.findAll().stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    public InquiryResponse getInquiryById(Long id){
        Inquiry inquiry = inquiryRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("해당 문의가 존재하지 않습니다."));
        return mapToResponse(inquiry);
    }

    public InquiryResponse replyToInquiry(Long id, InquiryReplyRequest request){
        Inquiry inquiry = inquiryRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("해당 문의가 존재하지 않습니다."));
        inquiry.replyToInquiry(request.getReply());
        Inquiry saved = inquiryRepository.save(inquiry);
        return mapToResponse(saved);
    }

    private InquiryResponse mapToResponse(Inquiry inquiry){
        return InquiryResponse.builder()
                .id(inquiry.getId())
                .userId(inquiry.getUserId())
                .title(inquiry.getTitle())
                .content(inquiry.getContent())
                .createdAt(inquiry.getCreatedAt())
                .reply(inquiry.getReply())
                .build();
    }
}

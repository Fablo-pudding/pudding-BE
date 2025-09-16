package com.example.pudingbe.inquiry.domain.mapper;

import com.example.pudingbe.inquiry.domain.dto.InquiryResponse;
import com.example.pudingbe.inquiry.domain.entity.Inquiry;
import org.springframework.stereotype.Component;

@Component
public class InquiryMapper {
    public InquiryResponse toResponse(Inquiry inquiry) {
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

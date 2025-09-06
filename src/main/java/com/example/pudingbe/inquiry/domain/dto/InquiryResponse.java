package com.example.pudingbe.inquiry.domain.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class InquiryResponse {
    private long id;
    private long userId;
    private String title;
    private String content;
    private LocalDateTime createdAt;
}

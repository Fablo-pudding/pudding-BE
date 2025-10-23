package com.example.puddingbe.domain.inquiry.presentation.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class InquiryRequest {
    private long userId;
    private String title;
    private String content;
}

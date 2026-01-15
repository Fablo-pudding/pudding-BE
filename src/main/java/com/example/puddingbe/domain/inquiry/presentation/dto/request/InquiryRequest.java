package com.example.puddingbe.domain.inquiry.presentation.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class InquiryRequest {
    private String title;
    private String content;
}

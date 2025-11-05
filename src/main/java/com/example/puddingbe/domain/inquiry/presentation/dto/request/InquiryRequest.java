package com.example.puddingbe.domain.inquiry.presentation.dto.request;

import com.example.puddingbe.domain.user.domain.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class InquiryRequest {
    private User user;
    private String title;
    private String content;
}

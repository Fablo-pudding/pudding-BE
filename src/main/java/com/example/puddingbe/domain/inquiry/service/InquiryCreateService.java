package com.example.puddingbe.domain.inquiry.service;

import com.example.puddingbe.domain.inquiry.domain.Inquiry;
import com.example.puddingbe.domain.inquiry.domain.repository.InquiryRepository;
import com.example.puddingbe.domain.inquiry.presentation.dto.request.InquiryRequest;
import com.example.puddingbe.domain.user.domain.User;
import com.example.puddingbe.domain.user.domain.repository.UserRepository;
import com.example.puddingbe.global.detail.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class InquiryCreateService {
    private final InquiryRepository inquiryRepository;
    private final UserRepository userRepository;
    private final UserFacade userFacade;


    public void createInquiry(InquiryRequest request) {
        Long userId = userFacade.getUserId();
        User user = userRepository.findById(userId)
                .orElseThrow(()->new IllegalArgumentException("유효하지 않은 사용자 정보입니다."));

        Inquiry inquiry = Inquiry.builder()
                .title(request.getTitle())
                .user(user)
                .content(request.getContent())
                .createdAt(LocalDateTime.now())
                .build();
        inquiryRepository.save(inquiry);
    }
}

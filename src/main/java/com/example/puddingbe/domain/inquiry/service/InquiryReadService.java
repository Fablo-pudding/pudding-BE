package com.example.puddingbe.domain.inquiry.service;

import com.example.puddingbe.domain.inquiry.domain.Inquiry;
import com.example.puddingbe.domain.inquiry.domain.repository.InquiryRepository;
import com.example.puddingbe.domain.inquiry.exception.InquiryNotFoundException;
import com.example.puddingbe.domain.inquiry.exception.OnlyAdminOrAuthorReadInquiryException;
import com.example.puddingbe.domain.inquiry.presentation.dto.response.InquiryResponse;
import com.example.puddingbe.domain.user.domain.User;
import com.example.puddingbe.domain.user.domain.repository.UserRepository;
import com.example.puddingbe.global.detail.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class InquiryReadService {
    private final InquiryRepository inquiryRepository;
    private final UserRepository userRepository;
    private final UserFacade userFacade;

    public List<InquiryResponse> getAllInquiries() {
        return inquiryRepository.findAll().stream()
                .map(InquiryResponse::new)
                .collect(Collectors.toList());
    }

    public List<InquiryResponse> getMyInquiries() {
        Long userId = userFacade.getUserId();
        User user = userRepository.findById(userId)
                .orElseThrow(()->new IllegalArgumentException("유효하지 않은 사용자 정보입니다."));
        return inquiryRepository.findByUser(user).stream()
                .map(InquiryResponse::new)
                .collect(Collectors.toList());
    }

    public InquiryResponse getInquiryById(Long id) {
        Inquiry inquiry = inquiryRepository.findById(id)
                .orElseThrow(()->InquiryNotFoundException.EXCEPTION);
        Long userId = userFacade.getUserId();
        boolean isAdmin = SecurityContextHolder.getContext().getAuthentication().getAuthorities()
                .stream().anyMatch(a->a.getAuthority().equals("ROLE_ADMIN"));
        if (!isAdmin && !inquiry.getUser().getId().equals(userId)) {
            throw OnlyAdminOrAuthorReadInquiryException.EXCEPTION;
        }
        return new InquiryResponse(inquiry);
    }
}

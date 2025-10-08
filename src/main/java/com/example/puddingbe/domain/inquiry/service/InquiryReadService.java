package com.example.puddingbe.domain.inquiry.service;

import com.example.puddingbe.domain.inquiry.domain.dto.InquiryResponse;
import com.example.puddingbe.domain.inquiry.domain.entity.Inquiry;
import com.example.puddingbe.domain.inquiry.repository.InquiryRepository;
import com.example.puddingbe.global.detail.UserFacade;
import com.example.puddingbe.global.exception.InquiryNotFoundException;
import com.example.puddingbe.global.exception.UnauthorizedException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class InquiryReadService {
    private final InquiryRepository inquiryRepository;
    private final UserFacade userFacade;

    public List<InquiryResponse> getAllInquiries() {
        return inquiryRepository.findAll().stream()
                .map(InquiryResponse::new)
                .collect(Collectors.toList());
    }

    public List<InquiryResponse> getMyInquiries() {
        Long userId = userFacade.getUserId();
        return inquiryRepository.findByUserId(userId).stream()
                .map(InquiryResponse::new)
                .collect(Collectors.toList());
    }

    public InquiryResponse getInquiryById(Long id) {
        Inquiry inquiry = inquiryRepository.findById(id)
                .orElseThrow(()->new InquiryNotFoundException(id));
        Long userId = userFacade.getUserId();
        boolean isAdmin = SecurityContextHolder.getContext().getAuthentication().getAuthorities()
                .stream().anyMatch(a->a.getAuthority().equals("ROLE_ADMIN"));
        if (!isAdmin && !inquiry.getUserId().equals(userId)) {
            throw new UnauthorizedException("작성자 본인 또는 관리자만 접근할 수 있습니다.");
        }
        return new InquiryResponse(inquiry);
    }
}

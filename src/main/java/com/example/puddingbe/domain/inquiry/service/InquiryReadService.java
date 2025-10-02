package com.example.puddingbe.domain.inquiry.service;

import com.example.puddingbe.domain.inquiry.domain.dto.InquiryResponse;
import com.example.puddingbe.domain.inquiry.domain.entity.Inquiry;
import com.example.puddingbe.domain.inquiry.repository.InquiryRepository;
import com.example.puddingbe.global.detail.UserDetail;
import com.example.puddingbe.global.exception.InquiryNotFoundException;
import com.example.puddingbe.global.exception.UnauthorizedException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class InquiryReadService {
    private final InquiryRepository inquiryRepository;

    public List<InquiryResponse> getAllInquiries() {
        return inquiryRepository.findAll().stream()
                .map(InquiryResponse::new)
                .collect(Collectors.toList());
    }

    public List<InquiryResponse> getMyInquiries(Long userId, UserDetail userDetail) {
        if (!userId.equals(userDetail.getId())) {
            throw new UnauthorizedException("본인이 작성한 문의만 조회할 수 있습니다.");
        }
        return inquiryRepository.findByUserId(userId).stream()
                .map(InquiryResponse::new)
                .collect(Collectors.toList());
    }

    public InquiryResponse getInquiryById(Long id, UserDetail userDetail) {
        Inquiry inquiry = inquiryRepository.findById(id)
                .orElseThrow(()->new InquiryNotFoundException(id));
        boolean isAdmin = userDetail.getAuthorities().stream()
                .anyMatch(a->a.getAuthority().equals("ROLE_ADMIN"));
        if (!isAdmin && !inquiry.getUserId().equals(userDetail.getId())) {
            throw new UnauthorizedException("작성자 본인 또는 관리자만 접근할 수 있습니다.");
        }
        return new InquiryResponse(inquiry);
    }
}

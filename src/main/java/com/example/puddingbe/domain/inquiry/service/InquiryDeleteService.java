package com.example.puddingbe.domain.inquiry.service;

import com.example.puddingbe.domain.inquiry.domain.entity.Inquiry;
import com.example.puddingbe.domain.inquiry.repository.InquiryRepository;
import com.example.puddingbe.global.detail.UserDetail;
import com.example.puddingbe.global.exception.InquiryNotFoundException;
import com.example.puddingbe.global.exception.UnauthorizedException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class InquiryDeleteService {
    private final InquiryRepository inquiryRepository;

    public void deleteInquiry(Long id, UserDetail userDetail) {
        Inquiry inquiry = inquiryRepository.findById(id)
                .orElseThrow(() -> new InquiryNotFoundException(id));
        boolean isAdmin = userDetail.getAuthorities().stream()
                        .anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN"));
        if(!isAdmin && !inquiry.getUserId().equals(userDetail.getId())) {
            throw new UnauthorizedException("작성자 본인 또는 관리자만 접근할 수 있습니다.");
        }
        inquiryRepository.deleteById(id);
    }
}

package com.example.puddingbe.domain.inquiry.service;

import com.example.puddingbe.domain.inquiry.domain.Inquiry;
import com.example.puddingbe.domain.inquiry.domain.repository.InquiryRepository;
import com.example.puddingbe.domain.inquiry.exception.InquiryNotFoundException;
import com.example.puddingbe.domain.inquiry.exception.UnauthorizedException;
import com.example.puddingbe.global.detail.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class InquiryDeleteService {
    private final InquiryRepository inquiryRepository;
    private final UserFacade userFacade;

    public void deleteInquiry(Long id) {
        Inquiry inquiry = inquiryRepository.findById(id)
                .orElseThrow(() -> new InquiryNotFoundException(id));
        Long userId = userFacade.getUserId();
        boolean isAdmin = SecurityContextHolder.getContext().getAuthentication().getAuthorities()
                .stream().anyMatch(a->a.getAuthority().equals("ROLE_ADMIN"));
        if(!isAdmin && !inquiry.getUser().equals(userId)) {
            throw new UnauthorizedException("작성자 본인 또는 관리자만 접근할 수 있습니다.");
        }
        inquiryRepository.deleteById(id);
    }
}

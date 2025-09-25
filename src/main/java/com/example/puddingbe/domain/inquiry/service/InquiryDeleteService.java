package com.example.puddingbe.domain.inquiry.service;

import com.example.puddingbe.domain.inquiry.domain.entity.Inquiry;
import com.example.puddingbe.domain.inquiry.repository.InquiryRepository;
import com.example.puddingbe.global.exception.InquiryNotFoundException;
import com.example.puddingbe.global.exception.UnauthorizedException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class InquiryDeleteService {
    private final InquiryRepository inquiryRepository;

    public void deleteInquiry(Long id, Long currentUserId, boolean isAdmin) {
        Inquiry inquiry = inquiryRepository.findById(id)
                .orElseThrow(() -> new InquiryNotFoundException(id));

        if(!isAdmin && !inquiry.getUserId().equals(currentUserId)) {
            throw new UnauthorizedException("본인 문의만 삭제할 수 있습니다.");
        }
        inquiryRepository.deleteById(id);
    }
}

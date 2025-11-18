package com.example.puddingbe.domain.inquiry.service;

import com.example.puddingbe.domain.inquiry.domain.Inquiry;
import com.example.puddingbe.domain.inquiry.domain.repository.InquiryRepository;
import com.example.puddingbe.domain.inquiry.exception.InquiryNotFoundException;
import com.example.puddingbe.domain.inquiry.exception.OnlyAdminUpdateInquiryException;
import com.example.puddingbe.domain.inquiry.presentation.dto.request.InquiryReplyRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class InquiryUpdateService {
    private final InquiryRepository inquiryRepository;

    public void replyToInquiry(Long id, InquiryReplyRequest request) {
        Inquiry inquiry = inquiryRepository.findById(id)
                .orElseThrow(()-> InquiryNotFoundException.EXCEPTION);
        if (!(SecurityContextHolder.getContext().getAuthentication().getAuthorities()
                .stream().anyMatch(a->a.getAuthority().equals("ROLE_ADMIN")))){
            throw OnlyAdminUpdateInquiryException.EXCEPTION;
        }
        inquiry.replyToInquiry(request.getReply());
        inquiryRepository.save(inquiry);
    }
}
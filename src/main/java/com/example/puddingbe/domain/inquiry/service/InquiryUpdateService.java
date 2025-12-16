package com.example.puddingbe.domain.inquiry.service;

import com.example.puddingbe.domain.inquiry.domain.Inquiry;
import com.example.puddingbe.domain.inquiry.domain.repository.InquiryRepository;
import com.example.puddingbe.domain.inquiry.exception.InquiryNotFoundException;
import com.example.puddingbe.domain.inquiry.exception.OnlyAdminUpdateInquiryException;
import com.example.puddingbe.domain.inquiry.presentation.dto.request.InquiryReplyRequest;
import com.example.puddingbe.global.detail.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class InquiryUpdateService {
    private final InquiryRepository inquiryRepository;
    private final UserFacade userFacade;

    public void replyToInquiry(Long id, InquiryReplyRequest request) {
        Inquiry inquiry = inquiryRepository.findById(id)
                .orElseThrow(()-> InquiryNotFoundException.EXCEPTION);
        boolean isAdmin = userFacade.isAdmin();
        if (!isAdmin){
            throw OnlyAdminUpdateInquiryException.EXCEPTION;
        }
        inquiry.replyToInquiry(request.getReply());
        inquiryRepository.save(inquiry);
    }
}
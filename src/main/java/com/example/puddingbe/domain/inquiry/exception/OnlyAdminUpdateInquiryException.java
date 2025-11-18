package com.example.puddingbe.domain.inquiry.exception;

import com.example.puddingbe.global.error.exception.ErrorCode;
import com.example.puddingbe.global.error.exception.PuddingException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class OnlyAdminUpdateInquiryException extends PuddingException {
    public static final OnlyAdminUpdateInquiryException EXCEPTION = new OnlyAdminUpdateInquiryException();
    public OnlyAdminUpdateInquiryException() {
        super(ErrorCode.Only_Admin_Update_Inquiry_Exception);
    }
}

package com.example.puddingbe.domain.inquiry.exception;

import com.example.puddingbe.global.error.exception.ErrorCode;
import com.example.puddingbe.global.error.exception.PuddingException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class OnlyAdminReadInquiryException extends PuddingException {
    public static final OnlyAdminReadInquiryException EXCEPTION = new OnlyAdminReadInquiryException();
    public OnlyAdminReadInquiryException() {
        super(ErrorCode.Only_Admin_Read_Inquiry_Exception);
    }
}

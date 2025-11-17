package com.example.puddingbe.domain.inquiry.exception;

import com.example.puddingbe.global.error.exception.ErrorCode;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class OnlyAdminOrAuthorReadInquiryException extends RuntimeException {
    public static final OnlyAdminOrAuthorReadInquiryException EXCEPTION = new OnlyAdminOrAuthorReadInquiryException();
    public OnlyAdminOrAuthorReadInquiryException() {
        super(ErrorCode.Only_Admin_Or_Author_Read_Inquiry_Exception.getMessage());
    }
}

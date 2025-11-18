package com.example.puddingbe.domain.inquiry.exception;

import com.example.puddingbe.global.error.exception.ErrorCode;
import com.example.puddingbe.global.error.exception.PuddingException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class OnlyAdminOrAuthorDeleteInquiryException extends PuddingException {
    public static final OnlyAdminOrAuthorDeleteInquiryException EXCEPTION = new OnlyAdminOrAuthorDeleteInquiryException();
    public OnlyAdminOrAuthorDeleteInquiryException() {
        super(ErrorCode.Only_Admin_Or_Author_Delete_Inquiry_Exception);
    }
}

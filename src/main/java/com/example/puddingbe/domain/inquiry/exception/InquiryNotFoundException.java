package com.example.puddingbe.domain.inquiry.exception;
import com.example.puddingbe.global.error.exception.ErrorCode;
import com.example.puddingbe.global.error.exception.PuddingException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class InquiryNotFoundException extends PuddingException {
    public static final InquiryNotFoundException EXCEPTION = new InquiryNotFoundException();
    public InquiryNotFoundException() {
        super(ErrorCode.Inquiry_Not_Found_Exception);
    }
}

package com.example.puddingbe.domain.inquiry.exception;
import com.example.puddingbe.global.error.exception.ErrorCode;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class InquiryNotFoundException extends RuntimeException {
    public static final InquiryNotFoundException EXCEPTION = new InquiryNotFoundException();
    public InquiryNotFoundException() {
        super(ErrorCode.Ingredient_Not_Found_Exception.getMessage());
    }
}

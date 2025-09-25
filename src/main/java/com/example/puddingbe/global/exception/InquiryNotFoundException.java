package com.example.puddingbe.global.exception;

public class InquiryNotFoundException extends RuntimeException {
    public InquiryNotFoundException(Long id) {
        super("문의가 존재하지 않습니다.");
    }
}

package com.example.puddingbe.domain.refrigerator.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class PuddingNotFoundException extends RuntimeException {
    public PuddingNotFoundException(Long userId) {
        super("사용자의 푸딩을 찾을수없습니다");
    }
}

package com.example.puddingbe.domain.refrigerator.exception;

public class PuddingNotFoundException extends RuntimeException {
    public PuddingNotFoundException(Long userId) {
        super("사용자의 푸딩을 찾을수없습니다");
    }
}

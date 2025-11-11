package com.example.puddingbe.domain.refrigerator.exception;

public class LessPuddingTwo extends RuntimeException {
    public LessPuddingTwo() {
        super("2성 푸딩 갯수가 부족합니다");
    }
}

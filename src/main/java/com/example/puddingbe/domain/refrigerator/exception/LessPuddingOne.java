package com.example.puddingbe.domain.refrigerator.exception;

public class LessPuddingOne extends RuntimeException {
    public LessPuddingOne() {
        super("1성 푸딩 갯수가 부족합니다");
    }
}

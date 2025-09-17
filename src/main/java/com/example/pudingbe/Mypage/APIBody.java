package com.example.pudingbe.Mypage;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class APIBody<T> {
    private int status;
    private String message;
    private T data;

    public static <T> APIBody<T> of(int status, String message, T data) {
        return new APIBody<>(status, message, data);
    }
}
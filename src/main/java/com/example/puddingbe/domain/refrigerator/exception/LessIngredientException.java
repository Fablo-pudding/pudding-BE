package com.example.puddingbe.domain.refrigerator.exception;

import com.example.puddingbe.domain.user.domain.User;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class LessIngredientException extends RuntimeException {
    public LessIngredientException(User userId) {
        super("재료가 부족합니다. (필요: 우유 1, 달걀 2, 설탕 2");
    }
}

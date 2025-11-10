package com.example.puddingbe.domain.refrigerator.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class IngredientNotFoundException extends RuntimeException {
    public IngredientNotFoundException(Long userId) {
        super("재료를 찾을수없습니다");
    }
}

package com.example.puddingbe.domain.refrigerator.exception;

public class IngredientNotFoundException extends RuntimeException {
    public IngredientNotFoundException(Long userId) {
        super("재료를 찾을수없습니다");
    }
}

package com.example.puddingbe.domain.refrigerator.exception;

import com.example.puddingbe.domain.user.domain.User;
import com.example.puddingbe.global.error.exception.ErrorCode;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class LessIngredientException extends RuntimeException {
public static final LessIngredientException EXCEPTION = new LessIngredientException();
public LessIngredientException() {
    super(ErrorCode.Ingredient_Less_Exception.getMessage());
}
}

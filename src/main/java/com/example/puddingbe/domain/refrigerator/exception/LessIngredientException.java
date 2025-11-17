package com.example.puddingbe.domain.refrigerator.exception;

import com.example.puddingbe.global.error.exception.ErrorCode;
import com.example.puddingbe.global.error.exception.PuddingException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class LessIngredientException extends PuddingException {
    public static final LessIngredientException EXCEPTION = new LessIngredientException();
public LessIngredientException() {
    super(ErrorCode.Ingredient_Less_Exception);
}
}

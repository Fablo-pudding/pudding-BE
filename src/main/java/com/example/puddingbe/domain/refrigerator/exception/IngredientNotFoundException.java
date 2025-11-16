package com.example.puddingbe.domain.refrigerator.exception;

import com.example.puddingbe.global.error.exception.ErrorCode;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class IngredientNotFoundException extends RuntimeException {
    public static final IngredientNotFoundException EXCEPTION = new IngredientNotFoundException();

    private IngredientNotFoundException() {
        super(ErrorCode.Ingredient_Not_Found_Exception.getMessage());
    }
}

package com.example.puddingbe.global.error;

import com.example.puddingbe.global.error.exception.ErrorCode;
import com.example.puddingbe.global.error.exception.PuddingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    //비즈니스 로직에러
    @ExceptionHandler(PuddingException.class)
    public ResponseEntity<ErrorResponse> handleClimExceptions(PuddingException e) {

        ErrorCode errorCode = e.getErrorCode();
        ErrorResponse response = ErrorResponse.of(errorCode, e.getMessage());
        e.printStackTrace();

        return new ResponseEntity<>(response, HttpStatus.valueOf(errorCode.getStatus()));

    }
}

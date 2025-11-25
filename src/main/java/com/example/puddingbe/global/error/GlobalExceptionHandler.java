package com.example.puddingbe.global.error;

import com.example.puddingbe.domain.user.presentation.dto.request.SignUpRequest;
import com.example.puddingbe.global.error.exception.ErrorCode;
import com.example.puddingbe.global.error.exception.PuddingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
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

    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ResponseEntity<ErrorResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex){
        ErrorResponse SignUpBadRequestException = new ErrorResponse(ex.getBindingResult().getAllErrors().get(0).getDefaultMessage(), HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity<>(SignUpBadRequestException, HttpStatus.BAD_REQUEST);
    }
}

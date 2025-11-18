package com.example.puddingbe.domain.refrigerator.exception;

import com.example.puddingbe.global.error.exception.ErrorCode;
import com.example.puddingbe.global.error.exception.PuddingException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class PuddingNotFoundException extends PuddingException {
    public static final PuddingNotFoundException EXCEPTION = new PuddingNotFoundException();
    public PuddingNotFoundException() {
        super(ErrorCode.Pudding_Not_Found_Exception);
    }
}

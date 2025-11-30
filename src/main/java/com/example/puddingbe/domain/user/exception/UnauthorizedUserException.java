package com.example.puddingbe.domain.user.exception;

import com.example.puddingbe.global.error.exception.ErrorCode;
import com.example.puddingbe.global.error.exception.PuddingException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNAUTHORIZED)
public class UnauthorizedUserException extends PuddingException {
    public static final UnauthorizedUserException EXCEPTION = new UnauthorizedUserException();

    private UnauthorizedUserException() {
        super(ErrorCode.Unauthorized_User_Exception);
    }
}

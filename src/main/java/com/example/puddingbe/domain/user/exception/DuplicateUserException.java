package com.example.puddingbe.domain.user.exception;

import com.example.puddingbe.global.error.exception.ErrorCode;
import com.example.puddingbe.global.error.exception.PuddingException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class DuplicateUserException extends PuddingException {
    public static final DuplicateUserException Exception = new DuplicateUserException();

    private DuplicateUserException() {
        super(ErrorCode.Duplicate_User_Exception);
    }
}

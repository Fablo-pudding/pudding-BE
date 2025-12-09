package com.example.puddingbe.domain.awss3.exception;

import com.example.puddingbe.global.error.exception.ErrorCode;
import com.example.puddingbe.global.error.exception.PuddingException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFound extends PuddingException {

    public static final UserNotFound EXCEPTION = new UserNotFound();

    public UserNotFound() {
        super(ErrorCode.User_Not_Found);
    }
}

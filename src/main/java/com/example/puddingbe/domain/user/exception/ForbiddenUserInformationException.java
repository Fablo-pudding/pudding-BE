package com.example.puddingbe.domain.user.exception;

import com.example.puddingbe.global.error.exception.ErrorCode;
import com.example.puddingbe.global.error.exception.PuddingException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.FORBIDDEN)
public class ForbiddenUserInformationException extends PuddingException {
    public static final ForbiddenUserInformationException EXCEPTION = new ForbiddenUserInformationException();

    private ForbiddenUserInformationException() {
        super(ErrorCode.Forbidden_User_Information_Exception);
    }
}

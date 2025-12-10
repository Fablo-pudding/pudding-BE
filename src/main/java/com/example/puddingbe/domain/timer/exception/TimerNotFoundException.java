package com.example.puddingbe.domain.timer.exception;

import com.example.puddingbe.global.error.exception.ErrorCode;
import com.example.puddingbe.global.error.exception.PuddingException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class TimerNotFoundException extends PuddingException {
    public static final TimerNotFoundException EXCEPTION = new TimerNotFoundException();

    public TimerNotFoundException() {
        super(ErrorCode.Timer_Not_Found_Exception);
    }
}

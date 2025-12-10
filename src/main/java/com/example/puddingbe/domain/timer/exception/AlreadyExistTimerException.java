package com.example.puddingbe.domain.timer.exception;

import com.example.puddingbe.global.error.exception.ErrorCode;
import com.example.puddingbe.global.error.exception.PuddingException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class AlreadyExistTimerException extends PuddingException {
    public static final AlreadyExistTimerException EXCEPTION = new AlreadyExistTimerException();

    private AlreadyExistTimerException() {
        super(ErrorCode.Already_Exist_Timer_Exception);
    }
}

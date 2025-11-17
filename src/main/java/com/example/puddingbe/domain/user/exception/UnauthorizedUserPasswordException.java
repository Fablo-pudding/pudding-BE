package com.example.puddingbe.domain.user.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNAUTHORIZED)
public class UnauthorizedUserPasswordException extends RuntimeException {
    public UnauthorizedUserPasswordException() {
        super("비밀번호가 일치하지 않습니다");
    }
}

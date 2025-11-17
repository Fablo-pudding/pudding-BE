package com.example.puddingbe.domain.user.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNAUTHORIZED)
public class UnauthorizedUserNameException extends RuntimeException {
    public UnauthorizedUserNameException() {
        super("찾을 수 없는 사용자입니다");
    }
}

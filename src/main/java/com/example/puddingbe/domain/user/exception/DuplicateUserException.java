package com.example.puddingbe.domain.user.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class DuplicateUserException extends RuntimeException {
    public DuplicateUserException() {
        super("중복된 사용자 이름입니다");
    }
}

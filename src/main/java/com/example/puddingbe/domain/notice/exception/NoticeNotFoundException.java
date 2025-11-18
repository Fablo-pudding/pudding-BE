package com.example.puddingbe.domain.notice.exception;

import com.example.puddingbe.global.error.exception.ErrorCode;
import com.example.puddingbe.global.error.exception.PuddingException;

public class NoticeNotFoundException extends PuddingException {
    public static final NoticeNotFoundException EXCEPTION = new NoticeNotFoundException();
    private NoticeNotFoundException() {
        super(ErrorCode.Notice_Not_Found_Exception);
    }
}

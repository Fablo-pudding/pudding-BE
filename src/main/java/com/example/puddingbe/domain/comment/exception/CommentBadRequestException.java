package com.example.puddingbe.domain.comment.exception;

import com.example.puddingbe.global.error.exception.ErrorCode;
import com.example.puddingbe.global.error.exception.PuddingException;

public class CommentBadRequestException extends PuddingException {
    public static final CommentBadRequestException EXCEPTION = new CommentBadRequestException();
    private CommentBadRequestException() {
        super(ErrorCode.Comment_Bad_Request_Exception);
    }
}

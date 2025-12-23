package com.example.puddingbe.domain.comment.exception;

import com.example.puddingbe.global.error.exception.ErrorCode;
import com.example.puddingbe.global.error.exception.PuddingException;

public class CommentNotFoundException extends PuddingException {
    public static final CommentNotFoundException EXCEPTION = new CommentNotFoundException();
    private CommentNotFoundException() {
        super(ErrorCode.Comment_Not_Found_Exception);
    }
}

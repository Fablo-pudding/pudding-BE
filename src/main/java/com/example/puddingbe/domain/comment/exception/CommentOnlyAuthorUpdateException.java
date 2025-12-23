package com.example.puddingbe.domain.comment.exception;

import com.example.puddingbe.global.error.exception.ErrorCode;
import com.example.puddingbe.global.error.exception.PuddingException;

public class CommentOnlyAuthorUpdateException extends PuddingException {
    public static final CommentOnlyAuthorUpdateException EXCEPTION = new CommentOnlyAuthorUpdateException();
    private CommentOnlyAuthorUpdateException() {
        super(ErrorCode.Only_Author_Update_Comment_Exception);
    }
}

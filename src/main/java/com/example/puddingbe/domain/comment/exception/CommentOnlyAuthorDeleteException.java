package com.example.puddingbe.domain.comment.exception;

import com.example.puddingbe.global.error.exception.ErrorCode;
import com.example.puddingbe.global.error.exception.PuddingException;

public class CommentOnlyAuthorDeleteException extends PuddingException {
    public static final CommentOnlyAuthorDeleteException EXCEPTION = new CommentOnlyAuthorDeleteException();
    private CommentOnlyAuthorDeleteException() {
        super(ErrorCode.Only_Author_Delete_Comment_Exception);
    }
}

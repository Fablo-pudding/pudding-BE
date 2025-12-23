package com.example.puddingbe.domain.feed.exception;

import com.example.puddingbe.global.error.exception.ErrorCode;
import com.example.puddingbe.global.error.exception.PuddingException;

public class PostOnlyAuthorUpdateException extends PuddingException {
    public static final PostOnlyAuthorUpdateException EXCPETION = new PostOnlyAuthorUpdateException();
    private PostOnlyAuthorUpdateException() {
        super(ErrorCode.Only_Author_Update_Post_Exception);
    }
}

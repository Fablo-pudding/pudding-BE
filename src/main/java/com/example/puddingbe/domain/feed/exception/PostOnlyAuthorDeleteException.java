package com.example.puddingbe.domain.feed.exception;

import com.example.puddingbe.global.error.exception.ErrorCode;
import com.example.puddingbe.global.error.exception.PuddingException;

public class PostOnlyAuthorDeleteException extends PuddingException {
    public static final PostOnlyAuthorDeleteException EXCPETION = new PostOnlyAuthorDeleteException();
    private PostOnlyAuthorDeleteException() {
        super(ErrorCode.Only_Author_Delete_Post_Exception);
    }
}

package com.example.puddingbe.domain.feed.exception;

import com.example.puddingbe.global.error.exception.ErrorCode;
import com.example.puddingbe.global.error.exception.PuddingException;

public class PostBadRequestExcpetion extends PuddingException {
    public static final PostBadRequestExcpetion EXCPETION = new PostBadRequestExcpetion();
    private PostBadRequestExcpetion() {
        super(ErrorCode.Post_Bad_Request_Exception);
    }
}

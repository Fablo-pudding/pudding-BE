package com.example.puddingbe.domain.feed.exception;

import com.example.puddingbe.global.error.exception.ErrorCode;
import com.example.puddingbe.global.error.exception.PuddingException;

public class PostNotFoundExcpetion extends PuddingException {
    public static final PostNotFoundExcpetion EXCPETION = new PostNotFoundExcpetion();
    private PostNotFoundExcpetion() {
        super(ErrorCode.Post_Not_Found_Exception);
    }
}

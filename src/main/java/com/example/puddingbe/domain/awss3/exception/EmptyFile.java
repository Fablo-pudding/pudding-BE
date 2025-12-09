package com.example.puddingbe.domain.awss3.exception;

import com.example.puddingbe.global.error.exception.ErrorCode;
import com.example.puddingbe.global.error.exception.PuddingException;

public class EmptyFile extends PuddingException {
    public static final EmptyFile EXCEPTION = new EmptyFile();
    public EmptyFile() {
        super(ErrorCode.Empty_File);
    }
}

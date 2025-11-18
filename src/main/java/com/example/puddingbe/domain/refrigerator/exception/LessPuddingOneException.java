package com.example.puddingbe.domain.refrigerator.exception;

import com.example.puddingbe.global.error.exception.ErrorCode;
import com.example.puddingbe.global.error.exception.PuddingException;

public class LessPuddingOneException extends PuddingException {
    public static final LessPuddingOneException EXCEPTION = new LessPuddingOneException();
    public LessPuddingOneException() {
        super(ErrorCode.Less_Pudding_One_Exception);
    }
}

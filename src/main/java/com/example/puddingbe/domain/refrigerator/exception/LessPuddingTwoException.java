package com.example.puddingbe.domain.refrigerator.exception;

import com.example.puddingbe.global.error.exception.ErrorCode;
import com.example.puddingbe.global.error.exception.PuddingException;

public class LessPuddingTwoException extends PuddingException {
    public static final LessPuddingTwoException EXCEPTION= new LessPuddingTwoException();
    public LessPuddingTwoException() {
        super(ErrorCode.Less_Pudding_Two_Exception);
    }
}

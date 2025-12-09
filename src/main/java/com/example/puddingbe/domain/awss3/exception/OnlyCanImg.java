package com.example.puddingbe.domain.awss3.exception;

import com.example.puddingbe.global.error.exception.ErrorCode;
import com.example.puddingbe.global.error.exception.PuddingException;

public class OnlyCanImg extends PuddingException {
  public static final OnlyCanImg EXCEPTION = new OnlyCanImg();

  public OnlyCanImg() {
        super(ErrorCode.Only_Can_Img);
    }
}

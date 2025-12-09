package com.example.puddingbe.domain.awss3.exception;

import com.example.puddingbe.global.error.exception.ErrorCode;
import com.example.puddingbe.global.error.exception.PuddingException;

public class NullFile extends PuddingException {
  public static final NullFile EXCEPTION = new NullFile();
  public NullFile() {
        super(ErrorCode.Null_File);
    }
}

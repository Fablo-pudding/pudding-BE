package com.example.puddingbe.domain.notice.exception;
import com.example.puddingbe.global.error.exception.ErrorCode;
import com.example.puddingbe.global.error.exception.PuddingException;

public class NoticeAdminCanCreate extends PuddingException {
    public static final NoticeAdminCanCreate EXCEPTION = new NoticeAdminCanCreate();

    private NoticeAdminCanCreate() {
        super(ErrorCode.Only_Admin_Create_Notice_Exception);
    }
}

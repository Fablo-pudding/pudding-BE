package com.example.puddingbe.domain.notice.exception;

import com.example.puddingbe.global.error.exception.ErrorCode;
import com.example.puddingbe.global.error.exception.PuddingException;

public class NoticeAdminCanUpdate extends PuddingException {
    public static final NoticeAdminCanUpdate EXCEPTION = new NoticeAdminCanUpdate();
    private NoticeAdminCanUpdate() {
        super(ErrorCode.Only_Admin_Update_Notice_Exception);
    }
}

package com.example.puddingbe.domain.notice.exception;

import com.example.puddingbe.global.error.exception.ErrorCode;
import com.example.puddingbe.global.error.exception.PuddingException;

public class NoticeAdminCanDelete extends PuddingException {
    public static final NoticeAdminCanDelete EXCEPTION = new NoticeAdminCanDelete();
    private NoticeAdminCanDelete() {
        super(ErrorCode.Only_Admin_Delete_Notice_Exception);
    }
}

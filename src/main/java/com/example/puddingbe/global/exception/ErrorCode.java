package com.example.puddingbe.global.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {

//Refrigerator
    IngredientNotFoundException(404, "재료를 찾을수없습니다"),
    PuddingNotFound(404,"푸딩을 찾을수없습니다"),
    IngredientLessException(400, "재료가 부족합니다. (필요: 우유 1, 달걀 2, 설탕 2"),
    LessPuddingOne(400,"1성 푸딩 갯수가 부족합니다"),
    LessPuddingTwo(400,"2성 푸딩 갯수가 부족합니다"),

//Notice
    OnlyAdminCreateNoticeException(403,"관리자만 공지를 작성할 수 있습니다."),
    OnlyAdminDeleteNoticeException(403,"관리자만 공지를 삭제할 수 있습니다."),
    OnlyAdminUpdateNoticeException(403,"관리자만 공지를 수정할 수 있습니다"),

//user
    DuplicateUserException(409, "중복된 사용자 이름입니다"),
    UnauthorizedUserPasswordException(401, "비밀번호가 일치하지 않습니다"),
    UnauthorizedUserNameException(401, "찾을 수 없는 사용자입니다");

    private final Integer status;
    private final String message;

}

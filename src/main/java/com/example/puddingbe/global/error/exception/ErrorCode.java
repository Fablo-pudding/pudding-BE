package com.example.puddingbe.global.error.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {

//Refrigerator
    Ingredient_Not_Found_Exception(404, "재료를 찾을수없습니다"),
    Pudding_Not_Found_Exception(404,"푸딩을 찾을수없습니다"),
    Ingredient_Less_Exception(400, "재료가 부족합니다. (필요: 우유 1, 달걀 2, 설탕 2)"),
    Less_Pudding_One_Exception(400,"1성 푸딩 갯수가 부족합니다"),
    Less_Pudding_Two_Exception(400,"2성 푸딩 갯수가 부족합니다"),

//Notice
    Only_Admin_Create_Notice_Exception(403,"관리자만 공지를 작성할 수 있습니다"),
    Only_Admin_Delete_Notice_Exception(403,"관리자만 공지를 삭제할 수 있습니다"),
    Only_Admin_Update_Notice_Exception(403,"관리자만 공지를 수정할 수 있습니다");

    private final Integer status;
    private final String message;

}

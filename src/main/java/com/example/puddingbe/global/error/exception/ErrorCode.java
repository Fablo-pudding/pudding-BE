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
    Notice_Not_Found_Exception(404,"공지를 찾을수없습니다"),
    Only_Admin_Update_Notice_Exception(403,"관리자만 공지를 수정할 수 있습니다"),
    Only_Admin_Delete_Notice_Exception(403,"관리자만 공지를 삭제할 수 있습니다."),
    Only_Admin_Create_Notice_Exception(403,"관리자만 공지를 작성할 수 있습니다."),

//Inquiry
    Inquiry_Not_Found_Exception(404, "문의를 찾을 수 없습니다"),
    Only_Admin_Read_Inquiry_Exception(403, "관리자만 문의를 조회할 수 있습니다"),
    Only_Admin_Update_Inquiry_Exception(403, "관리자만 답변을 작성할 수 있습니다"),
    Only_Admin_Or_Author_Read_Inquiry_Exception(403, "작성자 본인 또는 관리자만 조회할 수 있습니다"),
    Only_Admin_Or_Author_Delete_Inquiry_Exception(403, "작성자 본인 또는 관리자만 삭제할 수 있습니다"),

//user
    Duplicate_User_Exception(409, "중복된 사용자 아이디입니다"),
    Unauthorized_User_Exception(401, "유저정보가 유효하지 않습니다"),
    Forbidden_User_Information_Exception(403, "본인의 정보만 조회 가능합니다"),

//timer
    Already_Exist_Timer_Exception(409, "타이머가 이미 생성되어있습니다"),
    Timer_Not_Found_Exception(404, "타이머가 생성되지 않았습니다"),

//S3
    Empty_File(400, "빈 파일은 업로드할수없습니다"),
    Null_File(400,"파일이 존재하지않습니다"),
    Only_Can_Img(400, "이미지형식의 파일만 게시할수있습니다"),
    User_Not_Found(404, "유저ID를 찾을수없습니다"),

//feed
    Post_Not_Found_Exception(404, "게시글을 찾을 수 없습니다"),
    Post_Bad_Request_Exception(400, "잘못된 게시글 요청입니다"),
    Only_Author_Update_Post_Exception(403, "게시글 작성자 혹은 관리자만 수정할 수 있습니다"),
    Only_Author_Delete_Post_Exception(403, "게시글 작성자 혹은 관리자만 삭제할 수 있습니다");


    private final Integer status;
    private final String message;

}

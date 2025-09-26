package com.example.puddingbe.domain.user.controller;

import com.example.puddingbe.domain.user.response.UserInfoResponse;
import com.example.puddingbe.domain.user.service.UserInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserInfoController {
private final UserInfoService userInfoService;

    @GetMapping("/info")
    @ResponseStatus(HttpStatus.OK) // 상태 코드 반환
    public UserInfoResponse showInformation(@RequestHeader("Authorization") String authorizationHeader) {
        return userInfoService.showInformation(authorizationHeader); // 조회 정보 응답
    }
}

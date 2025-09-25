package com.example.puddingbe.domain.user.Mypage;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class MyPageController {
    private final MyPageService myPageService;

    @GetMapping("/mypage")
    @ResponseStatus(HttpStatus.OK) // 상태 코드 반환
    public MyPageResponse showMyPage(@RequestHeader("Authorization") String authorizationHeader) {
        return myPageService.showMyPage(authorizationHeader); // 조회 정보 응답
    }
}

package com.example.pudingbe.Mypage;

import com.example.pudingbe.global.exception.CustomJwtException;
import com.example.pudingbe.global.jwt.JwtTokenProvider;
import com.example.pudingbe.user.domain.User;
import com.example.pudingbe.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.NoSuchElementException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class MyPageController {
    private final JwtTokenProvider jwtTokenProvider;
    private final UserRepository userRepository;

    @GetMapping("/mypage")
    public ResponseEntity<APIBody<MyPageResponse>> showMyPage(@RequestHeader("Authorization") String authorizationHeader)
    {
        try {
            if (authorizationHeader == null || !authorizationHeader.startsWith("Bearer ")) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                        .body(APIBody.of(401, "인증 토큰이 없습니다.", null));
            }

            String token = authorizationHeader.substring(7);
            jwtTokenProvider.validateToken(token); // 예외 발생 시 401

            String name = jwtTokenProvider.getNameFromToken(token);

            User findUser = userRepository.findByName(name)
                    .orElseThrow(() -> new NoSuchElementException("해당 사용자가 존재하지 않습니다."));

            MyPageResponse response = new MyPageResponse(
                    findUser.getName(),
                    "푸딩과함께 공부하자",
                    null,
                    "https://default.image.url/profile.png"
                    );

            return ResponseEntity.ok(APIBody.of(200, "마이페이지 조회 성공", response));

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(APIBody.of(500, "서버 오류", null));
        }
    }
}
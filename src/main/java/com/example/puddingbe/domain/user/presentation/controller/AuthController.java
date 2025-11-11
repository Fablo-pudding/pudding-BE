package com.example.puddingbe.domain.user.presentation.controller;


import com.example.puddingbe.domain.user.presentation.dto.request.SignUpRequest;
import com.example.puddingbe.domain.user.service.LogoutService;
import com.example.puddingbe.domain.user.service.SignupService;
import com.example.puddingbe.global.jwt.JwtToken;
import com.example.puddingbe.domain.user.presentation.dto.request.LoginRequest;
import com.example.puddingbe.domain.user.service.LoginService;
import io.jsonwebtoken.Jwt;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class AuthController {

    private final SignupService signupService;
    private final LoginService loginService;
    private final LogoutService logoutService;

    @PostMapping("/signup")
    public ResponseEntity<HttpStatus> signup(@Validated @RequestBody SignUpRequest signUpRequest) { // Valid를 추가해야 dto의 조건들 적용가능

        signupService.save(signUpRequest);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<JwtToken> login(@Validated @RequestBody LoginRequest loginRequest) {
        JwtToken jwtToken = loginService.login(loginRequest.getName(), loginRequest.getPassword());
        return ResponseEntity.ok(jwtToken); // jwt 반환
    }

    @PostMapping("/logout")
    public ResponseEntity<Void> logout(HttpServletRequest request) { // 클라이언트의 요청중에 Authorization 헤더에있는 토큰을 추출 학기 위함
        logoutService.logout(request);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

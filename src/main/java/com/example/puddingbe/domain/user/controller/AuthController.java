package com.example.puddingbe.domain.user.controller;

import com.example.puddingbe.domain.user.request.SignUpRequest;
import com.example.puddingbe.domain.user.service.SignupService;
import com.example.puddingbe.global.jwt.JwtToken;
import com.example.puddingbe.global.request.LoginRequest;
import com.example.puddingbe.global.service.LoginService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class AuthController {

    private final SignupService signupService;
    private final LoginService loginService;

    @PostMapping("/signup")
    public ResponseEntity<HttpStatus> signup(@Valid @RequestBody SignUpRequest signUpRequest) { // Valid를 추가해야 dto의 조건들 적용가능
        signupService.save(signUpRequest);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<JwtToken> login(@Valid @RequestBody LoginRequest loginRequest) {
        JwtToken jwtToken = loginService.login(loginRequest.getName(), loginRequest.getPassword());
        return ResponseEntity.ok(jwtToken); // jwt 반환
    }
}

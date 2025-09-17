package com.example.pudingbe.user.controller;

import com.example.pudingbe.global.jwt.JwtToken;
import com.example.pudingbe.global.request.LoginRequest;
import com.example.pudingbe.global.service.LoginService;
import com.example.pudingbe.user.request.SignUpRequest;
import com.example.pudingbe.user.service.SignupService;
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
    public ResponseEntity<HttpStatus> signup(@RequestBody SignUpRequest signUpRequest) {
        signupService.save(signUpRequest);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<JwtToken> login(@RequestBody LoginRequest loginRequest) {
        JwtToken jwtToken = loginService.login(loginRequest.getName(), loginRequest.getPassword());
        return ResponseEntity.ok(jwtToken);
    }
}

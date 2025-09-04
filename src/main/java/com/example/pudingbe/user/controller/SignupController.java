package com.example.pudingbe.user.controller;

import com.example.pudingbe.user.request.Request;
import com.example.pudingbe.user.service.SignupService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class SignupController {

    private final SignupService signupService;
    private final PasswordEncoder encoder; // 비밀번호 암호화

    @PostMapping("/signup")
    public ResponseEntity<HttpStatus> signup(@RequestBody Request request) {
        signupService.save(request);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}

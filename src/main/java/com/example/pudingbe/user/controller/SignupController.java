package com.example.pudingbe.user.controller;

import com.example.pudingbe.user.request.SignUpRequest;
import com.example.pudingbe.user.service.SignupService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class SignupController {

    private final SignupService signupService;

    @PostMapping("/signup")
    public ResponseEntity<HttpStatus> signup(@RequestBody SignUpRequest signUpRequest) {
        signupService.save(signUpRequest);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}

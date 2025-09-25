package com.example.pudingbe.global.jwt;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class JwtToken { // Provider 에서 발급된 토큰을 객체로 담는 DTO
    private String grantType;
    private String accessToken;
    private String refreshToken;
}

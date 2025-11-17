package com.example.puddingbe.domain.user.service;

import com.example.puddingbe.global.jwt.JwtTokenProvider;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LogoutService {

    private final JwtTokenProvider jwtTokenProvider;
    private final RedisTemplate<String, String> redisTemplate;

    @Transactional
    public void logout(HttpServletRequest request) {
        String accessToken = jwtTokenProvider.resolveToken(request); // HttpServletRequest 에서 받아온 클라이언트 정보중 토큰만 추출

        if(accessToken == null || !jwtTokenProvider.validateToken(accessToken)) { // 토큰 값이 null 이거나 JwtTokenProvider의 validateToken 메서드를 통과하지 못할 경우
            return;
        }

        String username = jwtTokenProvider.getNameFromToken(accessToken); // username 추출
        redisTemplate.delete(username); // 추출된 username을 통해 redisTemplate 에서 지원하는 delete 메서드를 사용하여 토큰 삭제.
    }
}

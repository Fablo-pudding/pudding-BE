package com.example.puddingbe.global.jwt;

import com.example.puddingbe.global.error.ErrorResponse;
import com.example.puddingbe.global.error.exception.CustomJwtException;
import com.example.puddingbe.global.error.exception.ErrorCode;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import java.io.IOException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    private final JwtTokenProvider jwtTokenProvider;

    public JwtAuthenticationFilter(JwtTokenProvider jwtTokenProvider) {
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
        throws ServletException, IOException {
        String path = request.getServletPath();
        // 회원가입, 로그인 요청은 JWT 체크 건너뛰기
        if (path.startsWith("/user/signup") || path.startsWith("/user/login")) {
            filterChain.doFilter(request, response);
            return;
        }

        try {
            String token = jwtTokenProvider.resolveToken(request); // 요청헤더에서 토큰 꺼내기
            if (token != null && jwtTokenProvider.validateToken(token)) { // 토큰 검증 (null이 아니면서 토큰 검증이 정상인경우)
                Authentication authentication = jwtTokenProvider.getAuthentication(token);

                SecurityContextHolder.getContext().setAuthentication(authentication);
            }

            filterChain.doFilter(request, response);
        } catch (CustomJwtException e) { // JwtProvider 에서 발생한 예외를 필터에서 잡아서 클라에게 전달
            response.setStatus(HttpStatus.UNAUTHORIZED.value()); // 상태코드 설정
            response.setContentType("application/json;charset=UTF-8"); // 내용 타입 설정

            ObjectMapper objectMapper = new ObjectMapper(); // 매퍼는 자바 객체를 json 으로 바꿔줌 (이 과정은 Controller 에서 처리하는게 효율)
            ErrorResponse errorResponse = new ErrorResponse(e.getMessage(), HttpStatus.UNAUTHORIZED.value()); // 응답 값
            String jsonData = objectMapper.writeValueAsString(errorResponse); // jsonData 안에 errorResponse를 json 문자열 형태로 바꾼 값을 넣어줌

            response.getWriter().write(jsonData); // 버퍼로 값을 담고
            response.getWriter().flush(); // 출력해주기
        }
    }
}

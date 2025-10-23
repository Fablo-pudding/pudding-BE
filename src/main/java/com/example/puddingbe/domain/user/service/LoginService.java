package com.example.puddingbe.domain.user.service;

import com.example.puddingbe.global.detail.UserDetail;
import com.example.puddingbe.global.jwt.JwtToken;
import com.example.puddingbe.global.jwt.JwtTokenProvider;
import com.example.puddingbe.domain.user.domain.User;
import com.example.puddingbe.domain.user.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;

    public JwtToken login(String name, String password) {
        User user = userRepository.findByName(name)
                .orElseThrow(() -> new RuntimeException("찾을 수 없는 사용자입니다." + name));

        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new RuntimeException("비밀번호가 일치하지 않습니다.");
        }

        UserDetail userDetail = new UserDetail(user);
        Authentication authentication =
                new UsernamePasswordAuthenticationToken(userDetail, password, userDetail.getAuthorities());

        return jwtTokenProvider.generateToken(authentication); // 토큰 반환
    }
}

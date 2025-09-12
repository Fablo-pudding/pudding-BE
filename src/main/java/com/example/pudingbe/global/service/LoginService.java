package com.example.pudingbe.global.service;

import com.example.pudingbe.user.domain.User;
import com.example.pudingbe.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public String login(String name, String password) {
        User user = userRepository.findByName(name)
                .orElseThrow(() -> new RuntimeException("찾을 수 없는 사용자입니다." + name));

        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new RuntimeException("비밀번호가 일치하지 않습니다.");
        }

        return null; //jwt
    }
}

package com.example.pudingbe.user.service;

import com.example.pudingbe.user.request.SignUpRequest;
import com.example.pudingbe.user.domain.User;
import com.example.pudingbe.user.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SignupService {

    private final UserRepository userRepository;
    private final PasswordEncoder encoder; // 비밀번호 암호화

    @Transactional
    public void save(SignUpRequest signUpRequest) {
        User user = User.builder()
                .name(signUpRequest.getName())
                .password(encoder.encode(signUpRequest.getPassword())) // 암호화
                .birth(signUpRequest.getBirth())
                .batch(signUpRequest.getBatch())
                .gender(signUpRequest.getGender())
                .build();

        userRepository.save(user);
    }
}

package com.example.puddingbe.domain.user.service;

import com.example.puddingbe.domain.user.domain.Role;
import com.example.puddingbe.domain.user.exception.DuplicateUserException;
import com.example.puddingbe.domain.user.presentation.dto.request.SignUpRequest;
import com.example.puddingbe.domain.user.domain.User;
import com.example.puddingbe.domain.user.domain.repository.UserRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SignupService {

    private final UserRepository userRepository;
    private final PasswordEncoder encoder;

    @Transactional
    public void save(SignUpRequest signUpRequest) {

        if(userRepository.existsByName(signUpRequest.getName())) {
            throw new DuplicateUserException("중복된 사용자 이름입니다");
        }

        User user = User.builder()
                .name(signUpRequest.getName())
                .password(encoder.encode(signUpRequest.getPassword())) // 암호화
                .birth(signUpRequest.getBirth())
                .batch(signUpRequest.getBatch())
                .gender(signUpRequest.getGender())
                .role(Role.USER)
                .build();

        userRepository.save(user);
    }
}

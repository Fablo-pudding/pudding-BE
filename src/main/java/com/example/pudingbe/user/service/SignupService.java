package com.example.pudingbe.user.service;

import com.example.pudingbe.user.request.Request;
import com.example.pudingbe.user.domain.User;
import com.example.pudingbe.user.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SignupService {

    private final UserRepository userRepository;

    @Transactional
    public void save(Request request) {
        User user = User.builder()
                .name(request.getName())
                .password(request.getPassword())
                .brith(request.getBirth())
                .batch(request.getBatch())
                .gender(request.getGender())
                .build();

        userRepository.save(user);
    }
}

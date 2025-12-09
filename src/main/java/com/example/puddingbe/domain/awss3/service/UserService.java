package com.example.puddingbe.domain.awss3.service;

import com.example.puddingbe.domain.awss3.exception.UserNotFound;
import com.example.puddingbe.domain.user.domain.User;
import com.example.puddingbe.domain.user.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User updateProfileImage(Long userId, String url) {
        User user = userRepository.findById(userId)
                .orElseThrow(() ->  UserNotFound.EXCEPTION);

        user.updateProfileImage(url);

        return userRepository.save(user);
    }
}

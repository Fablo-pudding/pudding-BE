package com.example.puddingbe.global.detail;

import com.example.puddingbe.domain.user.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

@Component
@RequiredArgsConstructor
public class UserFacade {
    private final UserRepository userRepository;

    public Long getUserId() {
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        return userRepository.findByName(name).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)).getId();
    }
}

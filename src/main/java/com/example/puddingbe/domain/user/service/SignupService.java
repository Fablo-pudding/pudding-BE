package com.example.puddingbe.domain.user.service;

import com.example.puddingbe.domain.refrigerator.domain.entity.Ingredient;
import com.example.puddingbe.domain.refrigerator.domain.entity.Pudding;
import com.example.puddingbe.domain.refrigerator.domain.repository.IngredientRepository;
import com.example.puddingbe.domain.refrigerator.domain.repository.PuddingRepository;
import com.example.puddingbe.domain.user.domain.Role;
import com.example.puddingbe.domain.user.exception.DuplicateUserException;
import com.example.puddingbe.domain.user.presentation.dto.request.LoginRequest;
import com.example.puddingbe.domain.user.presentation.dto.request.SignUpRequest;
import com.example.puddingbe.domain.user.domain.User;
import com.example.puddingbe.domain.user.domain.repository.UserRepository;

import jakarta.transaction.Transactional;
import jakarta.validation.constraints.Pattern;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SignupService {

    private final UserRepository userRepository;
    private final PasswordEncoder encoder;
    private final IngredientRepository ingredientRepository;
    private final PuddingRepository puddingRepository;

    @Transactional
    public void save(SignUpRequest signUpRequest) {

        if (userRepository.existsByName(signUpRequest.getName())) {
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

        Ingredient ingredient = Ingredient.builder()
                .user(user)
                .build();
        ingredientRepository.save(ingredient);

        Pudding pudding = Pudding.builder()
                .user(user)
                .build();
        puddingRepository.save(pudding);
    }
}

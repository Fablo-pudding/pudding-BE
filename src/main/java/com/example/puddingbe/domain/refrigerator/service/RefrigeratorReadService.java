package com.example.puddingbe.domain.refrigerator.service;

import com.example.puddingbe.domain.refrigerator.domain.entity.Ingredient;
import com.example.puddingbe.domain.refrigerator.domain.entity.Pudding;
import com.example.puddingbe.domain.refrigerator.domain.entity.repository.PuddingRepository;
import com.example.puddingbe.domain.refrigerator.presentation.dto.RefrigeratorResponse;
import com.example.puddingbe.domain.refrigerator.domain.entity.repository.IngredientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RefrigeratorReadService {
    private final IngredientRepository ingredientRepository;
    private final PuddingRepository puddingRepository;

    public RefrigeratorResponse getRefrigerator(Long userId) {

        Ingredient ingredient = ingredientRepository.findByUserId(userId)
                .stream().findFirst()
                .orElseThrow(() -> new IllegalArgumentException("해당 유저의 재료를 찾을 수 없습니다."));

        Pudding pudding = puddingRepository.findByUserId(userId)
                .stream().findFirst()
                .orElseThrow(() -> new IllegalArgumentException("해당 유저의 푸딩 정보를 찾을 수 없습니다."));

        return new RefrigeratorResponse(ingredient.getSugar(), ingredient.getMilk(), ingredient.getEgg(), pudding.getPuddingCount());
    }
}

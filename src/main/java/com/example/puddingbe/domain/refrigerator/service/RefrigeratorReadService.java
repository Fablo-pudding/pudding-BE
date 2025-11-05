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

        Ingredient ingredient = ingredientRepository.findByUserId(userId);
            Pudding pudding = puddingRepository.findByUserId(userId);
            return RefrigeratorResponse.builder()
                    .milk(ingredient.getMilk())
                    .sugar(ingredient.getSugar())
                    .egg(ingredient.getEgg())
                    .puddingCount(pudding.getPuddingCount())
                    .build();
    }
}

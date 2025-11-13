package com.example.puddingbe.domain.refrigerator.service;

import com.example.puddingbe.domain.refrigerator.domain.entity.Ingredient;
import com.example.puddingbe.domain.refrigerator.domain.entity.Pudding;
import com.example.puddingbe.domain.refrigerator.domain.repository.IngredientRepository;
import com.example.puddingbe.domain.refrigerator.domain.repository.PuddingRepository;
import com.example.puddingbe.domain.refrigerator.exception.IngredientNotFoundException;
import com.example.puddingbe.domain.refrigerator.presentation.dto.RefrigeratorCreateResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RefrigeratorCreateService {
    private final IngredientRepository ingredientRepository;
    private final PuddingRepository puddingRepository;

    public RefrigeratorCreateResponse createPudding(Long userId) {
        Ingredient ingredient = ingredientRepository.findByUserId(userId);
        Pudding pudding = puddingRepository.findByUserId(userId);

            if(ingredient == null) {
                throw new IngredientNotFoundException(userId);
            }

            ingredient.useForPudding();
            pudding.craft();

            ingredientRepository.save(ingredient);
            puddingRepository.save(pudding);

            return RefrigeratorCreateResponse.builder()
                    .pudding_1(pudding.getPudding_1())
                    .milk(ingredient.getMilk())
                    .egg(ingredient.getEgg())
                    .sugar(ingredient.getSugar())
                    .build();
    }
}

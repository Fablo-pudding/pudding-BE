package com.example.puddingbe.domain.refrigerator.service;

import com.example.puddingbe.domain.refrigerator.domain.entity.Ingredient;
import com.example.puddingbe.domain.refrigerator.domain.entity.Pudding;
import com.example.puddingbe.domain.refrigerator.domain.repository.PuddingRepository;
import com.example.puddingbe.domain.refrigerator.exception.IngredientNotFoundException;
import com.example.puddingbe.domain.refrigerator.exception.PuddingNotFoundException;
import com.example.puddingbe.domain.refrigerator.presentation.dto.RefrigeratorResponse;
import com.example.puddingbe.domain.refrigerator.domain.repository.IngredientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RefrigeratorReadService {
    private final IngredientRepository ingredientRepository;
    private final PuddingRepository puddingRepository;

    public RefrigeratorResponse getRefrigerator(Long userId) {

        Ingredient ingredient = ingredientRepository.findByUserId(userId);
        if (ingredient == null) {
            throw IngredientNotFoundException.EXCEPTION;
        }
            Pudding pudding = puddingRepository.findByUserId(userId);
        if (pudding == null) {
            throw new PuddingNotFoundException();
        }
            return RefrigeratorResponse.builder()
                    .milk(ingredient.getMilk())
                    .sugar(ingredient.getSugar())
                    .egg(ingredient.getEgg())
                    .pudding_1(pudding.getPudding_1())
                    .pudding_2(pudding.getPudding_2())
                    .pudding_3(pudding.getPudding_3())
                    .build();
    }
}

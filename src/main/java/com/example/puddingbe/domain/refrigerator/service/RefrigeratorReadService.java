package com.example.puddingbe.domain.refrigerator.service;

import com.example.puddingbe.domain.inquiry.exception.InquiryNotFoundException;
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
            throw new IngredientNotFoundException(userId);
        }
            Pudding pudding = puddingRepository.findByUserId(userId);
        if (pudding == null) {
            throw new PuddingNotFoundException(userId);
        }
            return RefrigeratorResponse.builder()
                    .milk(ingredient.getMilk())
                    .sugar(ingredient.getSugar())
                    .egg(ingredient.getEgg())
                    .puddingCount(pudding.getPuddingCount())
                    .build();
    }
}

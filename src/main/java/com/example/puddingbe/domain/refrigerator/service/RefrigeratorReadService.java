package com.example.puddingbe.domain.refrigerator.service;

import com.example.puddingbe.domain.refrigerator.domain.entity.Ingredient;
import com.example.puddingbe.domain.refrigerator.domain.entity.Pudding;
import com.example.puddingbe.domain.refrigerator.domain.entity.repository.PuddingRepository;
import com.example.puddingbe.domain.refrigerator.presentation.dto.RefrigeratorResponse;
import com.example.puddingbe.domain.refrigerator.domain.entity.repository.IngredientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RefrigeratorReadService {

    private final IngredientRepository ingredientRepository;
    private final PuddingRepository puddingRepository;

    public RefrigeratorResponse getRefrigerator() {
        List<Ingredient> ingredients = ingredientRepository.findAll();
        List<Pudding> puddings = puddingRepository.findAll();
        return new RefrigeratorResponse(ingredients, puddings);
    }
}

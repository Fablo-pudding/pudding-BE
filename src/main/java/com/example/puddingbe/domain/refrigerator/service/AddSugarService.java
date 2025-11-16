package com.example.puddingbe.domain.refrigerator.service;

import com.example.puddingbe.domain.refrigerator.domain.entity.Ingredient;
import com.example.puddingbe.domain.refrigerator.domain.repository.IngredientRepository;
import com.example.puddingbe.domain.refrigerator.presentation.dto.IngredientAddResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddSugarService {
    private final IngredientRepository ingredientRepository;

    public IngredientAddResponse addSomeSugar(Long userId){
        Ingredient ingredient = ingredientRepository.findByUserId(userId);
        ingredient.addSugar();

        ingredientRepository.save(ingredient);

        return IngredientAddResponse.builder()
                .sugar(ingredient.getSugar())
                .build();
    }
}

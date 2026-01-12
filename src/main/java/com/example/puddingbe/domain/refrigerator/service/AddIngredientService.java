package com.example.puddingbe.domain.refrigerator.service;

import com.example.puddingbe.domain.refrigerator.domain.IngredientType;
import com.example.puddingbe.domain.refrigerator.domain.entity.Ingredient;
import com.example.puddingbe.domain.refrigerator.domain.repository.IngredientRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor

public class AddIngredientService {
    private final IngredientRepository ingredientRepository;

    @Transactional
    public void addIngredient(Long userId, IngredientType type) {
        Ingredient ingredient = ingredientRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("Ingredient not found"));

        type.apply(ingredient);
    }
}

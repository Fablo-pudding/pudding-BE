package com.example.puddingbe.domain.refrigerator.dto;

import com.example.puddingbe.domain.refrigerator.domain.entity.Ingredient;
import com.example.puddingbe.domain.refrigerator.domain.entity.PuddingLevel;
import com.example.puddingbe.domain.refrigerator.domain.entity.IngredientType;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class RefrigeratorResponse {
    private Long id;
    private IngredientType ingredientType;
    private PuddingLevel puddingLevel;
    private Integer quantity;

    public RefrigeratorResponse(Ingredient ingredient) {
        id = ingredient.getId();
        ingredientType = ingredient.getType();
        quantity = ingredient.getQuantity();
        puddingLevel = ingredient.getPudding().getLevel();
    }
}
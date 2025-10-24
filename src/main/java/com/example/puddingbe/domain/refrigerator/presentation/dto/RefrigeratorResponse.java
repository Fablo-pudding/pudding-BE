package com.example.puddingbe.domain.refrigerator.presentation.dto;

import com.example.puddingbe.domain.refrigerator.domain.entity.Ingredient;
import com.example.puddingbe.domain.refrigerator.domain.entity.Pudding;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.util.List;

@Getter
@NoArgsConstructor

public class RefrigeratorResponse {
    private List<Ingredient> ingredients;
    private List<Pudding> puddings;

    public RefrigeratorResponse(List<Ingredient> ingredients, List<Pudding> puddings) {
        this.ingredients = ingredients;
        this.puddings = puddings;
    }
}

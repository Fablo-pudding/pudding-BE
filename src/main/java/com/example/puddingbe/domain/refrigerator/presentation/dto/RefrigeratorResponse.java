package com.example.puddingbe.domain.refrigerator.presentation.dto;

import com.example.puddingbe.domain.refrigerator.domain.entity.Ingredient;
import com.example.puddingbe.domain.refrigerator.domain.entity.Pudding;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class RefrigeratorResponse {
    private Long milk;
    private Long sugar;
    private Long egg;
    private Long puddingCount;

    public RefrigeratorResponse(Ingredient ingredient, Pudding pudding) {
        this.milk = ingredient.getMilk();
        this.sugar = ingredient.getSugar();
        this.egg = ingredient.getEgg();
        this.puddingCount = pudding.getPuddingCount();
    }
}
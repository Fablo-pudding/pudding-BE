package com.example.puddingbe.domain.refrigerator.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum IngredientType {
    EGG("달걀"),
    MILK("우유"),
    SUGAR("설탕");
    private final String name;
}

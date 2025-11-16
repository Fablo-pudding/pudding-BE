package com.example.puddingbe.domain.refrigerator.presentation.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@AllArgsConstructor
public class IngredientAddResponse {
    private final Long milk;
    private final Long sugar;
    private final Long egg;
}

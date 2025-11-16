package com.example.puddingbe.domain.refrigerator.presentation.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class RefrigeratorResponse {
    private final Long milk;
    private final Long sugar;
    private final Long egg;
    private final Long pudding_1;
    private final Long pudding_2;
    private final Long pudding_3;
}

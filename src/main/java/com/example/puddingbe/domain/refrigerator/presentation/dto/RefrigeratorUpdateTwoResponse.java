package com.example.puddingbe.domain.refrigerator.presentation.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class RefrigeratorUpdateTwoResponse {
    private final Long pudding_2;
    private final Long pudding_3;
}

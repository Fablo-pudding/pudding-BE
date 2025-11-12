package com.example.puddingbe.domain.refrigerator.presentation.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class RefrigeratorUpdateResponse {
    private final Long pudding_1;
    private final Long pudding_2;
}

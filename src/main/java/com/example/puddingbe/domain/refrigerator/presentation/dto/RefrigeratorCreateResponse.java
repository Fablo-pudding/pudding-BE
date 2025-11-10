package com.example.puddingbe.domain.refrigerator.presentation.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Getter
@Builder
public class RefrigeratorCreateResponse {
    private Long puddingCount;
    private Long milk;
    private Long egg;
    private Long sugar;
}

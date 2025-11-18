package com.example.puddingbe.domain.ranking.presentation.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class RankingResponse {
    private long id;
    private long userId;
    private long totalPudding;
}

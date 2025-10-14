package com.example.puddingbe.domain.ranking.domain.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class RankingResponse {
    private long id;
    private long userId;
    private int totalPudding;
}

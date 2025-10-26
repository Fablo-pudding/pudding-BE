package com.example.puddingbe.domain.ranking.presentation.dto;

import com.example.puddingbe.domain.ranking.domain.Ranking;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class RankingResponse {
    private int rank;
    private long id;
    private long userId;
    private long totalPudding;

    public RankingResponse(Ranking ranking) {
        this.rank = getRank();
        this.userId = getUserId();
        this.totalPudding = getTotalPudding();
    }
}

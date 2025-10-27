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

    public RankingResponse(Ranking ranking, int rank) {
        this.rank = rank;
        this.id = ranking.getId();
        this.userId = ranking.getUserId();
        this.totalPudding = ranking.getTotalPudding();
    }
}

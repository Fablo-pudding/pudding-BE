package com.example.puddingbe.domain.ranking.presentation.dto;

import com.example.puddingbe.domain.refrigerator.domain.entity.Pudding;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class RankingResponse {
    private int rank;
    private long userId;
    private String userName;
    private String userProfileImageUrl;
    private long pudding3;

    public RankingResponse(Pudding pudding, int rank) {
        this.rank = rank;
        this.userId = pudding.getUser().getId();
        this.userName = pudding.getUser().getName();
        this.userProfileImageUrl = pudding.getUser().getProfileImageUrl();
        this.pudding3 = pudding.getPudding_3();
    }
}

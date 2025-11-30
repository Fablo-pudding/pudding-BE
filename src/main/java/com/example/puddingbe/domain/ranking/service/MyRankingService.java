package com.example.puddingbe.domain.ranking.service;

import com.example.puddingbe.domain.ranking.presentation.dto.RankingResponse;
import com.example.puddingbe.domain.refrigerator.domain.entity.Pudding;
import com.example.puddingbe.domain.refrigerator.domain.repository.PuddingRepository;
import com.example.puddingbe.global.detail.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@RequiredArgsConstructor
@Service
public class MyRankingService {
    private final PuddingRepository puddingRepository;
    private final UserFacade userFacade;

    public RankingResponse getMyRanking() {
        Long userId = userFacade.getUserId();
        Pudding pudding = puddingRepository.findByUserId(userId);
        List<Pudding> allRanking = puddingRepository.findAllByOrderByPudding3Desc();
        int rank = 1;

        for(int i = 0; i < allRanking.size(); i++) {
            if (allRanking.get(i).getUser().getId().equals(userId)) {
                rank = i + 1;
                break;
            }
        }
        return new RankingResponse(pudding, rank);
    }
}

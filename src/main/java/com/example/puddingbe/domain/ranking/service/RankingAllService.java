package com.example.puddingbe.domain.ranking.service;

import com.example.puddingbe.domain.ranking.presentation.dto.RankingResponse;
import com.example.puddingbe.domain.refrigerator.domain.entity.Pudding;
import com.example.puddingbe.domain.refrigerator.domain.repository.PuddingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class RankingAllService {
    private final PuddingRepository puddingRepository;

    public List<RankingResponse> getAllRanking() {
        List<Pudding> allRanking = puddingRepository.findAllByOrderByPudding3Desc();
        List<RankingResponse> rankingList = new ArrayList<>();

        for (int i = 0; i < allRanking.size(); i++){
            rankingList.add(new RankingResponse(allRanking.get(i), i + 1));
        }
        return rankingList;
    }
}

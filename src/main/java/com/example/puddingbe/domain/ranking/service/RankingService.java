package com.example.puddingbe.domain.ranking.service;

import com.example.puddingbe.domain.ranking.domain.repository.RankingRepository;
import com.example.puddingbe.domain.ranking.presentation.dto.RankingResponse;
import com.example.puddingbe.global.detail.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RankingService {
    private final RankingRepository rankingRepository;
    private final UserFacade userFacade;

    public List<RankingResponse> getAllRankings() {
        return rankingRepository.findAllOrderByTotalPuddingDesc();
    }

    public RankingResponse getUserRanking(Long userId) {
        return rankingRepository.findByUserId(userId)
                .orElseThrow(()->new RuntimeException("유저를 찾을 수 없습니다"));
    }
}

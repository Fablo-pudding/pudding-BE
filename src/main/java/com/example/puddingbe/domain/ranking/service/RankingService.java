package com.example.puddingbe.domain.ranking.service;

import com.example.puddingbe.domain.ranking.domain.repository.RankingRepository;
import com.example.puddingbe.domain.ranking.presentation.dto.RankingResponse;
import com.example.puddingbe.domain.refrigerator.domain.entity.repository.PuddingRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RankingService {
    private final RankingRepository rankingRepository;
    private final PuddingRepository puddingRepository;

    @Transactional
    public void updateRankings() {
        puddingRepository.findAll().forEach(p ->
                rankingRepository.findEntityByUserId(p.getUser().getId())
                        .ifPresent(r -> r.updateTotalPudding(
                                (int)(p.getPudding_level_1()
                                        + p.getPudding_level_2() * 3
                                        + p.getPudding_level_3() * 9)
                        ))
        );
    }

    public List<RankingResponse> getAllRankings() {
        updateRankings();
        return rankingRepository.findAllOrderByTotalPuddingDesc();
    }

    public RankingResponse getUserRanking(Long userId) {
        updateRankings();
        return rankingRepository.findByUserId(userId)
                .orElseThrow(()->new RuntimeException("유저를 찾을 수 없습니다"));
    }
}

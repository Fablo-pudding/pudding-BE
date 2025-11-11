package com.example.puddingbe.domain.ranking.service;

import com.example.puddingbe.domain.ranking.domain.repository.RankingRepository;
import com.example.puddingbe.domain.ranking.presentation.dto.RankingResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RankingService {
    private final RankingRepository rankingRepository;

    public List<RankingResponse> getAllRankings() {
        return rankingRepository.findAllRankings(); // 쿼리로 전체 조회
    }


    public RankingResponse getUserRanking(Long userId) {
        return rankingRepository.findRankingByUserId(userId)
                .map(r -> new RankingResponse(r.getId(),r.getUserId(), r.getTotalPudding()))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "유저를 찾을 수 없습니다."));
    }
}

package com.example.puddingbe.domain.ranking.service;

import com.example.puddingbe.domain.ranking.presentation.dto.RankingResponse;
import com.example.puddingbe.domain.refrigerator.domain.repository.PuddingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class RankingAllService {
    private final PuddingRepository puddingRepository;

    public List<RankingResponse> getAllRanking() {
        return puddingRepository.findAllByOrderByPudding3Desc().stream()
                .map(RankingResponse::new)
                .collect(Collectors.toList());
    }
}

package com.example.puddingbe.domain.ranking.presentation;

import com.example.puddingbe.domain.ranking.presentation.dto.RankingResponse;
import com.example.puddingbe.domain.ranking.service.RankingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ranking")
@RequiredArgsConstructor
public class RankingController {
    private final RankingService rankingService;

    @GetMapping("/global")
    @ResponseStatus(HttpStatus.OK)
    public List<RankingResponse> getAllRankings() {
        return rankingService.getAllRankings();
    }

    @GetMapping("/user-id")
    @ResponseStatus(HttpStatus.OK)
    public RankingResponse getUserRanking(Long userId) {
        return rankingService.getUserRanking(userId);
    }
}

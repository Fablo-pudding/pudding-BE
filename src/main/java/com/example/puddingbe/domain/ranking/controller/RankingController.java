package com.example.puddingbe.domain.ranking.controller;

import com.example.puddingbe.domain.ranking.domain.dto.RankingResponse;
import com.example.puddingbe.domain.ranking.domain.entity.Ranking;
import com.example.puddingbe.domain.ranking.service.RankingReadService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/ranking")
@RequiredArgsConstructor
public class RankingController {
    private RankingReadService rankingReadService;

    @GetMapping("/global")
    @ResponseStatus(HttpStatus.OK)
    public List<RankingResponse> getAllRanking() {
        return rankingReadService.getAllRanking();
    }

    @GetMapping("/{user-id}")
    @ResponseStatus(HttpStatus.OK)
    public Ranking getUserRanking(@PathVariable Long userId) {
        return rankingReadService.getUserRanking();
    }
}

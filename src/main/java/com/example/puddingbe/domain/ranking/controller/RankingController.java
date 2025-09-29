package com.example.puddingbe.domain.ranking.controller;

import com.example.puddingbe.domain.ranking.domain.entity.Ranking;
import com.example.puddingbe.domain.ranking.repository.RankingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/ranking")
@RequiredArgsConstructor
public class RankingController {
    private RankingRepository rankingRepository;

    @GetMapping("/global")
    @ResponseStatus(HttpStatus.OK)
    public List<Ranking> getAllRankng() {
        return rankingRepository.findAllByOrderByTotalPuddingDesc();
    }

    @GetMapping("/{user-id}")
    @ResponseStatus(HttpStatus.OK)
    public Ranking getUserRanking(@PathVariable Long userId) {
        return rankingRepository.findByUserId(userId)
                .orElseThrow(()->new RuntimeException("유저를 찾을 수 없습니다."));
    }
}

package com.example.puddingbe.domain.ranking.presentation;

import com.example.puddingbe.domain.ranking.presentation.dto.RankingResponse;
import com.example.puddingbe.domain.ranking.service.MyRankingService;
import com.example.puddingbe.domain.ranking.service.RankingAllService;
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

    private final RankingAllService rankingAllService;
    private final MyRankingService myRankingService;

    @GetMapping("/global")
    @ResponseStatus(HttpStatus.OK)
    public List<RankingResponse> getAllRanking() {
        return rankingAllService.getAllRanking();
    }

    @GetMapping("/my")
    @ResponseStatus(HttpStatus.OK)
    public RankingResponse getMyRanking() {
        return myRankingService.getMyRanking();
    }
}

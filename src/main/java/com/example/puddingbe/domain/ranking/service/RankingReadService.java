package com.example.puddingbe.domain.ranking.service;

import com.example.puddingbe.domain.ranking.domain.dto.RankingResponse;
import com.example.puddingbe.domain.ranking.repository.RankingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import java.util.List;

@RequiredArgsConstructor
@Service
public class RankingReadService {
    private final RedisTemplate<String, Object> redisTemplate;
    private RankingRepository rankingRepository;

//    public List<RankingRepository> getAllRanking() {
//        return rankingRepository.findAll();
//    }
//
//    public RankingResponse getUserRanking() {
//        return RankingResponse();
//    }
}
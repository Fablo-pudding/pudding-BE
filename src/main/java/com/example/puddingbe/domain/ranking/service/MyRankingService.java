package com.example.puddingbe.domain.ranking.service;

import com.example.puddingbe.domain.ranking.presentation.dto.RankingResponse;
import com.example.puddingbe.domain.refrigerator.domain.repository.PuddingRepository;
import com.example.puddingbe.domain.user.domain.User;
import com.example.puddingbe.domain.user.domain.repository.UserRepository;
import com.example.puddingbe.global.detail.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MyRankingService {
    private final PuddingRepository puddingRepository;
    private final UserRepository userRepository;
    private final UserFacade userFacade;

    public RankingResponse getMyRanking() {
        Long userId = userFacade.getUserId();
        User user = userRepository.findById(userId)
                .orElseThrow(()->new IllegalArgumentException("유효하지 않은 사용자 정보입니다."));
        return new RankingResponse(puddingRepository.findByUser(user));
    }
}

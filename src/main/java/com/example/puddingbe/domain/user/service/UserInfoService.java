package com.example.puddingbe.domain.user.service;

import com.example.puddingbe.domain.ranking.service.MyRankingService;
import com.example.puddingbe.domain.user.exception.ForbiddenUserInformationException;
import com.example.puddingbe.domain.user.presentation.dto.response.UserInfoResponse;
import com.example.puddingbe.global.jwt.JwtTokenProvider;
import com.example.puddingbe.domain.user.domain.User;
import com.example.puddingbe.domain.user.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserInfoService {
    private final JwtTokenProvider jwtTokenProvider;
    private final UserRepository userRepository;
    private final MyRankingService myRankingService;

    public UserInfoResponse showInformation(String authorizationHeader) {
        if (authorizationHeader == null || !authorizationHeader.startsWith("Bearer ")) {
                throw new RuntimeException();
        }

        String token = authorizationHeader.substring(7);
        jwtTokenProvider.validateToken(token); // 토큰 검증

        String name = jwtTokenProvider.getNameFromToken(token); // 이름 추출

        User findUser = userRepository.findByName(name) // 저장된 name 값과 이름 일치 여부 확인
                .orElseThrow(() -> ForbiddenUserInformationException.EXCEPTION);

        return UserInfoResponse.builder()
                .userId(findUser.getId())
                .name(findUser.getName())
                .ranking(myRankingService.getMyRanking().getRank())
                .profileImageUrl(findUser.getProfileImageUrl())
                .build();
    }
}

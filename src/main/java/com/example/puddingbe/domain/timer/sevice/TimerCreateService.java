package com.example.puddingbe.domain.timer.sevice;

import com.example.puddingbe.domain.timer.exception.AlreadyExistTimerException;
import com.example.puddingbe.domain.timer.presentation.dto.TimerRequest;
import com.example.puddingbe.domain.timer.domain.TimerEntity;
import com.example.puddingbe.domain.timer.domain.repository.TimerRepository;
import com.example.puddingbe.domain.user.domain.User;
import com.example.puddingbe.domain.user.domain.repository.UserRepository;
import com.example.puddingbe.domain.user.exception.UnauthorizedUserException;
import com.example.puddingbe.global.detail.UserFacade;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TimerCreateService {
    private final TimerRepository timerRepository;
    private final UserRepository userRepository;
    private final UserFacade userFacade;

    @Transactional
    public void createTimer(TimerRequest timerRequest) {
        Long userId = userFacade.getUserId();
        User user = userRepository.findById(userId)
                .orElseThrow(() -> UnauthorizedUserException.EXCEPTION);

        if(timerRepository.existsByUser(user)) { // user_id 컬럼의 unique 제약은 아래에서 Entity 과정에서 터지기 때문에 그 전에 예외 처리
            throw AlreadyExistTimerException.EXCEPTION;
        }

        TimerEntity timerEntity = TimerEntity.builder()
                .totalTime(timerRequest.getElapsedTime()) //request 에서 받아오는 elapsedTime 값을 Entity의 totalTime 필드에 세팅
                .user(user)
                .build();

        timerRepository.save(timerEntity); // 세팅된 값을 저장
    }
}

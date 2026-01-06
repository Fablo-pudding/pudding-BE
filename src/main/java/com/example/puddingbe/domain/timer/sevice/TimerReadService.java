package com.example.puddingbe.domain.timer.sevice;

import com.example.puddingbe.domain.timer.exception.TimerNotFoundException;
import com.example.puddingbe.domain.timer.presentation.dto.TimerResponse;
import com.example.puddingbe.domain.timer.domain.TimerEntity;
import com.example.puddingbe.domain.timer.domain.repository.TimerRepository;
import com.example.puddingbe.domain.user.domain.User;
import com.example.puddingbe.domain.user.domain.repository.UserRepository;
import com.example.puddingbe.domain.user.exception.UnauthorizedUserException;
import com.example.puddingbe.global.detail.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TimerReadService {
    private final TimerRepository timerRepository;
    private final UserRepository userRepository;
    private final UserFacade userFacade;

    public TimerResponse readTimer() {
        Long userId = userFacade.getUserId();
        User user = userRepository.findById(userId)
                .orElseThrow(() -> UnauthorizedUserException.EXCEPTION);

        TimerEntity timerEntity = timerRepository.findByUser(user)
                .orElseThrow(() -> TimerNotFoundException.EXCEPTION);

        timerRepository.delete(timerEntity); // 이미 값은 받아왔기 때문에 return 전에 DB를 delete 해주면 됩니다.

        return TimerResponse.builder() // return 문은 완전히 끝나는 구문.
                .totalTime(timerEntity.getTotalTime())
                .build();
    }
}

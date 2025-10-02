package com.example.puddingbe.domain.timer.sevice;

import com.example.puddingbe.domain.timer.domain.dto.TimerRequest;
import com.example.puddingbe.domain.timer.domain.entity.TimerEntity;
import com.example.puddingbe.domain.timer.repository.TimerRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TimerCreateService {
    private final TimerRepository timerRepository;

    @Transactional
    public void createTimer(TimerRequest timerRequest) {
        TimerEntity timerEntity = TimerEntity.builder()
                .totalTime(timerRequest.getElapsedTime()) //request 에서 받아오는 elapsedTime 값을 Entity의 totalTime 필드에 세팅
                .build();

        timerRepository.save(timerEntity); // 세팅된 값을 저장
    }
}

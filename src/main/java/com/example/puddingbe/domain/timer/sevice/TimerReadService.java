package com.example.puddingbe.domain.timer.sevice;

import com.example.puddingbe.domain.timer.presentation.dto.TimerResponse;
import com.example.puddingbe.domain.timer.domain.TimerEntity;
import com.example.puddingbe.domain.timer.domain.repository.TimerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class TimerReadService {
    private final TimerRepository timerRepository;

    public TimerResponse readTimer(Long id) {
        TimerEntity timerEntity = timerRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.UNAUTHORIZED));

        return TimerResponse.builder()
                .totalTime(timerEntity.getTotalTime())
                .id(timerEntity.getId())
                .build();
    }
}

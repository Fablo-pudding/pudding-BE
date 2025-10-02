package com.example.puddingbe.domain.timer.sevice;

import com.example.puddingbe.domain.timer.domain.dto.TimerRequest;
import com.example.puddingbe.domain.timer.domain.entity.TimerEntity;
import com.example.puddingbe.domain.timer.repository.TimerRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class TimerUpdateService {
    private final TimerRepository timerRepository;

    @Transactional
    public void updateTimer(Long id, TimerRequest timerRequest) {
        TimerEntity timerEntity = timerRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.UNAUTHORIZED));

        timerEntity.update(timerRequest.getElapsedTime());
    }
}

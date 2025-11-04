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

        timerRepository.delete(timerEntity); // 이미 값은 받아왔기 때문에 return 전에 DB를 delete 해주면 됩니다.

        return TimerResponse.builder() // return 문은 완전히 끝나는 구문.
                .totalTime(timerEntity.getTotalTime())
                .id(timerEntity.getId())
                .build();
    }
}

package com.example.puddingbe.domain.timer.presentation;

import com.example.puddingbe.domain.timer.presentation.dto.TimerResponse;
import com.example.puddingbe.domain.timer.sevice.TimerCreateService;
import com.example.puddingbe.domain.timer.presentation.dto.TimerRequest;
import com.example.puddingbe.domain.timer.sevice.TimerReadService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor // final 필드에 대한 생성자 자동 생성
@RequestMapping("/timer")
public class TimerController {
    private final TimerCreateService timerCreateService;
    private final TimerReadService timerReadService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createTimer(@RequestBody TimerRequest timerRequest) {
        timerCreateService.createTimer(timerRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public TimerResponse getTimer() { // 타이머 조회는 한유저 당 한개의 타이머만 가능하기 때문에 토큰으로 검증 가능
        return timerReadService.readTimer();
    }
}

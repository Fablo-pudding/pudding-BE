package com.example.puddingbe.domain.timer.controller;

import com.example.puddingbe.domain.timer.sevice.TimerService;
import com.example.puddingbe.domain.timer.domain.dto.TimerRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor // final 필드에 대한 생성자 자동 생성
@RequestMapping("/timer")
public class TimerController {
    private final TimerService timerService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void createTimer(@RequestBody TimerRequest timerRequest) {
        timerService.createTimer(timerRequest);
    }
}

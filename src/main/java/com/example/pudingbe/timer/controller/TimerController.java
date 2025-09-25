package com.example.pudingbe.timer.controller;

import com.example.pudingbe.timer.domain.dto.TimerRequest;
import com.example.pudingbe.timer.sevice.TimerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Timer;

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

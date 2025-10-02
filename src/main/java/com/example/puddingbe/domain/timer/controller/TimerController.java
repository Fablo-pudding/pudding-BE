package com.example.puddingbe.domain.timer.controller;

import com.example.puddingbe.domain.timer.sevice.TimerCreateService;
import com.example.puddingbe.domain.timer.domain.dto.TimerRequest;
import com.example.puddingbe.domain.timer.sevice.TimerUpdateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor // final 필드에 대한 생성자 자동 생성
@RequestMapping("/timer")
public class TimerController {
    private final TimerCreateService timerCreateService;
    private final TimerUpdateService timerUpdateService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createTimer(@RequestBody TimerRequest timerRequest) {
        timerCreateService.createTimer(timerRequest);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateTimer(@PathVariable Long id, @RequestBody TimerRequest timerRequest) {
        timerUpdateService.updateTimer(id, timerRequest);
    }
}

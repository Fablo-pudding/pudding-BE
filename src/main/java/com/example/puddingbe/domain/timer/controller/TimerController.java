package com.example.puddingbe.domain.timer.controller;

import com.example.puddingbe.domain.timer.domain.dto.TimerResponse;
import com.example.puddingbe.domain.timer.sevice.TimerCreateService;
import com.example.puddingbe.domain.timer.domain.dto.TimerRequest;
import com.example.puddingbe.domain.timer.sevice.TimerReadService;
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
    private final TimerReadService timerReadService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createTimer(@RequestBody TimerRequest timerRequest) {
        timerCreateService.createTimer(timerRequest);
    }

    @PutMapping("/{timer-id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateTimer(@PathVariable("timer-id") Long id, @RequestBody TimerRequest timerRequest) { // 매핑 id를 timer-id로 수정시 @PathVariable 에도 추가 해야함.
        timerUpdateService.updateTimer(id, timerRequest);
    }

    @GetMapping("/{timer-id}")
    @ResponseStatus(HttpStatus.OK)
    public TimerResponse getTimer(@PathVariable("timer-id") Long id) { // 서비스에 넘겨주는 id
        return timerReadService.readTimer(id);
    }
}

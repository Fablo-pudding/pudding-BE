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

    @GetMapping("/{timer-id}")
    @ResponseStatus(HttpStatus.OK)
    public TimerResponse getTimer(@PathVariable("timer-id") Long id) { // 서비스에 넘겨주는 id
        return timerReadService.readTimer(id);
    }
}

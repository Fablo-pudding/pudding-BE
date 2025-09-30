package com.example.puddingbe.domain.timer.domain.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class TimerRequest {
    private Long elapsedTime; // 클라이언트가 보내는 시간
}

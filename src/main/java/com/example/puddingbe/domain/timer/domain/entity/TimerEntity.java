package com.example.puddingbe.domain.timer.domain.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class TimerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // db 식별

    @Column
    private Long totalTime; // 토탈 값

    public void update(Long elapsedTime) {
        this.totalTime += elapsedTime;
    }
}

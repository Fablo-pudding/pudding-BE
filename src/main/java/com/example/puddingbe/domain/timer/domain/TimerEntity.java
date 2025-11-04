package com.example.puddingbe.domain.timer.domain;

import com.example.puddingbe.domain.user.domain.User;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "tbl_timer")
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

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}

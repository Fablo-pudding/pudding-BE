package com.example.puddingbe.domain.refrigerator.domain.entity;

import com.example.puddingbe.domain.user.domain.User;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "tbl_pudding")
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter

public class Pudding {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, columnDefinition = "INT DEFAULT 0")
    private Long pudding_level_1;

    @Column(nullable = false, columnDefinition = "INT DEFAULT 0")
    private Long pudding_level_2;

    @Column(nullable = false, columnDefinition = "INT DEFAULT 0")
    private Long pudding_level_3;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}

package com.example.puddingbe.domain.refrigerator.domain.entity;

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

    @Column(nullable = false,columnDefinition = "INT DEFAULT 0")
    private Long pudding_1;

    @Column(nullable = false,columnDefinition = "INT DEFAULT 0")
    private Long pudding_2;

    @Column(nullable = false,columnDefinition = "INT DEFAULT 0")
    private Long pudding_3;
}

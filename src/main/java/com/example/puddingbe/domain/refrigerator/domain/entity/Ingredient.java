package com.example.puddingbe.domain.refrigerator.domain.entity;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "tbl_ingredient")
@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor

public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,columnDefinition = "BIGINT DEFAULT 0")
    private Long milk;

    @Column(nullable = false,columnDefinition = "BIGINT DEFAULT 0")
    private Long sugar;

    @Column(nullable = false,columnDefinition = "BIGINT DEFAULT 0")
    private Long egg;

}

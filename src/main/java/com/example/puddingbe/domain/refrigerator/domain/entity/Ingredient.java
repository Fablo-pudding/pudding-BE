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

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private IngredientType type;

    @Column(columnDefinition = "INT DEFAULT 0")
    private Integer quantity;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "PuddingLevel",nullable = false)
    private Pudding pudding;
}

package com.example.pudingbe.inquiry.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Entity
@Table(name = "tbl_inquiry")
@NoArgsConstructor
public class Inquiry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "inquiry_id")
    private long id;

    @Column(name = "user_id", nullable = false)
    private long userId;

    @Column(name = "title", length = 100, nullable = false)
    private String title;

    @Column(name = "content", length = 512, nullable = false)
    private String content;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;
}

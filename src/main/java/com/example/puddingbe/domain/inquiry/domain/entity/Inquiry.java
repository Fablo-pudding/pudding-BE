package com.example.puddingbe.domain.inquiry.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
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
    private Long id;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name = "title", length = 100, nullable = false)
    private String title;

    @Column(name = "content", length = 512, nullable = false)
    private String content;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "reply", length = 512, nullable = true)

    private String reply;

    public void replyToInquiry(String reply) {
        this.reply = reply;
    }

    @Builder
    public Inquiry(Long userId, String title, String content, LocalDateTime createdAt) {
        this.userId = userId;
        this.title = title;
        this.content = content;
        this.createdAt = createdAt;
    }
}

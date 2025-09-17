package com.example.puddingbe.domain.comment.entity.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
public class CommentResponseDTO {
    private Long userId;
    private String content;
    private LocalDateTime createdAt;

    @Builder
    public CommentResponseDTO(Long userId, String content, LocalDateTime createdAt) {
        this.userId = userId;
        this.content = content;
        this.createdAt = createdAt;
    }
}

package com.example.puddingbe.domain.feed.entity.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class PostResponseDTO {
    Long postId;
    Long userId;
    String title;
    String content;
    LocalDateTime createdAt;

    @Builder
    public PostResponseDTO(Long postId, Long userId, String title, String content, LocalDateTime createdAt) {
        this.postId = postId;
        this.userId = userId;
        this.title = title;
        this.content = content;
        this.createdAt = createdAt;
    }
}

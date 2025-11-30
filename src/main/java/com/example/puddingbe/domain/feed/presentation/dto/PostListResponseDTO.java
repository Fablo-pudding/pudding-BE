package com.example.puddingbe.domain.feed.presentation.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PostListResponseDTO {
    Long postId;
    Long userId;
    String title;
    String content;
    LocalDateTime createdAt;
    Long commentCount;
}

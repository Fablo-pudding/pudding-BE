package com.example.puddingbe.domain.feed.presentation.dto;

import com.example.puddingbe.domain.comment.domain.Comment;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Getter;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PostDetailResponseDTO {
    Long postId;
    Long userId;
    String title;
    String content;
    LocalDateTime createdAt;
    List<Comment> comments;
    Long commentCount;
}

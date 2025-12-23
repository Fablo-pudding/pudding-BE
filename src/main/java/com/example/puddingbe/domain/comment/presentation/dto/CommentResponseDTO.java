package com.example.puddingbe.domain.comment.presentation.dto;

import com.example.puddingbe.domain.feed.domain.Post;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;
@Getter
@AllArgsConstructor
public class CommentResponseDTO {
    private Long commentId;

    private Long userId;

    private String content;

    private LocalDateTime createdAt;
}

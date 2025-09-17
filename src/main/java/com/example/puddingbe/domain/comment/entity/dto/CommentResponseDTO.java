package com.example.puddingbe.domain.comment.entity.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class CommentResponseDTO {
    private Long commentId;
    private Long userId;
    private String content;
    private LocalDateTime createdAt;
}

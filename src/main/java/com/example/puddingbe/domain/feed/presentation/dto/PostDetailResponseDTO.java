package com.example.puddingbe.domain.feed.presentation.dto;

import com.example.puddingbe.domain.comment.domain.Comment;
import com.example.puddingbe.domain.comment.presentation.dto.CommentResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@AllArgsConstructor
public class PostDetailResponseDTO {
    Long postId;
    Long userId;
    String title;
    String content;
    LocalDateTime createdAt;
    List<CommentResponseDTO> comments;
    Long commentCount;
}

package com.example.puddingbe.domain.feed.entity.dto;

import com.example.puddingbe.domain.comment.entity.Comment;
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
    List<Comment> comments;
}

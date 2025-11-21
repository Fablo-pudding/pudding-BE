package com.example.puddingbe.domain.feed.presentation.dto;

import com.example.puddingbe.domain.comment.domain.Comment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@AllArgsConstructor
public class PostDetailResponseDTO {
    Long post_id;
    Long user_id;
    String title;
    String content;
    LocalDateTime created_at;
    List<Comment> comments;
    Long comment_count;
}

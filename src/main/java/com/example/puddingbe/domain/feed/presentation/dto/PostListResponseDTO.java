package com.example.puddingbe.domain.feed.presentation.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class PostListResponseDTO {
    Long post_id;
    Long user_id;
    String title;
    String content;
    LocalDateTime created_at;
    Long comment_count;
}

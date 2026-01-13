package com.example.puddingbe.domain.feed.presentation.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class PostListResponseDTO {
    Long postId;
    String profileImageUrl;
    String title;
    String name;
    LocalDateTime createdAt;
    Integer commentCount;
}
package com.example.puddingbe.domain.feed.entity.dto;

import lombok.Getter;

@Getter
public class PostResponseDTO {
    //?
    Long postId;
    Long userId;
    String title;
    String content;
    String createdAt;
}

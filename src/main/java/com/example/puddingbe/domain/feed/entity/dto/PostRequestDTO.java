package com.example.puddingbe.domain.feed.entity.dto;

import lombok.Getter;

@Getter
public class PostRequestDTO {
    private Long userId;
    private String title;
    private String content;
}

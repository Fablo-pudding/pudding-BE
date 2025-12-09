package com.example.puddingbe.domain.awss3.presentation.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ImageUpdateRequest {
    private Long userId;
    private String imageUrl;
}

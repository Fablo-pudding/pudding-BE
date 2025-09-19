package com.example.pudingbe.Mypage;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MyPageResponse {
    private String name;
    private String statusMessage;
    private Long ranking;
    private String profileImageUrl;
}

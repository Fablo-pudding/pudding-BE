package com.example.pudingbe.Mypage;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MyPageResponse {
    private String name;
    private String statusMessage;
    private Long ranking;
    private String profileImageUrl;
}

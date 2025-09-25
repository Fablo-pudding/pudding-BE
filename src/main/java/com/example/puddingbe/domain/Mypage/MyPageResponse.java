package com.example.puddingbe.domain.Mypage;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MyPageResponse {
    private Long userId;
    private String name;
    private String statusMessage;
    private Long ranking;
    private String profileImageUrl;
}

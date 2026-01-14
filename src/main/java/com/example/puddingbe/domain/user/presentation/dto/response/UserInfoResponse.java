package com.example.puddingbe.domain.user.presentation.dto.response;

import com.example.puddingbe.domain.user.domain.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserInfoResponse {
    private Long userId;
    private String name;
    private int ranking;
    private String profileImageUrl;
    private Role role;
}

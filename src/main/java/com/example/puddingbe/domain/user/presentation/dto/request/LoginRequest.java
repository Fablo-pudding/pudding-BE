package com.example.puddingbe.domain.user.presentation.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class LoginRequest {
     @NotBlank(message = "이름은 필수 입력 사항입니다")
     private String name;

     @NotBlank(message = "비밀번호는 필수 입력 사항입니다")
     private String password;
}

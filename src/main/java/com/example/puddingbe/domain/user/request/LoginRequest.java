package com.example.puddingbe.domain.user.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class LoginRequest {
     @NotBlank(message = "이름은 필수 입력 사항입니다.")
     private String name;

     @NotBlank(message = "비밀번호는 필수 입력 사항입니다.")
     @Pattern(regexp = "^[a-zA-Z0-9_!#$*]{8,20}$",
                message = "최소 8자 ~ 최대 20자까지 가능하며, 숫자, 영어 대소문자와 _!#$*만 허용됩니다.")
     private String password;
}

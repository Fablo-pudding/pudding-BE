package com.example.puddingbe.domain.user.presentation.dto.request;

import com.example.puddingbe.domain.user.domain.Gender;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class SignUpRequest {
    //숫자에는 @NotNull 더 적합.
    @NotBlank(message = "이름에 공백, 띄어쓰기를 사용할 수 없습니다.")
    @Size(min = 3, max = 12, message = "최소 3자 ~ 최대 12자까지 가능합니다.")
    private String name;

    @NotBlank(message = "비밀번호에 공백, 띄어쓰기를 사용할 수 없습니다.")
    @Pattern(regexp = "^[a-zA-Z0-9_!#$*]{8,255}$", message = "최소 8자 ~ 최대 225자까지 가능하며, 숫자, 영어 대소문자와 _!#$*만 허용됩니다.")
    private String password;

    @NotNull(message = "생년월은 필수 입력 사항입니다.")
    private Long birth;

    @NotNull(message = "기수는 필수 입력 사항입니다.")
    private Long batch;

    @NotNull
    private Gender gender;
}

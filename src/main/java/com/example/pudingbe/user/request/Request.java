package com.example.pudingbe.user.request;

import com.example.pudingbe.user.domain.Gender;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Request {
    //숫자에는 @NotNull 더 적합.
    @NotBlank(message = "이름에 공백, 띄어쓰기를 사용할 수 없습니다.")
    @Size(min = 3, max = 12, message = "최소 3자 ~ 최대 12자까지 가능합니다.")
    private String name;

    @NotBlank(message = "비밀번호에 공백, 띄어쓰기를 사용할 수 없습니다.")
    @Size(min = 8, max = 20, message = "최소 8자 ~ 최대 20자까지 가능합니다.")
    private String password;

    @NotNull(message = "생년월은 필수 입력 사항입니다.")
    private Long birth;

    @NotNull(message = "기수는 필수 입력 사항입니다.")
    private Long batch;

    @NotNull
    private Gender gender;

    public String getName() {
        return name;
    }

    public Long getBirth() {
        return birth;
    }

    public String getPassword() {
        return password;
    }

    public Long getBatch() {
        return batch;
    }

    public Gender getGender() {
        return gender;
    }
}

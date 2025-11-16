package com.example.puddingbe.global.error;

import lombok.*;

@Builder
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class ErrorResponse {
    private String message;
    private Integer status;

    public static ErrorResponse of(String message, Integer status) {
        return ErrorResponse.builder()
                .message(message)
                .status(status)
                .build();
    }

}

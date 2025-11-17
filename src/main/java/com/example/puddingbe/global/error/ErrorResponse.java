package com.example.puddingbe.global.error;

import com.example.puddingbe.global.error.exception.ErrorCode;
import lombok.*;

@Builder
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class ErrorResponse {
    private String message;
    private Integer status;
    private String description;

    public static ErrorResponse of(ErrorCode errorCode, String description) {
        return ErrorResponse.builder()
                .message(errorCode.getMessage())
                .status(errorCode.getStatus())
                .description(description)
                .build();
    }

}

package com.example.puddingbe.global.exception;

public class CustomJwtException extends RuntimeException { // jwt 커스텀 예외 (직접 설정가능한 메세지)
    public CustomJwtException(String message) {
        super(message); // 부모 셍성자인 RuntimeException의 메세지 필드 에게 메세지가 전달
    }

    public static class ExpiredException extends CustomJwtException {
        public ExpiredException() {
            super("JWT 토큰이 만료되었습니다");
        }
    }

    public static class MalformedJwtException extends CustomJwtException {
        public MalformedJwtException() {
            super("JWT 구조가 적합하지 않습니다."); // Header.Payload.Signature
        }
    }

    public static class SignatureException extends CustomJwtException {
        public SignatureException() {
            super("서명 검증에 실패하였습니다.");
        }
    }

    public static class IllegalArgumentException extends CustomJwtException {
        public IllegalArgumentException() {
            super("토큰 문자열은 null, 빈 문자열이 허용되지 않습니다.");
        }
    }
}

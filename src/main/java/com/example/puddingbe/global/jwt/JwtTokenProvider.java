package com.example.puddingbe.global.jwt;

import com.example.puddingbe.global.detail.DetailService;
import com.example.puddingbe.global.exception.CustomJwtException;
import com.example.puddingbe.global.redis.RedisDao;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import java.security.Key;
import java.time.Duration;
import java.util.Base64;
import java.util.Date;
import java.util.stream.Collectors;

@Component
public class JwtTokenProvider { // secretKey 생성
    private final Key key; // signature 비밀키
    private final DetailService detailService;
    private final RedisDao redisDao;

    private static final String GRANT_TYPE = "Bearer"; // DB저장 / 클라요청에서 json형태로 사용되는 타입 ("토큰을 소지했다")

    @Value("${jwt.access-token.expire-time}") // yml 에서 정의된 값을 필드에 주입해서 사용
    private long ACCESS_TOKEN_EXPIRE_TIME;

    @Value("${jwt.refresh-token.expire-time}")
    private long REFRESH_TOKEN_EXPIRE_TIME;

    public JwtTokenProvider(@Value("${jwt.secret}") String secretkey,
                            DetailService detailService,
                            RedisDao redisDao) {
        byte[] keyBytes = Base64.getEncoder().encode(secretkey.getBytes());
        this.key = Keys.hmacShaKeyFor(keyBytes);
        this.detailService = detailService;
        this.redisDao = redisDao;
    } // yml 에서 secretkey 가져오기

    public JwtToken generateToken(Authentication authentication) { // 토큰 생성
        String authorities = authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(","));

        long now = (new Date()).getTime();
        String name = authentication.getName(); // name 필드를 사용가능 하게함

        Date accessTokenExpireTime = new Date(now + ACCESS_TOKEN_EXPIRE_TIME);
        String accessToken = generateAccessToken(name, authorities, accessTokenExpireTime);

        Date refreshTokenExpireTime = new Date(now + REFRESH_TOKEN_EXPIRE_TIME);
        String refreshToken = generateRefreshToken(name, refreshTokenExpireTime);

        redisDao.setValues(name, refreshToken, Duration.ofSeconds(REFRESH_TOKEN_EXPIRE_TIME));

        return JwtToken.builder()
                .grantType(GRANT_TYPE)
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .build();
    }

    public String generateAccessToken(String name, String authorities, Date expireDate) { // access token 생성
        return Jwts.builder()
                .setSubject(name) // payload 에 들어가는 정보
                .claim("auth", authorities) // 권한 정보
                .setIssuedAt(new Date()) // 언제 만들어졌는지
                .setExpiration(expireDate) // JWT 만료시간 설정
                .signWith(key, SignatureAlgorithm.HS256) // signature을 만듬
                .compact(); // 최종 jwt문자열 생성 (Header.Payload.Signature)
    }

    public String generateRefreshToken(String name, Date expireDate) { // refresh token 생성
        return Jwts.builder()
                .setSubject(name)
                .setExpiration(expireDate)
                .signWith(key, SignatureAlgorithm.HS256) // HS256이라는 시그니쳐 생성 알고리즘
                .compact();
    }

    public String getNameFromToken(String token) { // name 추출 메서드
        return Jwts.parserBuilder() // JWT를 파싱하기
                .setSigningKey(key) // provider에서 생성한 secretKey를 통해 서명 검증
                .build()
                .parseClaimsJws(token)
                .getBody() // JWT의 payload 가져오기
                .getSubject(); // payload의 name 반환
    }

    public boolean validateToken(String token) { // 토큰 검증 메서드 (서명과 만료기간등)
        try {
            Jwts.parserBuilder() // JWT 파싱
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(token);

            return true; // 정상적인 검증인 경우
        } catch (SignatureException e) {
            throw new CustomJwtException.SignatureException();
        } catch (ExpiredJwtException e) {
            throw new CustomJwtException.ExpiredException();
        } catch (MalformedJwtException e) {
            throw new CustomJwtException.MalformedJwtException();
        } catch (IllegalArgumentException e) {
            throw new CustomJwtException.IllegalArgumentException();
        }
    }
    public boolean validateRefreshToken(String token) {
        validateToken(token); // 위에 검증 수행 (성공시 true)
        String name = getNameFromToken(token); // 토큰에서 name 추출
        String redisToken = (String) redisDao.getValues(name); // redis에 저장된 name과 비교
        if(!token.equals(redisToken)) { // redis에 저장된 토큰과 요청에서온 토큰의 일치여부 판단
            throw new CustomJwtException("RefreshToken가 일치하지 않습니다."); // 일치하지 않을경우 예외 + 예외 상황 판단
        }

        return true; // 아무 문제 없을경우 ture.
    }

    public String resolveToken(HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");
        if(bearerToken != null && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7);
        }

        return null;
    }

    public Authentication getAuthentication(String request) {
        String name = getNameFromToken(request);
        UserDetails userDetails = detailService.loadUserByUsername(name);
        return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
    }
}

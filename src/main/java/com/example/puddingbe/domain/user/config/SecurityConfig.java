package com.example.puddingbe.domain.user.config;

import com.example.puddingbe.global.jwt.JwtAuthenticationFilter;
import com.example.puddingbe.global.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity // spring SecurityConfig 활성
@RequiredArgsConstructor
public class SecurityConfig { // 접근 허용

    private final JwtTokenProvider jwtTokenProvider;

    @Bean
    public PasswordEncoder passwordEncoder() { //비밀번호 암호화
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .formLogin(form -> form.disable())
                // 서버입장에선 필요없음 -> disable
                .cors(Customizer.withDefaults())
                // 클라이언트쪽에 요청을 받을 수 있게 함.

                .sessionManagement(session ->
                        session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                )
                //세션 사용 X
                .authorizeHttpRequests(auth ->
                        auth // url 접근 설정
                                .requestMatchers("/user/signup", "/user/login").permitAll()
                                // 모두 허용
                                .anyRequest().authenticated() // 그외는 인증 필요
                )
                .addFilterBefore(new JwtAuthenticationFilter(jwtTokenProvider),
                        UsernamePasswordAuthenticationFilter.class); // 필터추가

        return http.build();
    }
}

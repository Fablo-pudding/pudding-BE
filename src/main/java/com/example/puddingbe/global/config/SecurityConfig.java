package com.example.puddingbe.global.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@RequiredArgsConstructor
@EnableMethodSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf ->csrf.disable())
                .authorizeHttpRequests(auth ->auth
                        .requestMatchers(HttpMethod.GET, "/inquiry").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET, "/inquiry/my/{user-id}").authenticated()
                        .requestMatchers(HttpMethod.GET, "/inquiry/{inquiry-id}").authenticated()
                        .requestMatchers(HttpMethod.POST, "/inquiry/{inquiry-id}/reply").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/inquiry/{inquiry-id}").authenticated()
                        .requestMatchers(HttpMethod.POST, "/inquiry").authenticated()
                        .anyRequest().permitAll()
                )
                .httpBasic(httpBasic-> httpBasic.disable());
        disableCsrf(http);
        configureSession(http);
        configureAuthorization(http);

        return http.build();
    }

    // CSRF 설정
    private void disableCsrf(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable());
    }

    // 세션 관리
    private void configureSession(HttpSecurity http) throws Exception {
        http.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
    }

    // 요청 권한 설정
    private void configureAuthorization(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(auth -> auth
                .requestMatchers("/feed/**", "/comment/**").permitAll()
                .anyRequest().permitAll());
    }
}

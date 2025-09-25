package com.example.puddingbe.global.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(HttpMethod.POST, "/timer/**").permitAll() // 테스트용 permitAll (수정해야됨)
                        .requestMatchers(HttpMethod.DELETE, "/inquiry/{inquiry-id}").authenticated()
                        .requestMatchers(HttpMethod.POST, "/inquiry").authenticated()
                        .anyRequest().permitAll()

                )
                .httpBasic(httpBasic -> httpBasic.disable());

        return http.build();
    } // jwt 추가 필요함

}

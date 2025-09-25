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
                .csrf(csrf ->csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(HttpMethod.POST, "/inquiry").permitAll()
                        .requestMatchers(HttpMethod.GET,"/inquiry/my/{userId}").permitAll()
                        .requestMatchers(HttpMethod.POST,"/inquiry/{id}/reply").permitAll()
                        .requestMatchers(HttpMethod.GET, "/inquiry").permitAll()
                        .requestMatchers(HttpMethod.DELETE, "/inquiry/{id}").permitAll()
                        .anyRequest().permitAll()
                )
                .httpBasic(httpBasic -> httpBasic.disable());
        return http.build();
    }
}

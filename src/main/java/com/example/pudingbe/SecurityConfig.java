package com.example.pudingbe;  // ★ PudingBeApplication 과 같은 패키지

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())            // 개발용: CSRF 끔
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().authenticated()      
                )
                .httpBasic(Customizer.withDefaults());
        return http.build();
    }
}

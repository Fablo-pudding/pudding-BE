package com.example.puddingbe.global.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@RequiredArgsConstructor
@EnableMethodSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(auth -> auth
                        // notice API
                        .requestMatchers("/api/notice/**").authenticated()

                        // inquiry API
                        .requestMatchers(HttpMethod.GET, "/inquiry").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET, "/inquiry/my/{user-id}").authenticated()
                        .requestMatchers(HttpMethod.GET, "/inquiry/{inquiry-id}").authenticated()
                        .requestMatchers(HttpMethod.POST, "/inquiry/{inquiry-id}/reply").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/inquiry/{inquiry-id}").authenticated()
                        .requestMatchers(HttpMethod.POST, "/inquiry").authenticated()

                        // feed & comment는 모두 허용
                        .requestMatchers("/feed/**", "/comment/**").permitAll()

                        .anyRequest().permitAll()
                )
                .httpBasic(Customizer.withDefaults());

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user = User.withUsername("pudding")
                .password("{noop}pudding123!")
                .roles("USER")
                .build();
        return new InMemoryUserDetailsManager(user);
    }
}
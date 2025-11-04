package com.example.puddingbe.global.config;

import com.example.puddingbe.global.jwt.JwtAuthenticationFilter;
import com.example.puddingbe.global.jwt.JwtTokenProvider;
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
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@RequiredArgsConstructor
@EnableMethodSecurity
public class SecurityConfig {

    private final JwtTokenProvider jwtTokenProvider;

    @Bean
    public PasswordEncoder passwordEncoder() { //비밀번호 암호화
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(auth -> auth
                        // notice API
                        .requestMatchers("/api/notice/**").authenticated()

                        //user API
                        .requestMatchers("/user/signup", "/user/login").permitAll()
                        .requestMatchers("/user/info").authenticated()

                        //timer API
                        .requestMatchers("/timer").authenticated()
                        .requestMatchers("/timer/read").authenticated()

                        // inquiry API
                        .requestMatchers(HttpMethod.GET, "/inquiry").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET, "/inquiry/my/{user-id}").authenticated()
                        .requestMatchers(HttpMethod.GET, "/inquiry/{inquiry-id}").authenticated()
                        .requestMatchers(HttpMethod.POST, "/inquiry/{inquiry-id}/reply").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/inquiry/{inquiry-id}").authenticated()
                        .requestMatchers(HttpMethod.POST, "/inquiry").authenticated()

                        // feed
                        .requestMatchers("/feed/create").authenticated()
                        .requestMatchers("/feed/get-list/").permitAll()
                        .requestMatchers("/feed/get-detail/{post-id}").authenticated()
                        .requestMatchers("/feed/update/{post-id}").hasAnyRole("USER", "ADMIN")
                        .requestMatchers("/feed/delete/{post-id}").hasAnyRole("USER", "ADMIN")
                                       
                        // comments
                        .requestMatchers("/comment/create").authenticated()
                        .requestMatchers("/comment/update/{comment-id}").authenticated()
                        .requestMatchers("comment/delete/{comment-id}").authenticated()

                        .anyRequest().permitAll()
                )
                .addFilterBefore(new JwtAuthenticationFilter(jwtTokenProvider),
                        UsernamePasswordAuthenticationFilter.class);
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
package com.example.pudingbe.user.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 30)
    private String name;

    @Column(nullable = false, length = 50)
    private String password;

    @Column(nullable = false)
    private Long brith;

    @Column(nullable = false)
    private Long batch;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING) //DB에 문자열로 저장
    private Gender gender;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role;

    public User(String name, String password, Long brith, Long batch, Gender gender) {
        this.name = name;
        this.password = password;
        this.brith = brith;
        this.batch = batch;
        this.gender = gender;
    }
}

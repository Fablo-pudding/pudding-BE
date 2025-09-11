package com.example.pudingbe.user.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Getter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 30)
    private String name;

    @Column(nullable = false, length = 50)
    private String password;

    @Column(nullable = false, length = 8)
    private Long brith;

    @Column(nullable = false, length = 3)
    private Long batch;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING) //DB에 문자열로 저장
    private Gender gender;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role;

    @Builder
    public User(String name, String password, Long brith, Long batch, Gender gender) {
        this.name = name;
        this.password = password;
        this.brith = brith;
        this.batch = batch;
        this.gender = gender;
    }
}

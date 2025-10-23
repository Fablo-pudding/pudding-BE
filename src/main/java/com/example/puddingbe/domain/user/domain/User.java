package com.example.puddingbe.domain.user.domain;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "tbl_user")
@AllArgsConstructor
@Builder
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 30)
    private String name;

    @Column(nullable = false, length = 225)
    private String password;

    @Column(nullable = false)
    private Long birth;

    @Column(nullable = false)
    private Long batch;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING) //DB에 문자열로 저장
    private Gender gender;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role = Role.USER;

    public User(String name, String password, Long birth, Long batch, Gender gender, Role role) {
        this.name = name;
        this.password = password;
        this.birth = birth;
        this.batch = batch;
        this.gender = gender;
        this.role = role;
    }
}

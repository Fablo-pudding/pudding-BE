package com.example.puddingbe.domain.user.domain;

import com.example.puddingbe.domain.refrigerator.domain.entity.Ingredient;
import com.example.puddingbe.domain.refrigerator.domain.entity.Pudding;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
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
    @Column(name = "user_id")
    private Long id;

    @Column(unique = true, nullable = false, length = 30)
    private String name;

    @Column(nullable = false, length = 225)
    private String password;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role = Role.USER;

    @NotNull
    private String image;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Ingredient ingredient;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Pudding pudding;

    private String profileImageUrl;

    public User(String name, String password,Role role) {
        this.name = name;
        this.password = password;
        this.role = role;
    }

    public void updateProfileImage(String url) {
        this.profileImageUrl = url;
    }
}

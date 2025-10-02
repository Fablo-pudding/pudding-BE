package com.example.puddingbe.global.detail;

import com.example.puddingbe.domain.user.domain.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Collection;
import java.util.List;

public class UserDetail implements UserDetails { // 로그인 과정에서 검증을 위함.
    private final User user;

    public UserDetail(final User user) {
        this.user = user;
    }

    public Long getId() {
        return user.getId();
    }

    @Override
    public String getUsername() {
        return user.getName();
    } //로그인에 사용되는 값

    @Override
    public String getPassword() {
        return user.getPassword();
    } // 로그인에 사용되는 암호화된 비밀번호

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_" + user.getRole().name().toUpperCase()));
    }

    @Override // 아래는 UserDetails 구조상 필요하지만 JWT를 쓴다면 전혀 필요없음.
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}

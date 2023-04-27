package com.codingfist.burninghouseauth.domain.user.domain;

import com.codingfist.burninghouseauth.domain.auth.dto.request.UserRegisterCommand;

import globalCommon.domain.BaseTimeEntity;

import jakarta.persistence.*;
import lombok.*;


import java.util.ArrayList;
import java.util.List;


@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Entity
@Builder
@Getter
@Table(name = "user")
public class User extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy  = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;


    @ElementCollection(fetch = FetchType.EAGER)
    @JoinTable(name = "user_roles")
    @Builder.Default
    private final List<String> roles = new ArrayList<>();

//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return this.roles.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList());
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return false;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return false;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return false;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return false;
//    }

    public static User create(UserRegisterCommand registerCommand) {
        return User.builder()
                .username(registerCommand.getUsername())
                .password(registerCommand.getPassword())
                .build();
    }

    public void addUserRole() {
        this.roles.add("ROLE_USER");

    }
}

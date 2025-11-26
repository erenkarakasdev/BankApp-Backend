package com.app.bankappbackend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

@Data
@Entity
@Table(name = "users")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long userId;

    private String name;

    @Column(name = "username",length = 10,nullable = false)
    String username;

    @Column(name = "password",length = 10,nullable = false)
    String password;

    @Column(name = "firstName",length = 10,nullable = false)
    String firstName;

    @Column(name = "lastName",length = 10,nullable = false)
    String lastName;

    @Column(name = "String identificationNumber",length = 11,nullable = false)
    String identificationNumber;

    @Column(name = "createdUser",nullable = false)
    LocalDateTime createdUser;

    @Enumerated(EnumType.STRING)
    UserStatus userStatus;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Tek olan rolü Listeye çevirip Spring'e veriyoruz
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @JoinTable(name = "authorities", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "role", nullable = false)
    @Enumerated(EnumType.STRING)
    private Role authority;

    @Override
    public String getPassword() {
        return password; // Kendi şifre alanınızı döndürün
    }

    @Override
    public String getUsername() {
        return username; // Kendi kullanıcı adı alanınızı döndürün
    }

    @Override
    public boolean isAccountNonExpired() {
        return true; // Hesap süresi dolmadı
    }

    @Override
    public boolean isAccountNonLocked() {
        return true; // Hesap kilitli değil
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; // Şifre süresi dolmadı
    }

    @Override
    public boolean isEnabled() {
        return true; // Hesap aktif
    }





}

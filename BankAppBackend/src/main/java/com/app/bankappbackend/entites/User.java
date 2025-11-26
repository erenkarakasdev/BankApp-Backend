package com.app.bankappbackend.entites;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDateTime;
import java.util.Set;

@Data
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long userId;

    @Column(name = "phoneNumber",length = 10,nullable = false)
    String phoneNumber;

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

    private boolean accountNonExpired;
    private boolean isEnabled;
    private boolean accountNonLocked;
    private boolean credentialsNonExpired;


    @JoinTable(name = "authorities", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "role", nullable = false)
    @Enumerated(EnumType.STRING)
    private Role authority;


}

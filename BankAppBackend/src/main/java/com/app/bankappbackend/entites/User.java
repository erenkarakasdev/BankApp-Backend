package com.app.bankappbackend.entites;

import com.app.bankappbackend.enums.UserStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
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


}

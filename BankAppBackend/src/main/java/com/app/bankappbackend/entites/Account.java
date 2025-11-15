package com.app.bankappbackend.entites;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long accountId;

    @Column(name = "userID",unique = true)
    @ManyToOne(fetch = FetchType.LAZY)
    User userId;

    @Column(name = "accountNumber",unique = true,nullable = false)
    String AccountNumber;

    @Column(name = "balance")
    BigDecimal balance;

    @Column(name = "iban",unique = true,nullable = false)
    String iban;

    @Column(name = "createdAccount")
    LocalDateTime createdAccount;


}

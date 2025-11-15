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
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long transactionId;

    @ManyToOne
    @Column(name = "sourceAccount")
    Account sourceAccount;

    @ManyToOne
    @Column(name = "destinationAccount")
    Account destinationAccount;

    @Column(name = "description")
    String description;

    @Column(name = "transactionDate")
    LocalDateTime transactionDate;

    @Column(name = "amount")
    BigDecimal amount;
}

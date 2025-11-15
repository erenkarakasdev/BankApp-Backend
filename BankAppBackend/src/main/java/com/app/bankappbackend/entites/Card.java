package com.app.bankappbackend.entites;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long cardId;

    @ManyToOne(fetch = FetchType.LAZY)
    Account account;

    @Column(name = "cardNumber",unique = true,nullable = false)
    String cardNumber;

    @Column(name = "createdCard")
    LocalDateTime createdCard;


}

package com.app.bankappbackend.repository;

import com.app.bankappbackend.entities.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<Card, Long> {
}

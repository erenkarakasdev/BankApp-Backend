package com.app.bankappbackend.repository;

import com.app.bankappbackend.entites.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account,Long> {

    Optional<Account> findByIban(String ibanNumber);

    Optional<Account> findByBalance(BigDecimal balance);
}

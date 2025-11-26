package com.app.bankappbackend.controller;

import com.app.bankappbackend.entities.Account;
import com.app.bankappbackend.services.AccountService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/account")
public class AccountController {
    /**
     * AccountService Injection.
     */
    @Autowired
    AccountService accountService;

    /**
     * Handles the HTTP GET request to fetch all accounts from the system.
     */
    @GetMapping
    public List<Account> getAllAccounts() {
        return accountService.getAllAccounts();
    }

    /**
     * Handles the HTTP POST request to create  new account, iban.
     */
    @PostMapping
    public Account createAccount(@RequestBody Account newAccount) {
        return accountService.createAccount(newAccount);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAccount(@PathVariable Long id) {
        accountService.deleteAccount(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Account> getAccountById(@PathVariable long id) {

        Optional<Account> AccountID = accountService.getAccountById(id);
        return AccountID.map(ResponseEntity::ok)
                .orElseThrow(() -> new EntityNotFoundException("User not found for ID " + id));
    }


}

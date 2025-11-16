package com.app.bankappbackend.controller;

import com.app.bankappbackend.entites.Account;
import com.app.bankappbackend.entites.User;
import com.app.bankappbackend.services.AccountService;
import com.app.bankappbackend.services.IbanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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


}

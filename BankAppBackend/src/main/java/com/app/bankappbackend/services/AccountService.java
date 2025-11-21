package com.app.bankappbackend.services;

import com.app.bankappbackend.entites.Account;
import com.app.bankappbackend.entites.User;
import com.app.bankappbackend.exceptions.AccountNotFoundException;
import com.app.bankappbackend.repository.AccountRepository;
import com.app.bankappbackend.repository.UserRepository;
import org.iban4j.CountryCode;
import org.iban4j.Iban;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService {
    /**
     * AccountRepository Injection.
     */
    @Autowired
    AccountRepository accountRepository;

    /**
     * IbanService Injection.
     */
    @Autowired
    IbanService ibanService;


    /**
     * Provides the business logic to fetch a comprehensive list of all accounts.
     */
    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    /**
     * Creates a new account, assigns a random IBAN, and persists it.
     */
    public Account createAccount(Account newAccount) {

        String randomIban = ibanService.generateRandomTurkishIbanAsString();
        newAccount.setIban(randomIban);

        return accountRepository.save(newAccount);
    }

    public void deleteAccount(Long id) {
        Account account = accountRepository.findById(id).orElseThrow(() -> new AccountNotFoundException("Kullanıcı hesabı bulunamadı."));
        accountRepository.delete(account);
    }

    public Optional<Account> getAccountById(Long id) {
        return accountRepository.findById(id);
    }





}

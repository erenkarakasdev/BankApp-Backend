package com.app.bankappbackend.services;

import com.app.bankappbackend.dto.DepositRequest;
import com.app.bankappbackend.dto.TransferRequest;
import com.app.bankappbackend.entities.Account;
import com.app.bankappbackend.entities.Transaction;
import com.app.bankappbackend.exceptions.AccountNotFoundException;
import com.app.bankappbackend.exceptions.InvalidDepositException;
import com.app.bankappbackend.exceptions.InvalidTransferException;
import com.app.bankappbackend.repository.AccountRepository;
import com.app.bankappbackend.repository.TransactionRepository;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
public class TransactionService {
    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    AccountRepository accountRepository;

    @Transactional()
    public Transaction createRequestInTransaction(TransferRequest transferRequest) {

        if (transferRequest.getAmount().compareTo(BigDecimal.ZERO) <= 0) {
            throw new InvalidTransferException("Transfer tutarı sıfır veya negatif olamaz.");
        }

        Account sourceAccount = accountRepository.findByIban(transferRequest.getSourceIban())
                .orElseThrow(() -> new AccountNotFoundException("Kaynak hesap bulunamadı: " + transferRequest.getSourceIban()));

        Account destinationAccount = accountRepository.findByIban(transferRequest.getTargetIban())
                .orElseThrow(() -> new AccountNotFoundException("Hedef hesap bulunamadı: " + transferRequest.getTargetIban()));


        //Kaynak hesabın para miktarını güncelle.
        sourceAccount.setBalance(sourceAccount.getBalance().subtract(transferRequest.getAmount()));

        //Giden hesabın para miktarını güncelle.
        destinationAccount.setBalance(destinationAccount.getBalance().add(transferRequest.getAmount()));

        accountRepository.save(sourceAccount);
        accountRepository.save(destinationAccount);

        //İşlem kayıdı.
        Transaction transactionRecord = new Transaction();
        transactionRecord.setSourceAccount(String.valueOf(sourceAccount));
        transactionRecord.setTargetAccount(String.valueOf(destinationAccount));
        transactionRecord.setTransactionDate(LocalDateTime.now());

        return transactionRepository.save(transactionRecord);
    }


    @Transactional()
    public Transaction createRequestInDepositMoney(DepositRequest depositMoneyRequest) {
        if (depositMoneyRequest.getAmount().compareTo(BigDecimal.ZERO) <= 0) {
            throw new InvalidDepositException("Yatırma işlemi sıfır veya negatif olamaz.");
        }

        Account sourceAccount = accountRepository.findByIban(depositMoneyRequest.getSourceIban())
                .orElseThrow(() -> new InvalidDepositException("Kaynak hesap bulunamadı: " + depositMoneyRequest.getSourceIban()));

        //Hesabın şuanki para miktarı
        BigDecimal currentBalance = sourceAccount.getBalance();

        //hesap miktarını güncellemek için.
        BigDecimal newBalance = currentBalance.add(depositMoneyRequest.getAmount());

        //para yatırma işlemi log
        Transaction transactionRecord = new Transaction();
        transactionRecord.setSourceAccount(String.valueOf(sourceAccount));
        transactionRecord.setTransactionDate(LocalDateTime.now());

        return transactionRepository.save(transactionRecord);
    }
}

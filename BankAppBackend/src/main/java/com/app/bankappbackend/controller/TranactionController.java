package com.app.bankappbackend.controller;

import com.app.bankappbackend.dto.DepositRequest;
import com.app.bankappbackend.dto.TransferRequest;
import com.app.bankappbackend.entites.Account;
import com.app.bankappbackend.entites.Transaction;
import com.app.bankappbackend.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transaciton")
public class TranactionController {

    @Autowired
    TransactionService transactionService;

    //Hesaplar arası tansfer işlemi için.
    @PostMapping("/transfer")
    public ResponseEntity<Transaction> createRequestInTransaction(@RequestBody TransferRequest transferRequest) {
        Transaction createdRequest = transactionService.createRequestInTransaction(transferRequest);
        return ResponseEntity.ok(createdRequest);
    }

    //ATM'den para yatırma işlemi için.
    @PostMapping("/depositMoney")
    public ResponseEntity<Transaction> depositMoney(@RequestBody DepositRequest depositRequest) {
        Transaction createdDepositMoney = transactionService.createRequestInDepositMoney(depositRequest);
        return ResponseEntity.ok(createdDepositMoney);
    }
}

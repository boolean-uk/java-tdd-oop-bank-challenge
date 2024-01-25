package com.booleanuk.core.models;

import com.booleanuk.core.enums.TransactionType;
import com.booleanuk.core.models.accounts.Account;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class Transaction {
    private final Account account;
    private final int newBalance;
    private final int amount;
    private final TransactionType transactionType;
    private final LocalDateTime dateTime;

    public Transaction(Account account, int newBalance, int amount, TransactionType transactionType) {
        this.dateTime = LocalDateTime.now();
        this.newBalance = newBalance;
        this.account = account;
        this.amount = amount;
        this.transactionType = transactionType;
    }

    public int getOldBalance() {
        if (transactionType == TransactionType.DEPOSIT) {
            return newBalance - amount;
        }
        return newBalance + amount;
    }
}

package com.booleanuk.core.Accounts;

import com.booleanuk.core.Bank.Transaction;
import com.booleanuk.core.BaseEntity;


import com.booleanuk.core.Enums.Branches;
import com.booleanuk.core.Enums.TransactionType;
import com.booleanuk.core.Users.User;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
@Getter
@Setter

public abstract class Account extends BaseEntity {
    private BigDecimal balance;
    private List<Transaction> transactions;
    // A Set maybe?

    private User accountHolder;
    private Branches branch;
    private boolean canRequestOverdraft;


    public Account(BigDecimal initialBalance, Branches branch, User accountHolder) {
        this.transactions = new ArrayList<>();
        this.depositFunds(initialBalance);
        this.branch = branch;
        this.accountHolder = accountHolder;
    }

    public Account(User accountHolder, Branches branch) {
        this.transactions = new ArrayList<>();
        this.accountHolder = accountHolder;
        this.branch = branch;
        this.setBalance(BigDecimal.ZERO);
    }

    public Transaction depositFunds(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Amount must be positive for deposit.");
        }

        Transaction depositTransaction = new Transaction(TransactionType.DEPOSIT, amount);
        transactions.add(depositTransaction);

        this.setBalance(this.getBalance().add(amount));

        return depositTransaction;
    }
    public Transaction withdrawFunds(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Amount must be positive for withdrawal.");
        }

        if (amount.compareTo(this.getBalance()) > 0) {
            throw new IllegalArgumentException("Insufficient balance for withdrawal.");
        }

        Transaction withdrawTransaction = new Transaction(TransactionType.WITHDRAW, amount);
        transactions.add(withdrawTransaction);

        this.setBalance(this.getBalance().subtract(amount));

        return withdrawTransaction;
    }

    public BigDecimal getBalance() {
        BigDecimal balance = BigDecimal.ZERO;

        for (Transaction transaction : transactions) {
            if (transaction.getType() == TransactionType.DEPOSIT) {
                balance = balance.add(transaction.getAmount());
            } else if (transaction.getType() == TransactionType.WITHDRAW) {
                balance = balance.subtract(transaction.getAmount());
            }
        }

        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}

package com.booleanuk.core.Accounts;

import com.booleanuk.core.Bank.Transaction;
import com.booleanuk.core.BaseEntity;


import com.booleanuk.core.Enums.Branches;
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


    public Account(BigDecimal balance, Branches branch, User accountHolder) {
        this.setBalance(balance);
        this.transactions = new ArrayList<>();
        this.branch = branch;
        this.accountHolder = accountHolder;
    }


    public Transaction depositFunds(BigDecimal amount) {
        Transaction transaction = new Transaction();
        return transaction;
    }
    public Transaction withdrawFunds(BigDecimal amount) {
        Transaction transaction = new Transaction();
        return transaction;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}

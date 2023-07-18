package com.booleanuk.core;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public abstract class Account {
    protected BigDecimal balance;
    protected List<Transaction> transactions;

    public Account(){
        this.balance = BigDecimal.ZERO;
        this.transactions = new ArrayList<>();
    }
    public BigDecimal getBalance(){
        return balance;
    }
    public List<Transaction> getTransactions(){
        return transactions;
    }
    public abstract void deposit(BigDecimal amount);

    public abstract void withdraw(BigDecimal amount);
}

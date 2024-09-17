package com.booleanuk.core;

import java.util.ArrayList;
import java.util.List;

public class BankAccount {
    protected final List<Transaction> transactions;

    public BankAccount() {
        this.transactions = new ArrayList<>();
    }

    public boolean deposit(int amount) {
        if (amount <= 0)
            return false;

        transactions.add(new Transaction(amount, true));
        return true;
    }

    public boolean withdraw(int amount) {
        if (amount <= 0 || getCurrentBalance() - amount < 0)
            return false;

        transactions.add(new Transaction(amount, false));
        return true;
    }

    protected int getCurrentBalance() {
        return transactions.stream()
                .map(t -> t.isDeposit() ? t.getAmount() : -t.getAmount())
                .reduce(Integer::sum)
                .orElse(0);
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void clearAccount() {
        transactions.clear();
    }
}

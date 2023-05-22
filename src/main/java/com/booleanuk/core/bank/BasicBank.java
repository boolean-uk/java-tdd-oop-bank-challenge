package com.booleanuk.core.bank;

import com.booleanuk.core.account.BankAccount;

import java.util.ArrayList;
import java.util.List;

public class BasicBank implements Bank {
    private final double maxOverdraft;
    private final String location;
    private final List<BankAccount> accounts;

    public BasicBank(String location, double maxOverdraft) {
        this.location = location;
        this.maxOverdraft = maxOverdraft;
        this.accounts = new ArrayList<>();
    }

    @Override
    public String location() {
        return this.location;
    }

    @Override
    public void add(BankAccount bankAccount) {
        bankAccount.associateTo(this);
        this.accounts.add(bankAccount);
    }

    @Override
    public boolean requestOverdraft(BankAccount bankAccount, int amount) {
        if (amount > maxOverdraft) return false;

        return bankAccount.deserveOverdraft(amount);
    }
}

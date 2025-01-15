package com.booleanuk.core;

import java.util.UUID;

public class Account {

    private UUID id;
    private float balance = 0F;
    private AccountType accountType;

    public Account(AccountType accountType) {
        this.id = UUID.randomUUID();
        this.accountType = accountType;
    }

    public boolean deposit(float amount) {
        if(amount <= 0F) {
            System.out.println("Deposit amount must be above £0.");
            return false;
        }
        this.balance += amount;
        return true;
    }

    public boolean withdraw(float amount) {
        if(balance < amount) {
            System.out.println("Insufficient funds. Withdrawal denied.");
            return false;
        }
        balance -= amount;
        return true;
    }

    public UUID getID() {
        return id;
    }

    public float getBalance() {
        return balance;
    }

    public AccountType getAccountType() {
        return accountType;
    }
}

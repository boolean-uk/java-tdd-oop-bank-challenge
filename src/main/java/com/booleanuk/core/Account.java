package com.booleanuk.core;

import java.util.ArrayList;
import java.util.UUID;

public class Account {

    private UUID id;
    private AccountType accountType;
    private ArrayList<Transaction> transactions;
    private float overdraft;

    public Account(AccountType accountType) {
        this.id = UUID.randomUUID();
        this.accountType = accountType;
        transactions = new ArrayList<>();
        overdraft = 0F;
    }

    public boolean deposit(float amount) {
        if(amount <= 0F) {
            System.out.println("Deposit amount must be above £0.");
            return false;
        }
        transactions.add(new Transaction(this.getID(), amount));
        return true;
    }

    public boolean withdraw(float amount) {
        if(getBalance() < amount) {
            System.out.println("Insufficient funds. Withdrawal denied.");
            return false;
        }
        transactions.add(new Transaction(this.getID(), amount * -1));
        return true;
    }

    public UUID getID() {
        return id;
    }

    public float getBalance() {
        float balance = 0F;
        for (Transaction t : this.transactions) {
            balance += t.getAmount();
        }
        return balance;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public float getOverdraft() {
        return this.overdraft;
    }

    public void setOverdraft(float overdraft) {
        this.overdraft = overdraft;
    }
}

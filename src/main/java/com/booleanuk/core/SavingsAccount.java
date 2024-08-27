package com.booleanuk.core;

import java.util.ArrayList;

public class SavingsAccount extends Account{

    public SavingsAccount(int id, String branch) {
        this.setId(id);
        this.setType("Saving");
        this.setBranch(branch);
        this.setTransactions(new ArrayList<>());
        this.setInterest(5);
    }

    @Override
    public boolean deposit(int amount) {
        if (amount < 1) {
            System.out.println("Amount must be positive.");
            return false;
        }
        Transaction transaction = new Transaction(amount*(100 + this.getInterest())/100);
        this.getTransactions().add(transaction);
        return true;
    }
}

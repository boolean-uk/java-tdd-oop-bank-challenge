package com.booleanuk.core;

import java.util.ArrayList;

public class CurrentAccount extends Account{

    public CurrentAccount(int id, String branch, Bank bank) {
        this.setId(id);
        this.setType("Saving");
        this.setBranch(branch);
        this.setTransactions(new ArrayList<>());
        this.setBank(bank);
    }

    @Override
    public boolean withdraw(int amount) {
        if (amount < 1) {
            System.out.println("Amount must be positive.");
            return false;
        }
        if (this.calcCurrentAmount() - amount < -(this.getBank().calculateOverdraft())){
            System.out.println("The bank denies that large of an overdraft.");
            return false;
        }
        Transaction transaction = new Transaction(-amount);

        this.getTransactions().add(transaction);
        return true;
    }
}

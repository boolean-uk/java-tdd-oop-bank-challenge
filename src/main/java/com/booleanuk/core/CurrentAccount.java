package com.booleanuk.core;

public class CurrentAccount extends Account{

    CurrentAccount(String accountNumber, Branch branch) {
        super(accountNumber, branch);
    }

    @Override
    public void deposit(int amount) {
        this.addTransaction(amount, true);
    }

    @Override
    public void withdraw(int amount) {
        if(amount <= getBalance()) {
            this.addTransaction(amount, false);
        } else System.out.println("You don't have enough balance");
    }

    public boolean requestOverDraft(Manager manager, int amount) {
        return manager.approveOverDraft(this, amount);

    }

}

package com.booleanuk.core;

public class CurrentAccount extends Account {

    private double overdraftLimit;

    public CurrentAccount() {
        super();
    }

    public CurrentAccount(String accountNumber) {
        super(accountNumber);
    }

    public CurrentAccount(String accountNumber, double balance) {
        super(accountNumber, balance);
    }

    public void setOverdraftLimit(double overdraftLimit) {
        this.overdraftLimit = overdraftLimit;
    }

    public double getOverdraftLimit() {
        return overdraftLimit;
    }

    @Override
    public void withdraw(double amount) {
        if (getBalance() + overdraftLimit >= amount) {
            setBalance(getBalance() - amount);
        }
    }

}

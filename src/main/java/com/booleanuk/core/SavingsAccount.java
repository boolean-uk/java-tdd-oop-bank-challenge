package com.booleanuk.core;

public class SavingsAccount extends BankAccount {
    public SavingsAccount(String accountNumber, int accountHolderID) {
        super(accountNumber, accountHolderID);
    }

    @Override
    public String toString() {
        return "SavingsAccount{" +
                "balance=" + balance +
                ", accountNumber='" + accountNumber + '\'' +
                ", accountHolderID=" + accountHolderID +
                '}';
    }
}

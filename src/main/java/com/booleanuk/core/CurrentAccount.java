package com.booleanuk.core;

public class CurrentAccount extends BankAccount {
    public CurrentAccount(String accountNumber, int accountHolderID) {
        super(accountNumber, accountHolderID);
    }

    @Override
    public String toString() {
        return "CurrentAccount{" +
                "balance=" + balance +
                ", accountNumber='" + accountNumber + '\'' +
                ", accountHolderID=" + accountHolderID +
                '}';
    }
}

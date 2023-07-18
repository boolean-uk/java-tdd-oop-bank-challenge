package com.booleanuk.core;

public class CurrentAccount extends BankAccount {
    public CurrentAccount(String accountNumber, int accountHolderID, String branchCode) {
        super(accountNumber, accountHolderID, branchCode);
    }

    @Override
    public String toString() {
        return "CurrentAccount{" +
                "balance=" + getBalance() +
                ", accountNumber='" + accountNumber + '\'' +
                ", accountHolderID=" + accountHolderID +
                '}';
    }
}

package com.booleanuk.core;

public class SavingsAccount extends BankAccount {
    public SavingsAccount(String accountNumber, int accountHolderID, String branchCode) {
        super(accountNumber, accountHolderID, branchCode);
    }

    @Override
    public String toString() {
        return "SavingsAccount{" +
                "balance=" + getBalance() +
                ", accountNumber='" + accountNumber + '\'' +
                ", accountHolderID=" + accountHolderID +
                '}';
    }
}

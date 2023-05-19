package com.booleanuk.core;

public class Account {
    String accountNumber, accountHolderFirstName, accountHolderLastName, branchCode;
    int balanceInCents = 0;

    public Account(String accountNumber, String accountHolderFirstName, String accountHolderLastName, String branchCode) {
        this.accountNumber = accountNumber;
        this.accountHolderFirstName = accountHolderFirstName;
        this.accountHolderLastName = accountHolderLastName;
        this.branchCode = branchCode;
    }



}

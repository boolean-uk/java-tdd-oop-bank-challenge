package com.booleanuk.core.bank;

public abstract class Account {

    private String accountNumber;

    protected Account(String accNumber) {
        this.accountNumber = accNumber;
    }

    public Account() {

    }

    public String getAccountNumber() {
        return this.accountNumber;
    }

    protected void setAccountNumber(String accNumber) {
        this.accountNumber = accNumber;
    }

}

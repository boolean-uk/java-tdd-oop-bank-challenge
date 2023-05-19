package com.booleanuk.core;

public class Account {
    private String accountNumber;
    private String accountHolderFirstName;
    private String accountHolderLastName;
    private String branchCode;
    private int balanceInCents = 0;

    public Account(String accountNumber, String accountHolderFirstName, String accountHolderLastName, String branchCode) {
        this.setAccountNumber(accountNumber);
        this.setAccountHolderFirstName(accountHolderFirstName);
        this.setAccountHolderLastName(accountHolderLastName);
        this.setBranchCode(branchCode);
    }


    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountHolderFirstName() {
        return accountHolderFirstName;
    }

    public void setAccountHolderFirstName(String accountHolderFirstName) {
        this.accountHolderFirstName = accountHolderFirstName;
    }

    public String getAccountHolderLastName() {
        return accountHolderLastName;
    }

    public void setAccountHolderLastName(String accountHolderLastName) {
        this.accountHolderLastName = accountHolderLastName;
    }

    public String getBranchCode() {
        return branchCode;
    }

    public void setBranchCode(String branchCode) {
        this.branchCode = branchCode;
    }

    public int getBalanceInCents() {
        return balanceInCents;
    }

    public void setBalanceInCents(int balanceInCents) {
        this.balanceInCents = balanceInCents;
    }
}

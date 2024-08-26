package com.booleanuk.core.bank;

public abstract class Account {

    public static enum Branch {
        GOTHENBURG,
        STOCKHOLM,
        LUND,
        KARLSTAD
    }

    private Branch branch;
    private String accountNumber;

    protected Account(String accNumber, Branch branch) {
        this.accountNumber = accNumber;
        this.branch = branch;
    }

    public Account() {

    }

    public String getAccountNumber() {
        return this.accountNumber;
    }

    protected void setAccountNumber(String accNumber) {
        this.accountNumber = accNumber;
    }

    public Branch getBranch() {
        return this.branch;
    }

}

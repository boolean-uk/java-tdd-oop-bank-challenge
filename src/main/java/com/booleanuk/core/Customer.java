package com.booleanuk.core;

public class Customer {

    private String fullName;
    private NormalAccount normalAccount;
    private SavingsAccount savingsAccount;
    public Customer(String fullName, NormalAccount normalAccount, SavingsAccount savingsAccount) {
        this.fullName = fullName;
        this.normalAccount = normalAccount;
        this.savingsAccount = savingsAccount;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public NormalAccount getNormalAccount() {
        return normalAccount;
    }

    public void setNormalAccount(NormalAccount normalAccount) {
        this.normalAccount = normalAccount;
    }

    public SavingsAccount getSavingsAccount() {
        return savingsAccount;
    }

    public void setSavingsAccount(SavingsAccount savingsAccount) {
        this.savingsAccount = savingsAccount;
    }
}
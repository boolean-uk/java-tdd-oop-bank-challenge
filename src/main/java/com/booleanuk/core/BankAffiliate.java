package com.booleanuk.core;

public class BankAffiliate {

    private String fullName;

    private String affiliation;

    private BankAccount bankAccount;

    public BankAffiliate(String fullName, String affiliation, BankAccount bankAccount) {
        this.fullName = fullName;
        this.affiliation = affiliation;
        this.bankAccount = bankAccount;
    }

    public boolean createCurrentAccount(BankAccount bankAccount) {
        if(!bankAccount.getAccountType().contains("Current Account")
            || bankAccount.getAccountType().isEmpty()) {
            this.bankAccount.setAccountType("Current Account");
            return true;
        }
        return false;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAffiliation() {
        return affiliation;
    }

    public void setAffiliation(String affiliation) {
        this.affiliation = affiliation;
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }
}

package com.booleanuk.core;

public class BankAffiliate {

    private String fullName;

    private String affiliation;

    private BankAccount account;

    public BankAffiliate(String fullName, String affiliation, BankAccount account) {
        this.fullName = fullName;
        this.affiliation = affiliation;
        this.account = account;
    }

    public boolean createCurrentAccount(BankAccount bankAccount) {
        if(!bankAccount.getAccountType().contains("Current")
            || bankAccount.getAccountType().isEmpty()) {
            this.account.setAccountType("Current");
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

    public BankAccount getAccount() {
        return account;
    }

    public void setAccount(BankAccount account) {
        this.account = account;
    }
}

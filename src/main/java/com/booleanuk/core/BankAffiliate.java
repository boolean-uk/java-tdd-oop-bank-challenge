package com.booleanuk.core;

public class BankAffiliate {

    String fullName;

    String affiliation;

    BankAccount account;

    public BankAffiliate(String fullName, String affiliation, BankAccount account) {
        this.fullName = fullName;
        this.affiliation = affiliation;
        this.account = account;
    }

    public boolean createCurrentAccount(BankAccount bankAccount) {
        return true;
    }
}

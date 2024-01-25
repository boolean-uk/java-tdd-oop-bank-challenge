package com.booleanuk.core;

import java.util.ArrayList;

public class BankAffiliate {

    private String fullName;

    private String affiliation;

    private ArrayList<BankAccount> bankAccountList;

    public BankAffiliate(String fullName, String affiliation) {
        this.fullName = fullName;
        this.affiliation = affiliation;
    }

    public BankAffiliate(String fullName, String affiliation, ArrayList<BankAccount> bankAccountList) {
        this.fullName = fullName;
        this.affiliation = affiliation;
        this.bankAccountList = bankAccountList;
    }

    public boolean createCurrentAccount(BankAccount currentBankAccount) {
        if(!this.bankAccountList.contains(currentBankAccount)) {
            this.bankAccountList.add(currentBankAccount);
            return true;
        }
        return false;
    }

    public boolean createSavingsAccount(BankAccount savingsBankAccount) {
        if(!this.bankAccountList.contains(savingsBankAccount)) {
            this.bankAccountList.add(savingsBankAccount);
            return true;
        }
        return false;
    }

    public double withdrawFunds(BankAccount bankAccount, double amount) {
        return 400;
    }

    public double depositFunds(BankAccount bankAccount, double amount) {
        return 600;
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

    public ArrayList<BankAccount> getBankAccountList() {
        return bankAccountList;
    }

    public void setBankAccountList(ArrayList<BankAccount> bankAccountList) {
        this.bankAccountList = bankAccountList;
    }
}

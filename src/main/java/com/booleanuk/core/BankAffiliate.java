package com.booleanuk.core;

import java.time.LocalDate;
import java.util.ArrayList;

public class BankAffiliate {

    private String fullName;

    private String affiliation;

    private ArrayList<BankAccount> bankAccountList;

    private ArrayList<Transaction> transactionList;


    public BankAffiliate() {
        transactionList = new ArrayList<>();
    }

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

    public double depositFunds(BankAccount bankAccount, double amount) {
        double balance = bankAccount.getBalance() + amount;
        bankAccount.setBalance(balance);

        LocalDate currentDate = LocalDate.now();
        Transaction transaction = new Transaction("Deposit", amount, currentDate, balance);
        bankAccount.getTransactionList().add(transaction);

        return balance;
    }

    public double withdrawFunds(BankAccount bankAccount, double amount) {
        double balance = bankAccount.getBalance() - amount;
        bankAccount.setBalance(balance);

        LocalDate currentDate = LocalDate.now();
        Transaction transaction = new Transaction("Withdrawal", amount, currentDate, balance);
        bankAccount.getTransactionList().add(transaction);

        return balance;
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

    public ArrayList<Transaction> getTransactionList() {
        return transactionList;
    }

    public void setTransactionList(ArrayList<Transaction> transactionList) {
        this.transactionList = transactionList;
    }
}

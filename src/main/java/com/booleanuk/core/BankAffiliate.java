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

    /* Core user story 4
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
    } */

    //Extension user story 1 getBalance method updated
    public void depositFunds(BankAccount bankAccount, double amount) {
        LocalDate currentDate = LocalDate.now();
        // No need to calculate balance here, just record the transaction
        Transaction depositTransaction = new Transaction("Deposit", amount, currentDate, bankAccount.getBalance() + amount);
        bankAccount.getTransactionList().add(depositTransaction);
    }

    public void withdrawFunds(BankAccount bankAccount, double amount) {
        LocalDate currentDate = LocalDate.now();
        // No need to calculate balance here, just record the transaction
        Transaction withdrawalTransaction = new Transaction("Withdrawal", amount, currentDate, bankAccount.getBalance() - amount);
        bankAccount.getTransactionList().add(withdrawalTransaction);
    }



    //Extension User Story 4
    public boolean approveOverdraft(BankAccount account, double limit) {
        if (account.getBalance() >= 0) {
            account.requestOverdraft(limit);
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

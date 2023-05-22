package com.booleanuk.core;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;

public class Account {
    private String accountNumber;
    private String accountHolderFirstName;
    private String accountHolderLastName;
    private String branchCode;
    private int balanceInCents = 0;
    private boolean approvedForOverdraft = false;
    private LocalDateTime dateTime;
    private SortedMap<LocalDateTime, Integer> transactions;

    public Account(String accountNumber, String accountHolderFirstName, String accountHolderLastName, String branchCode) {
        this.setAccountNumber(accountNumber);
        this.setAccountHolderFirstName(accountHolderFirstName);
        this.setAccountHolderLastName(accountHolderLastName);
        this.setBranchCode(branchCode);
        this.setTransactions(new TreeMap<>());
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

    public void setBalanceInCents(double AmountInDollars) {
            this.balanceInCents += (int) (AmountInDollars * 100.0);
            this.setDateTime(LocalDateTime.now());
            this.getTransactions().put(this.getDateTime(), (int) (AmountInDollars * 100.0));
        try {
            TimeUnit.MILLISECONDS.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public double getBalanceInDollars() {
        return (getBalanceInCents() / 100.0);
    }

    public boolean isApprovedForOverdraft() {
        return approvedForOverdraft;
    }

    public void setApprovedForOverdraft(boolean approvedForOverdraft) {
        this.approvedForOverdraft = approvedForOverdraft;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public SortedMap<LocalDateTime, Integer> getTransactions() {
        return transactions;
    }

    public void setTransactions(SortedMap<LocalDateTime, Integer> transactions) {
        this.transactions = transactions;
    }
}

package com.booleanuk.core;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public abstract class Account {
    private static int ACCOUNT_ID = 0;

    private int id;
    private int monthlyTransactionLimit;
    private boolean canOverdraft;
    private float interest;
    private String branch;

    private List<Transaction> transactions;

    protected Account(String branch, BigDecimal initialBalance){
        this.id = ACCOUNT_ID++;
        this.branch = branch;
        this.transactions = new ArrayList<>();
        if(initialBalance.compareTo(BigDecimal.ZERO) > 0)
            transactions.add(new Transaction(initialBalance.doubleValue()));
    }

    protected Account(String branch, int monthlyTransactionLimit, boolean canOverdraft, float interest, BigDecimal initialBalance){
        this(branch, initialBalance);
        this.monthlyTransactionLimit = monthlyTransactionLimit;
        this.canOverdraft = canOverdraft;
        this.interest = interest;
    }

    public int getId(){
        return id;
    }
    public int getMonthlyTransactionLimit() {
        return monthlyTransactionLimit;
    }

    public void setMonthlyTransactionLimit(int monthlyTransactionLimit) {
        this.monthlyTransactionLimit = monthlyTransactionLimit;
    }

    public boolean isCanOverdraft() {
        return canOverdraft;
    }

    public void setCanOverdraft(boolean canOverdraft) {
        this.canOverdraft = canOverdraft;
    }

    public float getInterest() {
        return interest;
    }

    public void setInterest(float interest) {
        this.interest = interest;
    }

    public BigDecimal getBalance() {
        return transactions.size() > 0 ?
                BigDecimal.valueOf(transactions.stream().mapToDouble(transaction -> transaction.getAmount().doubleValue()).sum()) :
                BigDecimal.ZERO;

    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public boolean deposit(double amount){
        if(amount <= 0) return false;
        transactions.add(new Transaction(amount));

        return true;
    }
    public boolean deposit(LocalDateTime date, double amount){
        if(amount <= 0) return false;
        transactions.add(new Transaction(date, amount));

        return true;
    }

    public boolean withdraw(double amount){
        if(amount <= 0 || getBalance().compareTo(BigDecimal.valueOf(amount)) < 0) return false;
        transactions.add(new Transaction(-amount));

        return true;
    }

    public boolean withdraw(LocalDateTime date, double amount){
        if(amount <= 0 || getBalance().compareTo(BigDecimal.valueOf(amount)) < 0) return false;
        transactions.add(new Transaction(date, -amount));

        return true;
    }
}

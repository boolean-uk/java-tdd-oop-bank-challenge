package com.booleanuk.core;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public abstract class Account {

    private int monthlyTransactionLimit;
    private boolean canOverdraft;
    private float interest;
    protected BigDecimal balance;

    private List<Transaction> transactions;

    protected Account(BigDecimal balance) throws IllegalArgumentException{
        if(balance.signum() <= 0) throw new IllegalArgumentException("Initial Balance cannot be less than 0.");

        this.balance = balance;
        this.transactions = new ArrayList<>();
    }

    protected Account(int monthlyTransactionLimit, boolean canOverdraft, float interest, BigDecimal balance){
        this(balance);
        this.monthlyTransactionLimit = monthlyTransactionLimit;
        this.canOverdraft = canOverdraft;
        this.interest = interest;
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
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }
}

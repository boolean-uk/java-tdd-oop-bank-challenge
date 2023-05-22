package com.booleanuk.core;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public abstract class Account {

    private String id;
    private int monthlyTransactionLimit;
    private Bank.OverdraftStatus overdraftStatus;
    private float interest;
    private List<Transaction> transactions;

    protected Account(BigDecimal initialBalance){
        this.id = UUID.randomUUID().toString();
        this.overdraftStatus = Bank.OverdraftStatus.NONE;
        this.transactions = new ArrayList<>();
        if(initialBalance.compareTo(BigDecimal.ZERO) > 0)
            transactions.add(new Transaction(initialBalance.doubleValue()));
    }

    protected Account(int monthlyTransactionLimit, float interest, BigDecimal initialBalance){
        this(initialBalance);
        this.monthlyTransactionLimit = monthlyTransactionLimit;
        this.interest = interest;
    }

    public String getId(){
        return id;
    }
    public int getMonthlyTransactionLimit() {
        return monthlyTransactionLimit;
    }

    public void setMonthlyTransactionLimit(int monthlyTransactionLimit) {
        this.monthlyTransactionLimit = monthlyTransactionLimit;
    }

    public Bank.OverdraftStatus getOverdraftStatus() {
        return overdraftStatus;
    }

    protected void setOverdraftStatus(Bank.OverdraftStatus overdraftStatus) {
        this.overdraftStatus = overdraftStatus;
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
        if(amount <= 0 ) return false;
        if(getBalance().compareTo(BigDecimal.valueOf(amount)) < 0){
            if(!overdraftStatus.equals(Bank.OverdraftStatus.ACCEPTED)) return false;
        }

        transactions.add(new Transaction(-amount));
        return true;
    }

    public boolean withdraw(LocalDateTime date, double amount){
        if(amount <= 0 ) return false;
        if(getBalance().compareTo(BigDecimal.valueOf(amount)) < 0){
            if(!overdraftStatus.equals(Bank.OverdraftStatus.ACCEPTED)) return false;
        }

        transactions.add(new Transaction(date, -amount));
        return true;
    }


    public String getBankStatement(){
        return BankStatement.generate(transactions);
    }

}

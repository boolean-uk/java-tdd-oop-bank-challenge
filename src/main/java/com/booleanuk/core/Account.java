package com.booleanuk.core;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public abstract class Account {

    private String id;
    private int monthlyTransactionLimit;
    //private Bank.OverdraftStatus overdraftStatus;
    private  OverdraftRequest overdraftRequest;
    private float interest;
    private List<Transaction> transactions;

    protected Account(BigDecimal initialBalance){
        this.id = UUID.randomUUID().toString();
        this.transactions = new ArrayList<>();
        //this.overdraftStatus = Bank.OverdraftStatus.NONE;
        overdraftRequest = new OverdraftRequest(this, 0, getBalance().doubleValue());
        overdraftRequest.setStatus(Bank.OverdraftStatus.NONE);

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

//    public Bank.OverdraftStatus getOverdraftStatus() {
//        return overdraftStatus;
//    }

//    protected void setOverdraftStatus(Bank.OverdraftStatus overdraftStatus) {
//        this.overdraftStatus = overdraftStatus;
//    }

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

    protected OverdraftRequest getOverdraftRequest(){
        return overdraftRequest;
    }
    protected void setOverdraftRequest(OverdraftRequest overdraftRequest){
        this.overdraftRequest = overdraftRequest;
    }

    public boolean deposit(LocalDateTime date, double amount){
        if(amount <= 0) return false;
        if(monthlyTransactionLimit > 0 && transactions.size() >= monthlyTransactionLimit)
            return false;
        transactions.add(new Transaction(date, amount));

        return true;
    }
    public boolean deposit(double amount){
        return deposit(LocalDateTime.now(), amount);

    }


    public boolean withdraw(LocalDateTime date, double amount){
        if(amount <= 0 ) return false;

        if(monthlyTransactionLimit > 0 && transactions.size() >= monthlyTransactionLimit)
            return false;

        if(getBalance().compareTo(BigDecimal.valueOf(amount)) < 0){
            BigDecimal dif = getBalance().subtract(BigDecimal.valueOf(amount));
            if(dif.compareTo(overdraftRequest.getCalculatedAllowedDebt()) < 0)
                return false;
            if(!overdraftRequest.getStatus().equals(Bank.OverdraftStatus.ACCEPTED)) return false;

            transactions.add(new Transaction(date, -amount));

            if(getOverdraftRequest().getStatus().equals(Bank.OverdraftStatus.ACCEPTED))
                if(getBalance().compareTo(getOverdraftRequest().getCalculatedAllowedDebt()) == 0) overdraftRequest.setStatus(Bank.OverdraftStatus.NONE);

            return true;
        }

        transactions.add(new Transaction(date, -amount));
        return true;
    }

    public boolean withdraw(double amount){
        return withdraw(LocalDateTime.now(), amount);
    }


    public String getBankStatement(){
        return BankStatement.generate(transactions);
    }

    public abstract boolean requestOverdraft(double amount);
}

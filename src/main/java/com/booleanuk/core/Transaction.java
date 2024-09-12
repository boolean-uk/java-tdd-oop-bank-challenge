package com.booleanuk.core;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transaction {
    private double amount;
    private final BankAccount account;
    private String type;
    private final String date;
    private double balance;

    // Constructors
    public Transaction(String type, double amount, BankAccount account){
        setType(type);
        setAmount(amount);
        this.account = account;
        this.date = makeDateStamp();
        setBalance(account.getBalance());
        executeTransaction();
    }

    // Getters & Setters
    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDate(){
        return this.date;
    }

    public String getType(){
        return this.type;
    }

    public void setType(String type){
        this.type = type;
    }

    public double getBalance(){
        return this.balance;
    }

    public void setBalance(double balance){
        this.balance = balance;
    }

    // Methods
    private String makeDateStamp(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);
    }

    public boolean executeTransaction(){
        if(this.type.equals("deposit")){
            setBalance(getBalance() + getAmount());
            account.getTransactions().add(0,this);
            return true;
        } else if(!account.HasOverdraft() && this.type.equals("withdraw") && getBalance() >= getAmount()) {
            setBalance(getBalance() - getAmount());
            account.getTransactions().add(0, this);
            return true;
        } else if(account.HasOverdraft() && this.type.equals("withdraw") && (getBalance() + account.getOverdraft()) >= getAmount()){
            setBalance(getBalance() - getAmount());
            account.getTransactions().add(0, this);
            return true;
        }
        System.out.println("Insufficient funds");
        return false;
    }
}



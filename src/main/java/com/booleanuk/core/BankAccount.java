package com.booleanuk.core;

import java.time.LocalDateTime;
import java.util.TreeMap;

public abstract class BankAccount {

    private TreeMap<LocalDateTime, Integer> transactions = new TreeMap<>();

    public String generateBankStatement(){
        return "";
    }

    public void depositMoney(double amount){
        if(amount>=0) {
            transactions.put(LocalDateTime.now(), (int) (amount*100));
        }
    }

    public void withdrawMoney(double amount){
        if(amount>=0 && this.calculateBalance()>=amount) {
            transactions.put(LocalDateTime.now(), (int) -(amount * 100));
        }
    }

    public double calculateBalance(){
        int balance = 0;
        for(LocalDateTime date : transactions.keySet()){
            balance = balance + transactions.get(date);
        }
        return (double) balance/100;
    }

    public void requestOverdraft(double amount){}

}

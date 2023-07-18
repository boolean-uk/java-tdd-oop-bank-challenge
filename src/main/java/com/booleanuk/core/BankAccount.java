package com.booleanuk.core;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.TreeMap;

public abstract class BankAccount {

    private TreeMap<LocalDateTime, Integer> transactions = new TreeMap<>();

    public String generateBankStatement(){
        int balance = 0;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String bankStatement = "date       || credit  || debit  || balance \n";
        for(LocalDateTime date : transactions.navigableKeySet()) {
            bankStatement += date.format(formatter) + " || ";
            int amount = transactions.get(date);
            if(amount >= 0){
                balance += amount;
                bankStatement += (double) amount/100;
                if (amount>=1000) bankStatement += "  ";
                else if (amount>=100) bankStatement += "       ";
                else bankStatement += "        ";
                bankStatement+= "||        || ";
                bankStatement += (double) balance/100 + "\n";
            } else {
                balance += amount;
                bankStatement += "        || ";
                bankStatement += (double) -(amount/100);
                if (amount<=-1000) bankStatement += "  || ";
                else if (amount<=-100) bankStatement += "    || ";
                else bankStatement += "       || ";
                bankStatement += (double) balance/100 + "\n";
            }
        } return bankStatement;
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
        balance = balance >= 0 ? balance : -balance;
        return (balance/100);
    }

    public void requestOverdraft(double amount){}

}

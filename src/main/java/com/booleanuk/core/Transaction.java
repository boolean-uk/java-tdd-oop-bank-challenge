package com.booleanuk.core;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Transaction {
    private double credit;
    private double debit;
    private double balance;
    private String dateTime;




    public Transaction(double credit, double debit, double balance, LocalDateTime dateTime){
        this.credit = credit;
        this.debit = debit;
        this.balance = balance;
        LocalDateTime localDate = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        this.dateTime = localDate.format(formatter);


    }

    public void setCredit(double credit) {
        this.credit = credit;
    }
    public double getCredit(){
        return credit;
    }

    public void setDebit(double debit) {
        this.debit = debit;
    }
    public double getDebit(){
        return debit;
    }

    public double getBalance() {
        return balance;
    }


    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setDateTime(String dateTime){
        this.dateTime = dateTime;
    }
    public String getDateTime(){
        return dateTime;
    }

    @Override
    public String toString(){
        return "Transaction" + dateTime + " " + " Credit: " + credit + "Debit: " + debit + "Balance: " + getBalance();
    }

}

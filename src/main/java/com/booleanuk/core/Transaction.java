package com.booleanuk.core;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transaction {

    private String time;
    private float balance;
    private float amount;
    private boolean isWithdrawal;

    public Transaction(boolean isWithdrawal, float balance, float amount){
        this.isWithdrawal = isWithdrawal;
        this.balance = balance;
        this.amount = amount;

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        this.time = LocalDateTime.now().format(formatter);
    }

    public boolean getIsWithdrawal(){
        return this.isWithdrawal;
    }

    public float getBalance(){
        return this.balance;
    }

    public float getAmount(){
        return this.amount;
    }

    public String getTime(){
        return this.time;
    }

    @Override
    public String toString() {
        if (this.isWithdrawal){
            return String.format("%-20s|| %-10s|| %-10s|| %-10s", time, "", String.valueOf(this.amount), balance);
        }
        return String.format("%-20s|| %-10s|| %-10s|| %-10s", time, String.valueOf(this.amount), "", balance);

    }

}

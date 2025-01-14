package com.booleanuk.core;

import java.time.LocalDateTime;

public class Transaction {

    private LocalDateTime time;
    private float balance;
    private float amount;
    private boolean isWithdrawal;

    public Transaction(boolean isWithdrawal, float balance, float amount, LocalDateTime time){
        this.isWithdrawal = isWithdrawal;
        this.balance = balance;
        this.amount = amount;
        this.time = time;
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

    public LocalDateTime getTime(){
        return this.time;
    }
}

package com.booleanuk.core;

import java.util.Date;
import java.util.UUID;

public class Transaction {

    private String id;
    private Date date;
    private int credit;
    private int debit;
    private int balance;

    public Transaction(){
        id = UUID.randomUUID().toString();
        date = new Date();
        credit = 0;
        debit = 0;
        balance = 0;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public int getDebit() {
        return debit;
    }

    public void setDebit(int debit) {
        this.debit = debit;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}

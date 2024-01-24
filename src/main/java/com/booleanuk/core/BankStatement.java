package com.booleanuk.core;

import java.util.Date;

public abstract class BankStatement {

    private Date date;
    private double amount;
    private double balance;


    protected BankStatement() {

    }
    protected Date getTransactionDate() {
    }

    protected int getAmount() {
    }

    protected int getBalance() {
    }

}

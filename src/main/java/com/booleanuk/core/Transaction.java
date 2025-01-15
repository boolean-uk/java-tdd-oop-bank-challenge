package com.booleanuk.core;

import java.text.DateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transaction {
    private int ID;
    private final float amount;
    private String date;
    private final int transactionType;
    private float amountBeforeTransaction;

    Transaction(int id, float amount, float beforeTransaction, int transactionType) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        this.ID = id;
        this.amount = amount;
        this.amountBeforeTransaction = beforeTransaction;
        this.transactionType = transactionType;
        this.date = LocalDateTime.now().format(formatter);
    }

    public float getAmount() {
        if(this.transactionType == 0) {
            //Deposit transaction
            return this.amount;
        }else {
            //Withdraw transaction
            return -this.amount;
        }
    }

    public int getTransactionType() {
        return this.transactionType;
    }

    public String getDate() {
        return this.date;
    }
    public float getAmountBeforeTransaction() {
        return this.amountBeforeTransaction;
    }
}

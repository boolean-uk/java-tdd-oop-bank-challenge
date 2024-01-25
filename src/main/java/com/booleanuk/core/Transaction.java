package com.booleanuk.core;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Transaction {

    private Date date;
    private double amount;
    private Account account;
    private double balance;

    public Transaction(double amount, Account account) {
        this.date = new Date();
        this.amount = amount;
        this.account = account;
        this.balance = account.getBalance();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        if(amount < 0) {
            stringBuilder.append(String.format(
                    "%-29s %-19.2f %-1s %-5.2f %s",
                    dateFormat.format(this.date),
                    this.amount,
                    "",
                    this.balance,
                    "\n"
            ));
        } else if(amount > 0) {
            stringBuilder.append(String.format(
                    "%-38s %-1s %-10.2f %-10.2f %s" ,
                    dateFormat.format(this.date),
                    "",
                    this.amount,
                    this.balance,
                    "\n"
            ));
        }
        return stringBuilder.toString();
    }
}

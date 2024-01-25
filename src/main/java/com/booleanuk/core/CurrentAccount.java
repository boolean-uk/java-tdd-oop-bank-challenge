package com.booleanuk.core;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class CurrentAccount implements Account {

    private double balance;

//    private ArrayList<Date> transactionDates;

    private double amount;

    public CurrentAccount(){
        this.balance = 0.0;
    }
    public CurrentAccount(double balance){
        this.balance = balance;
    }

    // Not correct dates etc.
    public String getRecords() {

        SimpleDateFormat formatting = new SimpleDateFormat("dd-MM-yyyy");
        Date todaysDate = new Date();
        String date = formatting.format(todaysDate);

        StringBuilder record = new StringBuilder();
        record.append(String.format("%-10s || %-8s || %-8s || %-8s %n", "date", "credit", "debit", "balance"));
        double credit = getBalance();
        double debit = 0.0;
        for(int i = 0; i < 3; i++) {
            record.append(String.format("%-8s || %-8s || %-8s || %-8s %n", date, credit, debit, balance));

        }
        return record.toString();
    }

    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }
}

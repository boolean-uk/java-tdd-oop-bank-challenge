package com.booleanuk.core;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class SavingsAccount implements Account {

    private double balance;
    private ArrayList<Transaction> transactions;
    private final SimpleDateFormat formatting = new SimpleDateFormat("dd-MM-yyyy");

    public SavingsAccount(){
        this.balance = 0.0;
        this.transactions = new ArrayList<>();

    }
//    public SavingsAccount(double balance){
//        this.balance = balance;
//        this.transactions = new ArrayList<>();
//    }

    public String getRecords() {

        SimpleDateFormat formatting = new SimpleDateFormat("dd-MM-yyyy");
        StringBuilder record = new StringBuilder();

        // date       || credit  || debit  || balance
        //14/01/2012 ||         || 500.00 || 1500.00
        //13/01/2012 || 2000.00 ||        || 2000.00
        record.append(String.format("%-10s || %-8s || %-8s || %-8s %n", "date", "credit", "debit", "balance"));

        for(Transaction transaction : transactions) {
            record.append(String.format("%-8s || %-8s || %-8s || %-8s %n",
                    formatting.format(transaction.getDate()),
                    transaction.getCredit(),
                    transaction.getDebit(),
                    transaction.getBalance()
            ));
        }
        return record.toString();
    }



    public boolean deposit(double amount, Date date) {
        if(amount < 0) {
            System.out.println("Can't deposit negativ amount.");
            return false;
        } else {
            this.balance += amount;
            transactions.add(new Transaction(date, 0.0, amount, this.balance));
            return true;
        }
    }

    public boolean withdraw(double amount, Date date) {
        if(amount < 0) {
            System.out.println("Can't withdraw negative amount.");
            return false;
        } else if (this.balance - amount < 0){
            System.out.println("can't have negative balance.");
            return false;
        } else {
            this.balance -= amount;
            transactions.add(new Transaction(date, amount, 0.0, this.balance));
            return true;
        }
    }


    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }
}

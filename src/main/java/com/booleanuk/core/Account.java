package com.booleanuk.core;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;

public class Account {
    private double balance = 0;
    private int accountNum;
    private ArrayList<Transactions> transactions = new ArrayList<>();

    public Account(int accountNum) {
        this.accountNum = accountNum;
    }

    public ArrayList<Transactions> getTransactions() {
        return transactions;
    }

    public double getBalance() {
        return balance;
    }

    public double deposit(double amount) {
        balance += amount;
        String date = java.time.ZonedDateTime.now().format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        Transactions transaction = new Transactions(amount, date, balance, "DEPOSIT");
        transactions.add(transaction);
        return getBalance();
    }

    public double withdraw(double amount) {
        if (balance < amount) {
            System.out.println("You don't have that kind of money!");
        } else {
            balance -= amount;
            String date = java.time.ZonedDateTime.now().format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
            Transactions transaction = new Transactions(amount, date, balance, "WITHDRAW");
            transactions.add(transaction);
        }
        return getBalance();
    }

    public String bankStatement() {
        String output = String.format("%1$10s %2$10s %3$10s %4$10s %5$10s %6$10s %7$10s","Date", "||","Credit","||","Debit","||","Balance\n");
        ArrayList<Transactions> transactions = getTransactions();
        Collections.reverse(transactions);

        for (int i = 0; i < transactions.size(); i++) {
            if (transactions.get(i).getType().equals("DEPOSIT")) {
                output += String.format("%1$10s %2$10s %3$10s %4$10s %5$10s %6$10s %7$10s",transactions.get(i).getDate(), "||",transactions.get(i).getAmount(),"||","","||",transactions.get(i).getBalance()+"\n");
            } else {
                output += String.format("%1$10s %2$10s %3$10s %4$10s %5$10s %6$10s %7$10s",transactions.get(i).getDate(), "||","","||",transactions.get(i).getAmount(),"||",transactions.get(i).getBalance()+"\n");
            }
        }
        System.out.println(output);
        return output;
    }

    public double calculateBalance() {
        double total = 0;
        ArrayList<Transactions> transactions = getTransactions();
        for (int i = 0; i < transactions.size(); i++) {
            if (transactions.get(i).getType().equals("DEPOSIT")) {
                total += transactions.get(i).getAmount();
            } else {
                total -= transactions.get(i).getAmount();
            }
        }
        return total;
    }
}

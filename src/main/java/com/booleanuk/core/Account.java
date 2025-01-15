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
        ArrayList<Transactions> temp = getTransactions();
        Collections.reverse(temp);

        for (int i = 0; i < temp.size(); i++) {
            if (temp.get(i).getType().equals("DEPOSIT")) {
                output += String.format("%1$10s %2$10s %3$10s %4$10s %5$10s %6$10s %7$10s",temp.get(i).getDate(), "||",temp.get(i).getAmount(),"||","","||",temp.get(i).getBalance()+"\n");
            } else {
                output += String.format("%1$10s %2$10s %3$10s %4$10s %5$10s %6$10s %7$10s",temp.get(i).getDate(), "||","","||",temp.get(i).getAmount(),"||",temp.get(i).getBalance()+"\n");
            }
        }
        System.out.println(output);
        return output;

    }
}

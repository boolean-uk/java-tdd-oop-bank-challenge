package com.booleanuk.core;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Bank {

    private List<Transactions> transactionsList;


    public Bank() {
        this.transactionsList = new ArrayList<>();
    }


    public String createCurrent(String accountNumber, String name, double balance) {
        if (balance != 0) {

            Account newCurrent = new Current(accountNumber, name, balance);
            return "Your current account name is: " + newCurrent.getName();
        }
        return "";
    }

    public String createSavings(String accountNumber, String name, double balance) {
        if (balance != 0) {

            Account newSavings = new Savings(accountNumber, name, balance);
            return "Your savings account name is: " + newSavings.getName();
        }
        return "";
    }

    public double deposit(Account target, double amount) {

        double balance = target.getBalance();
        if (amount > 10) {

            LocalDateTime currentDate = LocalDateTime.now();
            Transactions transaction = new Transactions("Deposit", amount, currentDate);
            transactionsList.add(transaction);
            balance += amount;

            return balance;

        }



        return balance;
    }

    public double withdrawal(Account target, double amount) {
        double balance = target.getBalance();
        if (amount < balance) {

            LocalDateTime currentDate = LocalDateTime.now();
            Transactions transaction = new Transactions("Withdrawal", amount, currentDate);
            transactionsList.add(transaction);

            balance -= amount;


            return balance;

        }



        return 0;




    }

    public String bankStatement() {
        StringBuilder output = new StringBuilder();
        if (transactionsList.size() > 0) {

            output.append("G");


            return output.toString();
        }





        return "You have no history.";
    }



}

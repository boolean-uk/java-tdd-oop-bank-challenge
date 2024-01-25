package com.booleanuk.core;

import java.time.LocalDate;
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

            LocalDate currentDate = LocalDate.now();

            balance += amount;
            Transactions transaction = new Transactions("Deposit", amount, currentDate, balance);
            transactionsList.add(transaction);


            return balance;

        }



        return balance;
    }

    public double withdrawal(Account target, double amount) {
        double balance = target.getBalance();


        if (amount < balance) {

            LocalDate currentDate = LocalDate.now();

            balance -= amount;
            Transactions transaction = new Transactions("Withdrawal", amount, currentDate, balance);
            transactionsList.add(transaction);


            return balance;

        }
        else if (amount > balance && target.isOverDraft()) {

            LocalDate currentDate = LocalDate.now();

            balance -= amount;
            Transactions transaction = new Transactions("Overdraft", amount, currentDate, balance);
            transactionsList.add(transaction);


            return balance;
        }



        return 0;




    }

    public String bankStatement() {
        StringBuilder output = new StringBuilder();
        if (!transactionsList.isEmpty()) {
            output.append("Date " + " | " + " Amount " + " | " + " Type " + " | " + " Balance " + "\n");
            for (Transactions transactions : transactionsList) {


                output.append(transactions.getDate() + " | " + transactions.getAmount() + " | " + transactions.getType() + " | " + transactions.getBalance() + "\n");
            }



            return output.toString();
        }

        return "You have no history.";
    }


    public String requestOverdraft(Current tester, boolean status) {

        if (status) {
            tester.setOverDraftTrue();
            return "Your overdraft request was accepted";
        }
        else {
            tester.setOverDraftFalse();
        }
        return "Your overdraft request was denied";
    }



}

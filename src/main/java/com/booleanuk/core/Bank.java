package com.booleanuk.core;

public class Bank {


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
            balance += amount;

            return balance;

        }



        return balance;
    }

    public double withdrawal(Account target, double amount) {

        double balance = target.getBalance();
        if (amount < balance) {
            balance -= amount;

            return balance;

        }



        return 0;




    }



}

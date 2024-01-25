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

    public boolean deposit(double amount) {



        return false;
    }

    public boolean withdrawal(double amount) {



        return false;
    }



}

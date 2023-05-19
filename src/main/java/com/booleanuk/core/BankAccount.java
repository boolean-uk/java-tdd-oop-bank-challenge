package com.booleanuk.core;
// Parent BankAccount Class (Super Class)
public class BankAccount {
    public double balance;

    // constructor of class

    public BankAccount(){
        balance = 0;
    }
//    BankAccount() {
//
//    }

    BankAccount(double formerAmount){
        balance = formerAmount;
    }

    // add money to the account
    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        balance -= amount;
    }

    // remove money from the account
//    public boolean withdraw(double amount) {
//        if (balance - amount >= 0) {
//            balance -= amount;
//            return true;
//        } else {
//            return false;
//        }
//    }

    public double getBalance() {
        return balance;
    }
}

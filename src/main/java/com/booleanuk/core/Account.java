package com.booleanuk.core;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import com.booleanuk.extension.Manager;

public class Account {
    private AccountType type;
    private Customer customer;
    private LocalDate date;
    private double balance;
    List<Transaction> history = new ArrayList<>();


    public Account(AccountType type, Customer customer, LocalDate date, double balance) {
        this.type = type;
        this.customer = customer;
        this.date = date;
        this.balance = balance;

    }

    public AccountType getType() {
        return type;
    }

    public void setType(AccountType type) {
        this.type = type;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String create(){
//        history.put(LocalDate.now(), "Account has been created");
        return "Account has been created";
    }

    public String deposit(double amount){
        if(amount < 0){
            return "You can not deposit negative value";
        }
        balance += amount;
        Transaction tr = new Transaction(LocalDate.now(), amount,  balance, TransactionType.CREDIT);
        history.add(tr);

        return "Your balance after update: " + balance;
    }

    public String  withdraw(double amount){
        if(amount < 0){
            return "You can not withdraw negative value";
        }
        if(balance - amount < 0){
            if(Manager.requests.contains(this) && balance - amount < -400){
                balance -= amount;
                Transaction tr = new Transaction(LocalDate.now(),  amount, balance, TransactionType.DEBIT);
                history.add(tr);
                return "Balance updated";
            }
            return "Unfortunately you don't have enough money to make this operation. Request is sent to manager";
        }
        balance -= amount;
        Transaction tr = new Transaction(LocalDate.now(),  amount, balance, TransactionType.DEBIT);
        history.add(tr);
        return "Your balance after update: " + balance;
    }

    public String generateStatement(){
        return history.toString();
    }


    @Override
    public String toString() {
        return "Account{" +
                "type=" + type +
                ", customer=" + customer +
                ", date=" + date +
                ", balance=" + balance +
                '}';
    }
}

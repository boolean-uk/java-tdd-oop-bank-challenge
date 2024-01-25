package com.booleanuk.core;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Account {
    private double balance;
    private double overdraft;
    private StringBuilder transactionLog;
    private User user;

    public Account(User user){
        this.user = user;

        this.balance = 0d;
        this.overdraft = 0d;
        this.transactionLog = new StringBuilder();
        createLogHeader();
    }

    private void createLogHeader(){
        transactionLog.append(String.format("%-7s%-4s%-11s%-4s%-10s%-4s%-13s%-4s%-20s\n", "User ID"," || ","Deposited"," || "
                ,"Withdrew"," || ","New Balance", " || ", "Date \n" ));
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getOverdraft() {
        return overdraft;
    }


    public void withdraw(double amount){
        if (getBalance() > overdraft){
            setBalance(this.balance - amount);
            logTransactions(0d,amount);
        }
        else {
            System.out.println("Insufficient funds");
        }
    }

    public void deposit(double amount){
        setBalance(this.balance + amount);
        logTransactions(amount,0d);
    }

    public void logTransactions(double withdrawAmount, double depositAmount){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        Date currentDate = new Date();

        transactionLog.append(String.format("%-7s%-4s%-11s%-4s%-10s%-4s%-13s%-4s%-20s\n",
                user.getId()," || ",
                withdrawAmount," || ",
                depositAmount, " || ",
                getBalance(), " || ",
                dateFormat.format(currentDate)));
    }
    public String getTransactionLog() {
        return transactionLog.toString();
    }

}

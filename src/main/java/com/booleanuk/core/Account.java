package com.booleanuk.core;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Account extends Manager{
    private double balance;
    private double overdraft;
    private StringBuilder transactionLog;
    private User user;

    public Account(User user){
        super(user.getName(), user.getBranch());
        this.user = user;
        this.balance = 0;
        this.overdraft = 0;
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


    public boolean withdraw(double amount){
        if (amount < getBalance()) {
            setBalance(this.balance - amount);
            logTransactions(0d, amount);
            return true;
        }
        else if (getOverdraft() < (getBalance() - amount)){
            setBalance(this.balance - amount);
            logTransactions(0d, amount);
            return true;
        }

        else {
            System.out.println("Insufficient funds");
            return false;
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


    public boolean requestAccepted(double overdraft){
        if (overdraft >= getMaximumOverdraft()){
            this.overdraft = overdraft;
            return true;
        }
        System.out.println("Request denied");
        return false;
    }

}

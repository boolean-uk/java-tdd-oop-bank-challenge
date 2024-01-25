package com.booleanuk.core;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Account {
    private int balance;
    private int overdraft;
    private StringBuilder transactionLog;
    private User user;

    public Account(User user){
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

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getOverdraft() {
        return overdraft;
    }


    public void withdraw(int amount){
        if (getBalance() > overdraft){
            setBalance(this.balance - amount);
            logTransactions(0,amount);
        }
        else {
            System.out.println("Insufficient funds");
        }
    }

    public void deposit(int amount){
        setBalance(this.balance + amount);
        logTransactions(amount,0);
    }

    public void logTransactions(int withdrawAmount, int depositAmount){
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

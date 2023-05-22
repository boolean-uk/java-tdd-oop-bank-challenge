package com.booleanuk.core;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class Account {
    private Balance balance;
    private String statements;
    public Account(Balance balance){
        initialBalance(balance);
        this.statements +="\nAccount created at "+convertEpochTimeToDateTime(System.currentTimeMillis())+" with $"+balance+" \n";
        this.statements += "date       || credit  || debit  || balance\n";
    }
    public Account(int intPart, int decimalPart){
        initialBalance(new Balance(intPart,decimalPart));
        if(this.balance!= null){
            this.statements+="Account created at "+convertEpochTimeToDateTime(System.currentTimeMillis())+" with $"+new Balance(intPart,decimalPart)+" \n";
        }
        this.statements += "date       || credit  || debit  || balance\n";

    }
    //setBalance is private because I don't want any other class to use it.
    private void setBalance(Balance balance) {
        this.balance = balance;
    }
    public void initialBalance(Balance balance){
        if(balance.getIntPart()>5){
            this.balance = balance;
        }else if(balance.getIntPart()<0){
            System.out.println("Cannot open an account with a negative balance!");
        }else{
            System.out.println("When opening an account, a minimum of $5 is required as an original deposit!");
        }
    }
    public Balance getBalance(){
        return this.balance;
    }
    public Balance getBalanceByStatements(){
        String[] statements = this.statements.split("\n");
        Balance balance = new Balance(0,0);
        // i know where the latest balance is
        if(statements.length==3){
            return this.balance;
        }
        String[] parts = statements[statements.length-1].split("\\|\\|");
//        System.out.println(Arrays.toString(statements));
//        System.out.println(Arrays.toString(parts));
        String[] almostThere = parts[3].split("\\$");
//        System.out.println(Arrays.toString(almostThere));
        String[] number = almostThere[1].split(",");
//        System.out.println(Arrays.toString(number));
        int intPart = Integer.parseInt(number[0]);
        int decimalPart = Integer.parseInt(number[1]);
        return new Balance(intPart,decimalPart);
    }
    public boolean withdraw(Balance toWithdraw){
        if(this.getBalanceByStatements().getIntPart()>toWithdraw.getIntPart()){
            System.out.println("Withdrew "+toWithdraw.toString()+" ");
            this.balance.interact(new Balance(-toWithdraw.getIntPart(),-toWithdraw.getDecimalPart()));
            this.addToStatements(new Balance(-toWithdraw.getIntPart(), -toWithdraw.getDecimalPart()));
            this.balance = getBalanceByStatements();
            return true;
        }
        return false;
    }
    public boolean deposit(Balance toDeposit){
        if(toDeposit.getDecimalPart()>=0 && toDeposit.getIntPart()>0){
            System.out.println("Successfully deposited "+toDeposit);
            this.balance.interact(new Balance(toDeposit.getIntPart(),toDeposit.getDecimalPart()));
            this.addToStatements(toDeposit);
            this.balance = getBalanceByStatements();
            return true;
        }

        return false;
    }
    public void addToStatements(Balance balance){
        this.statements+= convertEpochTimeToDateTime(System.currentTimeMillis())+ " ||";
        if(balance.getIntPart()>=0){
            this.statements+= " $"+balance+"   ||        || $"+this.getBalance().toString()+'\n';
        }else{
            this.statements+="         || $"+balance+" || $"+this.getBalance().toString()+"\n";
        }
    }
    public String showStatements(){
        //reverse the order of statements
        String[] transactions = this.statements.split("\n");
        String res = transactions[2]+"\n";
        //transactions[0] will contain the line where the Account is initialized, transactions[1] will contain the data line
        for(int i=transactions.length-1;i>2;i--){
            res+= transactions[i]+"\n";
        }
        res += transactions[1]+"\n";
        System.out.println(res);
        writeStatements(res);
        return res;
    }
    public static String convertEpochTimeToDateTime(long epochTimeInMillis) {
        Instant instant = Instant.ofEpochMilli(epochTimeInMillis);
        LocalDateTime dateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return dateTime.format(formatter);
    }
    public void writeStatements(String statements){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("statements.txt"))) {
            writer.write(statements);
            System.out.println("String written to file successfully.");
        } catch (IOException e) {
            System.err.println("An error occurred while writing to the file: " + e.getMessage());
        }

    }
}

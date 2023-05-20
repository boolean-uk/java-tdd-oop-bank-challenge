package com.booleanuk.core;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class Account {
    private Balance balance;
    private String statements;
    public Account(Balance balance){
        setBalance(balance);
        this.statements+="\nAccount created at "+convertEpochTimeToDateTime(System.currentTimeMillis())+" with $"+balance+" \n";
        this.statements += "date       || credit  || debit  || balance\n";
    }
    public Account(int intPart, int decimalPart){
        setBalance(new Balance(intPart,decimalPart));
        if(this.balance!= null){
            this.statements+="Account created at "+convertEpochTimeToDateTime(System.currentTimeMillis())+" with $"+new Balance(intPart,decimalPart)+" \n";
        }
        this.statements = "date       || credit  || debit  || balance\n";

    }
    //setBalance is private because I don't want any other class to use it.
    private void setBalance(Balance balance) {
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
    public boolean withdraw(Balance toWithdraw){
        if(this.getBalance().getIntPart()>toWithdraw.getIntPart() && this.getBalance().getDecimalPart()>toWithdraw.getDecimalPart()){
            System.out.println("Withdrew "+toWithdraw.toString()+" ");
            this.balance.interact(new Balance(-toWithdraw.getIntPart(),-toWithdraw.getDecimalPart()));
            this.addToStatements(toWithdraw);
            return true;
        }
        return false;
    }
    public boolean deposit(Balance toDeposit){
        if(toDeposit.getDecimalPart()>=0 && toDeposit.getIntPart()>0){
            System.out.println("Successfully deposited "+toDeposit);
            this.balance.interact(new Balance(toDeposit.getIntPart(),toDeposit.getDecimalPart()));
            this.addToStatements(toDeposit);
            return true;
        }

        return false;
    }
    public void addToStatements(Balance balance){
        this.statements+= convertEpochTimeToDateTime(System.currentTimeMillis())+ " ||";
        if(balance.getIntPart()>=0){
            this.statements+= " $"+balance+" ||          || $"+this.getBalance().toString();
        }else{
            this.statements+="         || $"+balance+" || $"+this.getBalance().toString();
        }
    }
    public String showStatements(){
        System.out.println(statements);
        return this.statements;
    }
    public static String convertEpochTimeToDateTime(long epochTimeInMillis) {
        Instant instant = Instant.ofEpochMilli(epochTimeInMillis);
        LocalDateTime dateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return dateTime.format(formatter);
    }
}

package com.booleanuk.core;

import java.util.ArrayList;
import java.util.Objects;

public abstract class Account {

    private int accountNumber;
    private AccountOwner owner;
    private ArrayList<Transaction> bankStatement;

    Account(AccountOwner owner){
        this.accountNumber = 12367;
        this.owner = owner;
        this.bankStatement = new ArrayList<>();
    }

    protected AccountOwner getOwner(){
        return this.owner;
    }

    protected double getBalance(){
        double sum = 0.0;

        for(Transaction transaction : this.bankStatement){
           if (transaction.getType() == TransactionType.DEPOSIT){
               sum += transaction.getAmount();
           }
           else {
               sum -= transaction.getAmount();
           }
        }

        return sum;
    }


    protected ArrayList<Transaction> getBankStatement(){
        return this.bankStatement;
    }

    protected int getAccountNumber(){
        return this.accountNumber;
    }

    public void printBankstatement() {
        System.out.println("Date        || Credit   || Debit    || Balance");
        if(!bankStatement.isEmpty()){
            for(Transaction transaction : bankStatement.reversed()){
                if (transaction.getType() == TransactionType.DEPOSIT) {
                    System.out.printf("%-11s || %-8.2f || %-8s || %.2f%n", transaction.getDate(), transaction.getAmount(), "", transaction.getBalance() + transaction.getAmount());

                } else {
                    System.out.printf("%-11s || %-8s || %-8.2f || %.2f%n", transaction.getDate(), "", transaction.getAmount(), transaction.getBalance() - transaction.getAmount());
                }
            }
        }
        else {
            System.out.println("No transactions found!");
        }
    }

    public abstract String deposit(double amount);

    public abstract String withdraw(double amount);



}

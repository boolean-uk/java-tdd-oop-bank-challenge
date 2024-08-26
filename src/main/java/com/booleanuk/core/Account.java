package com.booleanuk.core;

import java.util.ArrayList;
import java.util.Objects;

public abstract class Account {

    private int accountNumber;
    private AccountOwner owner;
    private ArrayList<Transaction> bankStatement;
    private double balance;

    Account(AccountOwner owner){
        this.accountNumber = 12367;
        this.owner = owner;
        this.bankStatement = new ArrayList<>();
        this.balance = 0.00;
    }

    protected double getBalance(){
        return this.balance;
    }

    protected void setBalance(double newBalance){
        this.balance = newBalance;
    }

    protected ArrayList<Transaction> getBankStatement(){
        return this.bankStatement;
    }

    public void printBankstatement() {
        System.out.println("\t Date \t \t \t|| Credit\t|| Debit\t|| Balance");
        if(!bankStatement.isEmpty()){
            for(Transaction transaction : bankStatement.reversed()){
                if (transaction.getType() == TransactionType.DEPOSIT){
                    System.out.println(transaction.getDate() +" || " + transaction.getAmount() + " || " + "\t \t \t" + " || " + transaction.getBalance());

                }
                else {
                    System.out.println(transaction.getDate() +" || " + "\t \t \t" + " || " + transaction.getAmount() + " || " + transaction.getBalance());
                }

            }
        }
        System.out.println("No transactions found!");
    }

    public abstract String deposit(double amount);

    public abstract String withdraw(double amount);



}

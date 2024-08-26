package com.booleanuk.core;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Account {
    private int accountNr;
    private double interest;
    private ArrayList<Transaction> transactions;

    public Account(double interest){
        accountNr = 1;
        this.interest = interest;
        transactions = new ArrayList<>();
    }

    public ArrayList<Transaction> getTransactions(){
        return transactions;
    }

    public Transaction deposit(int money){
        Transaction newTransaction = new Transaction(money, 0);
        transactions.add(newTransaction);
        return newTransaction;
    }

    public Transaction withdraw(int money){
        Transaction newTransaction = new Transaction(0, money);
        transactions.add(newTransaction);
        return newTransaction;
    }

    public int getBalance(){
        int result = 0;
        for(Transaction transaction : transactions){
            result += transaction.getCredit() - transaction.getDebit();
        }
        return result;
    }

    public String statement(){
        int counter = transactions.size() - 1;
        String result = "date       || credit  || debit  || balance\n";
        for(Transaction transaction : transactions){
            int balance = 0;
            int credit = transaction.getCredit();
            int debit = transaction.getDebit();
            result += transaction.getDate() + " || ";

            if(credit == 0){
                result += "       ";
            }
            else{
                result += String.format("%-7s", credit);
            }
            result += " || ";

            if(debit == 0){
                result += "      ";
            }
            else{
                result += String.format("%-6s", debit);
            }
            result += " || ";

            for(int i = 0; i < transactions.size() - counter; ++i){
                balance += transactions.get(i).getCredit() - transactions.get(i).getDebit();
            }
            result += balance;
            if(!(transaction == transactions.getLast())){
                result += "\n";
            }
            counter--;
        }
        return result;
    }
}

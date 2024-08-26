package com.booleanuk.core;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Account {

    // Må muligens ha en type variable for savings/current?
    private ArrayList<Transaction> transactions;
    private ArrayList<String> bankStatement;
    private int balance;
    private String name;

    public Account(String name){
        this.transactions = new ArrayList<>();
        this.bankStatement = new ArrayList<>();
        this.balance = 0;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public float getBalance() {
        return balance/100f;
    }

    public ArrayList<String> getBankStatement() {
        return bankStatement;
    }

    public void deposit(float amount){
        this.balance += (int) (amount * 100);
        transactions.add(new Transaction("£" + String.format("%.2f", amount), this.balance));
    }

    public String withdraw(float amount){
        if (amount > this.balance/100f){
            return "Not enough funds.";
        }

        this.balance -= (int) (amount * 100);
        transactions.add(new Transaction("-£" + String.format("%.2f", amount), this.balance));
        return "Funds withdrawed from account.";
    }

    public void generateBankStatement(){
        bankStatement.add(String.format("%-11s %1s %10s %1s %11s", "Date", "||", "Amount", "||", "Balance"));
        bankStatement.add("----------------------------------------");
        for (Transaction transaction : transactions) {
            bankStatement.add(String.format("%-11s %1s %10s %1s %11s",
                    transaction.getDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")), "||",
                    transaction.getAmount(), "||",
                    transaction.getBalance()));
        }
    }

    public void printBankStatement(){
        for (String s : bankStatement){
            System.out.println(s);
        }
    }

}

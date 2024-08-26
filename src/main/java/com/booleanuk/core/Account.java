package com.booleanuk.core;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Account {

    private ArrayList<Transaction> transactions;
    private ArrayList<String> bankStatement;
    private String name;
    private Branch branch;

    public Account(String name, Branch branch){
        this.transactions = new ArrayList<>();
        this.bankStatement = new ArrayList<>();
        this.name = name;
        this.branch = branch;
    }

    public String getName() {
        return name;
    }

    public Branch getBranch() {
        return branch;
    }

    public int getBalance() {
        if (transactions.isEmpty()){
            return 0;
        }
        return transactions.getLast().getBalance();
    }

    public ArrayList<String> getBankStatement() {
        return bankStatement;
    }

    public void deposit(float amount){
        int newBalance = (getBalance() + ((int) (amount * 100)));
        transactions.add(new Transaction("£" + String.format("%.2f", amount), newBalance));
    }

    public String withdraw(float amount){
        if (amount > (float) getBalance()/100f){
            return "Not enough funds.";
        }

        int newBalance = (getBalance() - ((int) (amount * 100)));
        transactions.add(new Transaction("-£" + String.format("%.2f", amount), newBalance));
        return "Funds withdrawed from account.";
    }

    public void generateBankStatement(){
        bankStatement.add(String.format("%-11s %1s %10s %1s %11s", "Date", "||", "Amount", "||", "Balance"));
        bankStatement.add("----------------------------------------");
        for (Transaction transaction : transactions) {
            bankStatement.add(String.format("%-11s %1s %10s %1s %11s",
                    transaction.getDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")), "||",
                    transaction.getAmount(), "||",
                    "£" + String.format("%.2f", (float) transaction.getBalance()/100f)));
        }
    }

    public void printBankStatement(){
        for (String s : bankStatement){
            System.out.println(s);
        }
    }

}

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

    public float centsToPounds(int num){
        String string = floatFormatter((float) num/100f);
        return Float.parseFloat(string);
    }

    public int poundsToCents(float num){
        return (int) (num*100f);
    }

    public String floatFormatter(float num){
        return String.format("%.2f", num);
    }

    public ArrayList<String> getBankStatement() {
        return bankStatement;
    }

    public void deposit(float amount){
        int newBalance = getBalance() + poundsToCents(amount);
        transactions.add(new Transaction(floatFormatter(amount)+ "£", newBalance));
    }

    public String withdraw(float amount){
        if (amount > centsToPounds(getBalance())){
            return "Not enough funds.";
        }

        int newBalance = (getBalance() - ((int) (amount * 100)));
        transactions.add(new Transaction("-" + floatFormatter(amount) + "£", newBalance));
        return "Funds withdrawed from account.";
    }

    public void generateBankStatement(){
        bankStatement.add(String.format("%-11s %1s %10s %1s %11s", "Date", "||", "Amount", "||", "Balance"));
        bankStatement.add("----------------------------------------");
        for (Transaction transaction : transactions) {
            bankStatement.add(String.format("%-11s %1s %10s %1s %11s",
                    transaction.getDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")), "||",
                    transaction.getAmount(), "||",
                    floatFormatter(centsToPounds(transaction.getBalance())) + "£"));
        }
    }

    public void printBankStatement(){
        for (String s : bankStatement){
            System.out.println(s);
        }
    }

}

package com.booleanuk.core;

import java.util.ArrayList;

public abstract class Account {
    protected int balance;
    protected ArrayList<Transaction> transactionHistory;
    protected boolean canOverdraft;
    protected boolean overdraftRequested;
    protected Branch ownerBranch;


    public Account(Branch branch){
        this.ownerBranch = branch;
        this.balance = 0;
        this.transactionHistory = new ArrayList<>();
        this.canOverdraft = false;
    }

    public int getBalance(){ return this.balance; }
    public ArrayList<Transaction> getTransactionHistory(){ return this.transactionHistory; }
    public boolean getCanOverdraft(){ return this.canOverdraft; }
    public Branch getOwnerBranch(){ return this.ownerBranch; }

    public void deposit(int amount){
        int currentBalance = calculateCurrentBalance();
        Transaction t = new Transaction(amount, currentBalance);
        this.transactionHistory.add(t);
    }

    public void withdraw(int amount){
        int currentBalance = calculateCurrentBalance();
        Transaction t = new Transaction(-amount, currentBalance);
        this.transactionHistory.add(t);
    }

    public int calculateCurrentBalance(){
        int currentBalance = 0;

        for (Transaction t : this.transactionHistory){
            currentBalance += t.getAmount();
        }
        return currentBalance;
    }

    public void generateBankStatement(){
        ArrayList<String> statement = new ArrayList<>();
        String  s = String.format("%-10s %2s %-10s %2s %-10s %2s %-10s", "date", "||", "credit", "||", "debit", "||", "balance");
        statement.add(s);

        for (Transaction t : this.transactionHistory){
            if (0 < t.getAmount()){
                s = String.format("%-10s %2s %-10s %2s %-10s %2s %-10s", t.getDate(), "||", t.getAmount() + ".00", "||", " ", "||", t.getCurrentBalance() + ".00");
            } else {
                s = String.format("%-10s %2s %-10s %2s %-10s %2s %-10s", t.getDate(), "||", " ", "||", -t.getAmount() + ".00", "||", t.getCurrentBalance() + ".00");
            }
            statement.add(s);
        }
        printBankStatement(statement);
    }

    public void printBankStatement(ArrayList<String> list){
        for (String s : list){
            System.out.println(s);
        }
    }

    public void requestOverdraft(){
        if (!this.overdraftRequested) {
            this.overdraftRequested = true;
            System.out.println("Overdraft requested.");
        } else {
            System.out.println("Overdraft has already been requested.");
        }
    }
}

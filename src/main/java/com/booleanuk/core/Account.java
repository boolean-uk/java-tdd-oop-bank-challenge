package com.booleanuk.core;

import java.util.ArrayList;

public abstract class Account {
    protected ArrayList<Transaction> transactionHistory;
    protected boolean canOverdraft;
    protected boolean overdraftRequested;
    protected Branch ownerBranch;

    public Account(Branch branch){
        this.ownerBranch = branch;
        this.transactionHistory = new ArrayList<>();
        this.canOverdraft = false;
    }

    public ArrayList<Transaction> getTransactionHistory(){ return this.transactionHistory; }
    public Branch getOwnerBranch(){ return this.ownerBranch; }

    public void deposit(int amount){
        if (amount < 1){
            System.out.println("Invalid amount.");
            return;
        }

        int currentBalance = calculateCurrentBalanceFromTransactionHistory();
        Transaction t = new Transaction(amount, currentBalance);
        this.transactionHistory.add(t);
    }

    public boolean withdraw(int amount){
        if (amount < 1){
            System.out.println("Invalid amount.");
            return false;
        }

        int currentBalance = calculateCurrentBalanceFromTransactionHistory();
        if (currentBalance < amount && !canOverdraft){
            System.out.println("Insufficient funds.");
            return false;
        }

        Transaction t = new Transaction(-amount, currentBalance);
        this.transactionHistory.add(t);
        return true;
    }

    public int calculateCurrentBalanceFromTransactionHistory(){
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

    /*
    The following functionality is meant for the manager only.
     */
    public void rejectOverdraftRequest(){
        if (overdraftRequested) { this.canOverdraft = false; }
    }

    public void acceptOverdraftRequest(){
        if (overdraftRequested) { this.canOverdraft = true; }
    }
}

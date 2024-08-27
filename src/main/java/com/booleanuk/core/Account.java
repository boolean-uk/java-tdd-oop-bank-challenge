package com.booleanuk.core;

import java.util.ArrayList;

public class Account {
    private float balanceChecker;
    private ArrayList<Transaction> transactionsList;
    private String branch;
    private boolean canOverdraft = false;
    private float overdraftLimit = 0;

    public Account(float firstDeposit) {
        this.balanceChecker = firstDeposit;
        this.transactionsList = new ArrayList<>();
        //First initial deposit of account
        Transaction initialTransaction = new Transaction(0, firstDeposit, 0, 0);
        transactionsList.add(initialTransaction);
    }

    public Account(float firstDeposit, String branch) {
        this.balanceChecker = firstDeposit;
        this.transactionsList = new ArrayList<>();
        transactionsList.add(new Transaction(0, firstDeposit, 0, 0));
        this.branch = branch;
    }

    public float getBalanceChecker() {
        return this.balanceChecker;
    }

    public float getBalance() {
        return calculateAccountBalance();
    }

    public boolean getCanOverdraft() {
        return this.canOverdraft;
    }

    public void setCanOverdraft() {
        this.canOverdraft = !this.canOverdraft;
    }
    public void setOverdraftLimit(float overdraftLimit) {
        this.overdraftLimit = -overdraftLimit;
    }

    public float getOverdraftLimit() {
        return this.overdraftLimit;
    }

    public void depositMoney(float amount) {
        if(amount > 0) {
            Transaction transaction = new Transaction(transactionsList.size(), amount, this.balanceChecker, 0);
            transactionsList.add(transaction);
            this.balanceChecker += amount;
        }else {
            System.out.println("Cannot add 0 or a negative amount");
        }
    }


    //For overdraft, you have to ask the manager
    public void withdrawMoney(float amount){
        if(this.balanceChecker >= this.overdraftLimit) {
            if((this.balanceChecker - amount) >= this.overdraftLimit) {
                Transaction transaction = new Transaction(transactionsList.size(), amount, this.balanceChecker, 1);
                transactionsList.add(transaction);
                this.balanceChecker -= amount;
                //overdraftLimit is a negative number and -- = + therefore I remove the - from overdraftlimit to get a negative value
                if(getCanOverdraft() && this.overdraftLimit < 0){
                    this.overdraftLimit = (-this.overdraftLimit) - amount ;
                }
            }else {
                System.out.println("Insufficient amount of transaction.");
            }
        }else {
            System.out.println("Under your overdraft limit.");
        }
    }

    private float calculateAccountBalance() {
        float balanceController = 0;
        if(!transactionsList.isEmpty()) {
            for (Transaction transaction: transactionsList) {
                balanceController += transaction.getAmount();
            }
        }
        return balanceController;
    }

    public void printOutTransactions() {
        System.out.println("\t Date \t \t \t|| Deposit\t|| Withdraw\t|| Balance");
        if(!transactionsList.isEmpty()){
            for (Transaction transaction:  transactionsList.reversed()) {
                if(transaction.getTransactionType() == 0) {
                    System.out.println(transaction.getDate() + " || " + transaction.getAmount() + " \t||\t\t\t" +  "|| " + (transaction.getAmountBeforeTransaction() + transaction.getAmount()));
                }else {
                    System.out.println(transaction.getDate() + " || \t\t\t" + "|| " + transaction.getAmount() + " \t|| " + (transaction.getAmountBeforeTransaction() + transaction.getAmount()));
                }
            }
        }
    }
}

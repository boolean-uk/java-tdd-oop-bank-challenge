package com.booleanuk.core;

import java.util.ArrayList;

public class CurrentAccount extends Account{

    ArrayList<Overdraft> pendingOverdraftRequests;

    private double overdraftLimit;

    CurrentAccount(AccountOwner owner) {
        super(owner);
        this.pendingOverdraftRequests = new ArrayList<>();

        //Initially overdraft limit is set to 0.0
        this.overdraftLimit = 0.0;

    }

    protected double getOverdraftLimit(){
        return overdraftLimit;
    }

    protected void setOverdraftLimit(double newOverdraftLimit){
        this.overdraftLimit = newOverdraftLimit;
    }

    public String makeOverdraftRequest(double amount, String message){
        Overdraft newOverdraft = new Overdraft(message, amount);

        pendingOverdraftRequests.add(newOverdraft);

        return "New overdraft request added";
    }

    @Override
    public String deposit(double amount) {

        Transaction depositTransaction = new Transaction(TransactionType.DEPOSIT, amount, getBalance());
        getBankStatement().add(depositTransaction);

        return "New Balance: " + getBalance() + "£";
    }

    @Override
    public String withdraw(double amount) {
        if (amount <= getBalance() + overdraftLimit){

            if (amount > getBalance()){
                double overdraft = amount - getBalance();

                overdraftLimit -= overdraft;
            }

            Transaction withdrawTransaction = new Transaction(TransactionType.WITHDRAWAL, amount, getBalance());
            getBankStatement().add(withdrawTransaction);

            return "New Balance: " + getBalance() + "£";
        }

        else {
            return "Insufficient Funds";
        }

    }

}

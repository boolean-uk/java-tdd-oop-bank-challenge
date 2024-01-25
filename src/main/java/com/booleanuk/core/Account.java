package com.booleanuk.core;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public abstract class Account implements Serializable {
    protected double balance;
    protected int id;
    protected String accountHolder;
    protected ArrayList<BankStatement> bankStatements;
    protected Branch branch;
    protected boolean overdraftApproved;

    public Account(int id, String accountHolder, Branch branch){
        this();
        this.id = id;
        this.accountHolder = accountHolder;
        this.branch = branch;


    }
    public Account(int id, String accountHolder){
        this();
        this.id = id;
        this.accountHolder = accountHolder;

    }
    private Account(){
        bankStatements = new ArrayList<>();
        this.overdraftApproved = false;
    }
    public boolean deposit(double amount){
        if(amount < 0){
            return false;
        }
        else{
            balance += amount;
            bankStatements.add(new BankStatement(balance,amount,Type.DEPOSIT));
            return true;
        }
    }
    public boolean withdraw(double amount){
        if(amount > balance){
            return false;
        }
        else{
            balance -= amount;
            bankStatements.add(new BankStatement(balance,amount,Type.WITHDRAW));
            return true;
        }

    }

    public ArrayList<String> getBankStatements() {
        ArrayList<String> temp = new ArrayList<>();
        for(BankStatement bankStatement : bankStatements){
            temp.add(bankStatement.toString());
        }
        temp.add("date       || credit  || debit  || balance");
        Collections.reverse(temp);
        return temp;
    }

    public int getAccountId(){
        return this.id;
    }
    public String getAccountHolder(){
        return this.accountHolder;
    }
    public Branch getBranch(){
        return this.branch;
    }
    public boolean getOverdraftApproved(){
        return this.overdraftApproved;
    }
    public void setOverdraftApproved(boolean overdraftApproved){
        this.overdraftApproved = overdraftApproved;
    }
    @Override
    public String toString() {
        return "Account Holder: " + this.accountHolder + ", Current Balance: " + this.balance;
    }
}

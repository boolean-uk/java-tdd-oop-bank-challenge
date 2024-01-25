package com.booleanuk.core;

import com.booleanuk.core.enums.Branch;
import com.booleanuk.core.enums.Type;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

public abstract class Account implements Serializable {
    protected int id;
    protected String accountHolder;
    protected ArrayList<BankStatement> bankStatements;
    protected Branch branch;
    protected boolean overdraftApproved;

    protected TransactionManager transactionManager;

    public Account(int id, String accountHolder, Branch branch, TransactionManager transactionManager){
        this();
        this.id = id;
        this.accountHolder = accountHolder;
        this.branch = branch;
        this.transactionManager = transactionManager;

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
            transactionManager.addTransaction(new Transaction(this.id, amount));
            bankStatements.add(new BankStatement(transactionManager.getBalance(this.id), amount, Type.DEPOSIT));
            return true;
        }
    }
    public boolean withdraw(double amount){
        if(amount > transactionManager.getBalance(this.id)){
            return false;
        }
        else{
            transactionManager.addTransaction(new Transaction(this.id, -amount));
            bankStatements.add(new BankStatement(transactionManager.getBalance(this.id), amount,Type.WITHDRAW));
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

    public double getBalance(){
        return transactionManager.getBalance(this.id);
    }
    @Override
    public String toString() {
        return "Account Holder: " + this.accountHolder + ", Current Balance: " + transactionManager.getBalance(this.id);
    }
}

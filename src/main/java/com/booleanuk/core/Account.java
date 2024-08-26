package com.booleanuk.core;

import java.util.ArrayList;

public abstract class Account {
    protected int balance;
    protected ArrayList<Transaction> transactionHistory;
    protected boolean canOverdraft;
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
}

package com.booleanuk.core;

import java.util.ArrayList;

public abstract class BankAccount {
    protected ArrayList<BankStatement> statements;
    protected boolean overdraft=false;

    protected String branch;

    public String getBranch() {
        return branch;
    }

    public boolean isOverdraft() {
        return overdraft;
    }

    public abstract String printStatements(BankAccount account);

    public abstract boolean deposit(double deposit);

    public abstract boolean withdraw(double withdraw);

    public abstract void changeOverdraft();


}

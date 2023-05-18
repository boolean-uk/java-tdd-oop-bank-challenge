package com.booleanuk.core;

import java.util.ArrayList;

public abstract class BankAccount {
    protected ArrayList<BankStatement> statements;

    public abstract String printStatements(BankAccount account);

    public abstract boolean deposit(double deposit);

    public abstract boolean withdraw(double withdraw);

}

package com.booleanuk.core;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public abstract class Account {
    protected double balance;
    protected int id;
    protected String accountHolder;
    protected ArrayList<BankStatement> bankStatements;

    public Account(int id, String accountHolder){
        this.id = id;
        this.accountHolder = accountHolder;
        bankStatements = new ArrayList<>();
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
}

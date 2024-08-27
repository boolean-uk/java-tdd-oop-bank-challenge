package com.booleanuk.core;

public class Current extends Account{

    private boolean overdraft;

    public Current(){
        super(1.2);
        overdraft = false;
    }

    public boolean getOverdraft(){
        return overdraft;
    }

    public void toggleOverdraft(){
        overdraft = !overdraft;
    }

    public Transaction overdraft(int money){
        if(overdraft){
            if(super.getBalance() - money < -1000){
                System.out.println("Non allowed overdraft!");
                return null;
            }
            Transaction newTransaction = new Transaction(0, money);
            super.getTransactions().add(newTransaction);
            return newTransaction;
        }
        return null;
    }
}

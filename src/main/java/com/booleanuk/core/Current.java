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
            Transaction newTransaction = new Transaction(0, money);
            super.getTransactions().add(newTransaction);
        }
        return null;
    }
}

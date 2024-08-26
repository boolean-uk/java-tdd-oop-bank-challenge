package com.booleanuk.core;

public class Current extends Account{

    private boolean overdraft;

    public Current(){
        super(1.2);
        overdraft = false;
    }

    public Transaction overdraft(int money){
        return null;
    }

    public boolean getOverdraft(){
        return overdraft;
    }

    public void toggleOverdraft(){
        overdraft = !overdraft;
    }
}

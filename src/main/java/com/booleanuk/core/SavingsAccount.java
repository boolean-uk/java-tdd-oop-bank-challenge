package com.booleanuk.core;

public class SavingsAccount extends Account{
    public SavingsAccount(Branch branch){
        super(branch);
    }

    @Override
    public void requestOverdraft(){
        System.out.println("Overdrafting a savings account is not allowed.");
    }

    /*
    The following functionality is meant for the manager only.
     */

    @Override
    public void rejectOverdraftRequest(){
        System.out.println("Overdrafting a savings account is not allowed.");
    }

    @Override
    public void acceptOverdraftRequest(){
        System.out.println("Overdrafting a savings account is not allowed.");
    }
}

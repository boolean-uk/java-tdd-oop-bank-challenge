package com.booleanuk.core;

// The CurrentAccount class inherits from the account class and has the ability to grant overdrafts up to 1000
public class CurrentAccount extends Account{

    CurrentAccount(double amount, String branch){
        super(amount, branch);
    }
    public void requestOverdraft(){
        overdraftRequest=true;
    }

    public boolean isOverdraftRequest() {
        return overdraftRequest;
    }

    public boolean isOverdraft() {
        return overdraft;
    }

    public boolean answerOverdraft(boolean answer){
        if (overdraftRequest){
            overdraft=answer;
            return true;
        }
        return false;
    }
}

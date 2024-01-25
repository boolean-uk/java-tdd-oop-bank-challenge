package com.booleanuk.core;

public class CurrentAccount extends Account{
    public boolean setOverdraft(int overdraft){
        if (overdraft < 5000){
            this.overdraft = -overdraft;
            return true;
        }
        System.out.println("Cannot set overdraft to >5000");
        return false;
    }
}

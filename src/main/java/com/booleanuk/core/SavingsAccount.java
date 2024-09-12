package com.booleanuk.core;

public class SavingsAccount extends Account{
    public SavingsAccount(Balance balance){
        super(balance);
    }
    public SavingsAccount(int intPart, int decimalPart){
        super(intPart,decimalPart);
    }

}

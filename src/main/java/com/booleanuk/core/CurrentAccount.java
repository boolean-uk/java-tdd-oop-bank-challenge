package com.booleanuk.core;

public class CurrentAccount extends Account{
    public CurrentAccount(Balance balance){
        super(balance);
    }
    public CurrentAccount(int intPart, int decimalPart){
        super(intPart,decimalPart);
    }
}

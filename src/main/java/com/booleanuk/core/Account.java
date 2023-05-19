package com.booleanuk.core;

public class Account {
    private Balance balance;
    public Account(Balance balance){
        setBalance(balance);
    }
    public Account(int intPart, int decimalPart){
        setBalance(new Balance(intPart,decimalPart));
    }
    //setBalance is private because i don't want any other class to use it.
    private void setBalance(Balance balance) {
        if(balance.getIntPart()>5){
            this.balance = balance;
        }else{
            System.out.println("When opening an account, a minimum of $5 is required as an original deposit");
        }
    }
    public Balance getBalance(){
        return this.balance;
    }
}

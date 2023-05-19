package com.booleanuk.core;

public class Account {
    private Balance balance;
    public Account(Balance balance){
        setBalance(balance);
    }
    public Account(int intPart, int decimalPart){
        setBalance(new Balance(intPart,decimalPart));
    }
    //setBalance is private because I don't want any other class to use it.
    private void setBalance(Balance balance) {
        if(balance.getIntPart()>5){
            this.balance = balance;
        }else if(balance.getIntPart()<0){
            System.out.println("Cannot open an account with a negative balance!");
        }else{
            System.out.println("When opening an account, a minimum of $5 is required as an original deposit!");
        }
    }
    public Balance getBalance(){
        return this.balance;
    }
    public boolean withdraw(Balance toWithdraw){
        if(this.getBalance().getIntPart()>toWithdraw.getIntPart() && this.getBalance().getDecimalPart()>toWithdraw.getDecimalPart()){
            System.out.println("Withdrew "+toWithdraw.toString()+" ");
            this.balance.interact(new Balance(-toWithdraw.getIntPart(),-toWithdraw.getDecimalPart()));
            return true;
        }
        return false;
    }
    public boolean deposit(Balance toDeposit){

    }
}

package com.booleanuk.core;

public class CurrentAccount extends Account{
    private boolean canOverdraft = false;
    public CurrentAccount(Balance balance){
        super(balance);
    }
    public CurrentAccount(int intPart, int decimalPart){
        super(intPart,decimalPart);
    }
    public boolean withdraw(Balance toWithdraw){
        if(this.getBalanceByStatements().getIntPart()>toWithdraw.getIntPart()){
            System.out.println("Withdrew "+toWithdraw.toString()+" ");
            this.getBalance().interact(new Balance(-toWithdraw.getIntPart(),-toWithdraw.getDecimalPart()));
            this.addToStatements(new Balance(-toWithdraw.getIntPart(), -toWithdraw.getDecimalPart()));
            return true;
        }
        if(canOverdraft){
            System.out.println("Withdrew "+toWithdraw.toString()+" ");
            this.getBalance().interact(new Balance(-toWithdraw.getIntPart(),-toWithdraw.getDecimalPart()));
            this.addToStatements(new Balance(-toWithdraw.getIntPart(), -toWithdraw.getDecimalPart()));
            return true;
        }
        return false;
    }
    public void requestOverdraft(Manager manager){
        this.canOverdraft = manager.getCanOverdraft();
    }
}

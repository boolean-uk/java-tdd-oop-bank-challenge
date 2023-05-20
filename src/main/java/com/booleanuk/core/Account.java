package com.booleanuk.core;

public class Account {
    private Balance balance;
    private String statements;
    public Account(Balance balance){
        setBalance(balance);
        this.statements = "";
    }
    public Account(int intPart, int decimalPart){
        setBalance(new Balance(intPart,decimalPart));
        this.statements = "";
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
            this.addToStatements(toWithdraw);
            return true;
        }
        return false;
    }
    public boolean deposit(Balance toDeposit){
        if(toDeposit.getDecimalPart()>=0 && toDeposit.getIntPart()>0){
            System.out.println("Successfully deposited "+toDeposit);
            this.balance.interact(new Balance(toDeposit.getIntPart(),toDeposit.getDecimalPart()));
            this.addToStatements(toDeposit);
            return true;
        }

        return false;
    }
    public void addToStatements(Balance balance){
        this.statements+= "Transaction: "+balance.toString()+"\n";
    }
    public String showStatements(){
        System.out.println(statements);
        return this.statements;
    }

}

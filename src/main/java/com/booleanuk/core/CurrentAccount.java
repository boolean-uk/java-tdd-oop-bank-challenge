package com.booleanuk.core;

public class CurrentAccount extends Account{

    private double overdraftLimit;

    CurrentAccount(AccountOwner owner) {
        super(owner);

        //Setting overdraft as 1000 for now
        this.overdraftLimit = 1000.0;
    }

    public double getOverdraftLimit(){
        return overdraftLimit;
    }

    @Override
    public String deposit(double amount) {

        Transaction depositTransaction = new Transaction(amount, 0, getBalance());
        getBankStatement().add(depositTransaction);

        setBalance(getBalance() + amount);

        return "New Balance: " + getBalance() + "£";
    }

    @Override
    public String withdraw(double amount) {
        if (amount <= getBalance() + overdraftLimit){

            if (amount > getBalance()){
                double overdraft = amount - getBalance();

                overdraftLimit -= overdraft;
            }

            Transaction withdrawTransaction = new Transaction(0, amount, getBalance());
            getBankStatement().add(withdrawTransaction);

            setBalance(getBalance() - amount);

            return "New Balance: " + getBalance() + "£";
        }

        else {
            return "Insufficient Funds";
        }

    }

}

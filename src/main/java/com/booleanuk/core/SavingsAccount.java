package com.booleanuk.core;

public class SavingsAccount extends Account{
    public SavingsAccount(Branch branch){
        super(branch);
    }
    public void withdraw(double amount) {
        if (amount <= getBalance()) {
            System.out.println("It will take approximately 1 minute to withdraw from your savings account");
            try {
                Thread.sleep(60000);
            }catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Withdraw was interrupted");
                return;
            }
            super.withdraw(amount);
        } else {
            System.out.println("Not enough money in savings account");
        }
    }

}

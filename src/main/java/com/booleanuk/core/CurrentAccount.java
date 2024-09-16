package com.booleanuk.core;

public class CurrentAccount extends Account {

    public CurrentAccount(String accountNumber, double balance, String accountType) {
        super(accountNumber, balance, "CurrentAccount");

    }

    // extra method for withdrawing from CurrentAccount, you can withdraw till -500
    @Override
    public boolean withdrawAmount(double withdraw) {
        if (withdraw >= 0.00 && this.getBalance() >= -500.00) {
            double newBalance = this.getBalance() - withdraw;
                this.setBalance(newBalance);
                Transaction transaction = new Transaction(this.date, withdraw, 0.00, newBalance);
                addToTransactionHistory(transaction);
                System.out.println("checking if withdraw works" + transaction);
                return true;
            } else {
                System.out.println("balance can't get below -500.00");
                return false;
            }
        }
    }



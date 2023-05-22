package com.booleanuk.core;

public class Bank {

    public static void main(String[] args) {
        BankAccount currentAccount = new CurrentAccount();
        BankAccount savingsAccount = new SavingsAccount(1000);

        new Transaction("deposit", 200, currentAccount);
        new Transaction("deposit", 250, currentAccount);
        new Transaction("withdraw", 100, currentAccount);
        new Transaction("withdraw", 250, currentAccount);
        new Transaction("deposit", 1000, savingsAccount);

        currentAccount.printStatement();
        savingsAccount.printStatement();

    }
}

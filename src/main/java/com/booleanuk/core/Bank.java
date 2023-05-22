package com.booleanuk.core;


public class Bank {
    public static void main(String[] args) {
        Branch branchLondon = new Branch("New Bank", "London");
        BankAccount currentAccount = new CurrentAccount(branchLondon, 100);

        new Transaction("deposit", 200, currentAccount);
        new Transaction("deposit", 250, currentAccount);
        new Transaction("withdraw", 100, currentAccount);
        new Transaction("withdraw", 250, currentAccount);
        new Transaction("withdraw", 250, currentAccount);

        currentAccount.setHasOverdraft(true);
        currentAccount.setOverdraft(100.00);
        new Transaction("withdraw", 250, currentAccount);

        currentAccount.printStatement();
    }
}

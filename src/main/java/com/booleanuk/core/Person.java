package com.booleanuk.core;

import java.util.Random;

public abstract class Person {
    private String name;
    private int UID;

    public Person(String name, int UID) {
        this.setName(name);
        this.setUID(UID);
    }

    public boolean createCurrentAccount(Branch branch) {
        try {
            CurrentAccount currentAccount = new CurrentAccount(branch, generateAccountNumber(branch), this, 0.0);
            branch.getCurrentAccounts().put(currentAccount.getAccountNumber(), currentAccount);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public boolean createSavingsAccount(Branch branch) {
        try {
            SavingsAccount savingsAccount = new SavingsAccount(branch, generateAccountNumber(branch), this, 0.0);
            branch.getSavingsAccounts().put(savingsAccount.getAccountNumber(), savingsAccount);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public void generateBankStatement() {
        System.out.println("");
    }

    public boolean deposit() {
        return false;
    }

    public boolean withdraw() {
        return false;
    }

    public int generateAccountNumber(Branch branch) {
        Random random = new Random(123);
        int accountNumber = 0;
        do {
            accountNumber = random.nextInt(10000000, 100000000);
        } while (branch.getCurrentAccounts().containsKey(accountNumber) || branch.getSavingsAccounts().containsKey(accountNumber));
        return accountNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getUID() {
        return UID;
    }

    public void setUID(int ID) {
        this.UID = ID;
    }
}

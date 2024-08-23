package com.booleanuk.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Bank {
    private int idCounter;
    private final HashMap<Integer, Account> accounts;
    private final ArrayList<String> branches;

    public Bank() {
        this.idCounter = 0;
        this.accounts = new HashMap<>();
        this.branches = new ArrayList<>();
        this.branches.add("Private");
        this.branches.add("Company");
    }

    public int createAccount(String type, String branch) {
        Account newAccount;
        if (!this.branches.contains(branch)) {
            System.out.println("No such branch exists.");
            return -1;
        }
        if (type.equals("Savings")) {
            newAccount = new SavingsAccount(this.idCounter, branch);
        } else if (type.equals("Current")) {
            newAccount = new CurrentAccount(this.idCounter, branch, this);
        } else {
            System.out.println("That is not a correct type of account.");
            return -1;
        }
        this.accounts.put(idCounter, newAccount);
        this.idCounter++;
        return newAccount.getId();
    }

    public boolean deposit(int id, int amount) {
        if (this.accounts.containsKey(id)) {
            return this.accounts.get(id).deposit(amount);
        }
        System.out.println("No such account exists.");
        return false;
    }

    public boolean withdraw(int id, int amount) {
        if (accounts.containsKey(id)) {
            return accounts.get(id).withdraw(amount);
        }
        System.out.println("No such account exists.");
        return false;
    }

    public int calculateOverdraft() {
        return 250*this.accounts.size();
    }

    public void printBankStatements(int id) {
        if (this.accounts.containsKey(id)) {
            List<String> transactionStrings = this.accounts.get(id).printBankStatements();
            System.out.println("|| date                          || credit   || debit    || balance  ||");
            for (String string : transactionStrings) {
                System.out.println(string);
            }
        }
    }

    public int getIdCounter() {
        return idCounter;
    }


    public Account getAccount(int id) {
        if (this.accounts.containsKey(id)) {
            return this.accounts.get(id);
        }
        System.out.println("No such account exists.");
        return null;
    }
}

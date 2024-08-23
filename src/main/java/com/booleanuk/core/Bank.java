package com.booleanuk.core;

import java.util.ArrayList;
import java.util.HashMap;

public class Bank {
    private int idCounter;
    private HashMap<Integer, Account> accounts;
    private ArrayList<String> branches;

    public Bank() {
        this.idCounter = 0;
        this.accounts = new HashMap<>();
        this.branches = new ArrayList<>();
        this.branches.add("Private");
        this.branches.add("Company");
    }

    public int createAccount(String type, String branch) {
        Account newAccount;
        if (!branches.contains(branch)) {
            System.out.println("No such branch exists.");
            return -1;
        }
        if (type.equals("Savings")) {
            newAccount = new SavingsAccount(idCounter, branch);
        } else if (type.equals("Current")) {
            newAccount = new CurrentAccount(idCounter, branch, this);
        } else {
            System.out.println("That is not a correct type of account.");
            return -1;
        }
        accounts.put(idCounter, newAccount);
        this.idCounter++;
        return newAccount.getId();
    }

    public int calculateOverdraft() {
        return 0;
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

package com.booleanuk.core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Bank {

    private List<Account> accounts;

    private HashMap<Account, Branch> accountsBranch;
    private List<Branch> listOfBranches = new ArrayList<>();

    public Bank() {
        this.accounts = new ArrayList<>();
        this.accountsBranch = new HashMap<>();
    }

    public HashMap<Account, Branch> getAccountsBranch() {
        return accountsBranch;
    }

    public void addAccount(Account account) {
        if (!accounts.contains(account)) {
            accounts.add(account);
            System.out.println("account added successfully");
        } else {
            System.out.println("account already exists");
        }
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void bankStatement(Account account) {
        System.out.println("Bank Statement for Account Number: " + account.getAccountNumber());
        List<Transaction> transactions = account.getHistory();
        Collections.reverse(transactions);

        System.out.println("date\t\t\t\t|| credit\t\t\t|| debit\t\t\t || balance");
        for (Transaction transaction : transactions) {
            System.out.println(transaction.getDate() +
                    "\t\t\t|| " + (transaction.getCredit() != 0 ? transaction.getCredit() : "\t\t") +
                    "\t\t\t|| " + (transaction.getDebit() != 0 ? transaction.getDebit() : "\t\t") +
                    "\t\t\t || " + transaction.getBalance());
        }
    }
    public double printBalance(Account account) {
        double balance = 0;

        List<Transaction> transactions = account.getHistory();
        for (Transaction transaction : transactions) {
            balance += transaction.getCredit();
            balance -= transaction.getDebit();
        }
        return balance;
    }

    public void addAccountAtBranch(Account account, String branchName) {
        fillBranches();
        if (!branchName.equals("") && accounts.contains(account)) {
            for (Branch this_branch: listOfBranches) {
                if (this_branch.getBranchName().equals(branchName)) {
                    accountsBranch.put(account, this_branch);
                }
            }
            System.out.println("account added successfully on " + branchName);
        } else {
            System.out.println("empty name or account doesn't exist");
        }
    }

    public void fillBranches() {
        listOfBranches.add(new Branch("JPMorgan Chase Bank", "270 Park Avenue, New York"));
        listOfBranches.add(new Branch("Bank of America", "333 South Hope Street, Los Angeles"));
        listOfBranches.add(new Branch("Wells Fargo Bank", "420 Montgomery Street, San Francisco"));
        listOfBranches.add(new Branch("Citibank", "69 West Washington Street, Chicago"));
    }
}

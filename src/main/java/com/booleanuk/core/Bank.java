package com.booleanuk.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Bank {
    List<Account> accountsList;
    ArrayList<Transaction> transactions;
    public Bank() {
        this.accountsList = new ArrayList<>();
        this.transactions = new ArrayList<>();
    }
    public boolean createAccount(Account account){
        if (accountsList.contains(account)) {
            System.out.println("Account already registered");
            return false;
        }
        accountsList.add(account);
        System.out.println("Account created successfully");
        return true;
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }
    public String generateBankStatement() {
        StringBuilder res = new StringBuilder();

        res.append(String.format("%-25s", "date "));
        res.append(String.format("%-15s", "credit"));
        res.append(String.format("%-15s", "debit"));
        res.append(String.format("%-15s", "balance"));
        res.append("\n");

        for (Transaction transaction : transactions) {
            res.append(String.format("%-25s", transaction.getDateTime()));
            res.append(String.format("%-15s", transaction.getCredit()));
            res.append(String.format("%-15s", transaction.getDebit()));
            res.append(String.format("%-15s", transaction.getBalance()));
            res.append("\n");
        }
        return res.toString();

    }


}


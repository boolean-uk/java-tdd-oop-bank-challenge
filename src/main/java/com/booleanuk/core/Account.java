package com.booleanuk.core;

import java.util.ArrayList;
import java.util.List;

public class Account {
    final static List<Account> accounts = new ArrayList<>();
    final List<ITransaction> transactions = new ArrayList<>();
    final String branch;
    public boolean overdraft;

    protected Account(String branch) {
        this.branch = branch;
    }

    public static Account create(String branch) {
        Account account = new Account(branch);
        accounts.add(account);
        return account;
    }

    public boolean transaction(ITransaction transaction) {
        if(transaction instanceof Withdraw && transaction.amount() > balance()) return false;

        transactions.add(transaction);
        return true;
    }

    public void statement() {
        String result = "\nStatement:" +
                "\ndate        || deposit     || withdraw     || balance";
        for(int i = transactions.size()-1; i > -1; i--) {
            result += transactions.get(i);
        }
        System.out.println(result);
    }

    public double balance() {
        if(transactions.size() < 1) return 0.0;
        return transactions.get(transactions.size() - 1).balance();
    }
}

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

        this.transactions.add(transaction);
        return true;
    }

    public void statement() {
        StringBuilder result = new StringBuilder("""

                Statement:
                date        || deposit     || withdraw     || balance""");

        double balance = balance();
        for(int i = transactions.size()-1; i > -1; i--) {
            result.append(transactions.get(i)).append(balance);
            balance -= transactions.get(i).signedAmount();
        }
        result.append("\n");
        System.out.println(result);
    }

    public double balance() {
        if(this.transactions.size() < 1) return 0.0;
        return this.transactions.stream().reduce(0.0, (x, y) -> x + y.signedAmount(), Double::sum);
    }
}

package com.booleanuk.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Account {
    final static List<Account> accounts = new ArrayList<>();
    final Stack<ITransaction> transactions = new Stack<>();
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
        Stack<ITransaction> transactions = (Stack<ITransaction>) this.transactions.clone();
        String result = "\nStatement:" +
                "\ndate        || deposit     || withdraw     || balance";
        while(transactions.size() > 0) {
            double balance = transactions.stream().reduce(0.0, (x, y) -> x + y.signedAmount(), Double::sum);
            result += transactions.pop() + "" + balance;
        }
//        for(int i = transactions.size()-1; i > -1; i--) {
//            result += transactions.get(i);
//        }
        result += "\n";
        System.out.println(result);
    }

    public double balance() {
        if(this.transactions.size() < 1) return 0.0;
//        return this.transactions.get(transactions.size() - 1).balance();
        return this.transactions.stream().reduce(0.0, (x, y) -> x + y.signedAmount(), Double::sum);
    }
}

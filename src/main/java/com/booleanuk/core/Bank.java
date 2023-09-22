package com.booleanuk.core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Bank {

    private List<Account> accounts;

    public Bank() {
        this.accounts = new ArrayList<>();
    }

    public void addAccount(Account account) {
        accounts.add(account);
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
}

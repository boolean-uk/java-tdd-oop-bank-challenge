package com.booleanuk.core;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class Account {
    private final ArrayList<Transaction> transactions;
    private final BankBranch branch;
    private boolean overdraft;

    Account(BankBranch branch) {
        this.transactions = new ArrayList<>(List.of(new Transaction(LocalDate.now(), 0, 0)));
        this.branch = branch;
        this.overdraft = false;
    }

    public double getBalance() {
        return getLastTransaction().balance;
    }

    public String getBranch() {
        return branch.toString();
    }

    public boolean deposit(double amount) {
        if (amount <= 0) {
            return false;
        } else {
            transactions.add(new Transaction(LocalDate.now(), amount, getLastTransaction().balance + amount));
            return true;
        }
    }

    public boolean withdraw(double amount) {
        amount = -amount;
        if (amount >= 0) {
            return false;
        } else {
            if (getLastTransaction().balance + amount < 0 && overdraft) {
                transactions.add(new Transaction(LocalDate.now(), amount, getLastTransaction().balance + amount));
                return true;
            } else {
                return false;
            }
        }
    }

    public void printStatement() {
        int width = 15;
        System.out.printf("%-" + width + "s", "Date");
        System.out.printf("%-" + width + "s", "Credit");
        System.out.printf("%-" + width + "s", "Debit");
        System.out.printf("%-" + width + "s", "Balance");
        System.out.println();
        transactions.forEach(transaction -> {
            System.out.printf("%-" + width + "s", transaction.date);
            if (transaction.amount > 0) {
                System.out.printf("%-" + width + "s", transaction.amount);
                System.out.printf("%-" + width + "s", "");
            } else if (transaction.amount < 0) {
                System.out.printf("%-" + width + "s", "");
                System.out.printf("%-" + width + "s", transaction.amount);
            } else {
                System.out.printf("%-" + width + "s", "");
                System.out.printf("%-" + width + "s", "");
            }
            System.out.printf("%-" + width + "s", transaction.balance);
            System.out.println();
        });
    }

    public void requestOverdraft() {
        if (!overdraft) {
            BankManager.OVERDRAFT_REQUESTS.add(this);
        }
    }

    public void setOverdraft() {
        this.overdraft = !this.overdraft;
    }

    private Transaction getLastTransaction() {
        return transactions.get(transactions.size()-1);
    }
}

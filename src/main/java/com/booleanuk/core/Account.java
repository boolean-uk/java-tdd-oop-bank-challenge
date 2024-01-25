package com.booleanuk.core;

import java.text.SimpleDateFormat;
import java.util.*;

public class Account {
    private String accountId;
    private Customer customer;
    private Branch branch;
    private List<Transaction> transactions;

    public Account(String accountId, Customer customer, Branch branch) {
        this.accountId = accountId;
        this.customer = customer;
        this.branch = branch;
        this.transactions = new ArrayList<>();
    }

    public String getAccountId() {
        return this.accountId;
    }
    public Customer getCustomer() {
        return this.customer;
    }

    public Branch getBranch() {
        return branch;
    }

    public double getBalance() {
        double bal = 0;
        for (Transaction transaction : this.transactions) {
            if (transaction.getType().equals("Credit")) {
                bal+= transaction.getAmount();
            } else if (transaction.getType().equals("Debit")) {
                bal-= transaction.getAmount();
            }
        }
        return bal;
    }
    public List<Transaction> getTransactions() {
        return transactions;
    }

    public String getBankStatement() {
        if (transactions.isEmpty()) {
            return "No transactions";
        }
        List<Transaction> sortedList = new ArrayList<>(this.transactions.stream().sorted(Comparator.comparing(Transaction::getDate)).toList());
        Collections.reverse(sortedList);

        SimpleDateFormat DateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Date                 || Credit   || Debit    || Balance  ").append("\n");

        for (Transaction transaction: sortedList) {
            stringBuilder.append(String.format("%" + "s%s%" + (21-DateFormat.format(transaction.getDate()).length()) + "s", "", DateFormat.format(transaction.getDate()), "")).append("|| ");
            if (transaction.getType().equals("Debit")) {
                stringBuilder.append("         || ");
            }
            stringBuilder.append(String.format("%" + "s%s%" + (9-Double.toString(transaction.getAmount()).length()) + "s", "", transaction.getAmount(), "")).append("|| ");
            if (transaction.getType().equals("Credit")) {
                stringBuilder.append("         || ");
            }
            stringBuilder.append(String.format("%" + "s%s%" + (9-Double.toString(transaction.getBalance()).length()) + "s", "", transaction.getBalance(), "")).append("\n");
        }

        return stringBuilder.substring(0,stringBuilder.length()-1);
    }

    public String withdraw(double amount) {
        if (amount < 0) {
            return "The amount cannot be a negative number";
        } else if (this.getBalance()-amount < 0) {
            return "Withdraw failed. Amount withdrawn is more than balance in account";
        }
        this.transactions.add(new Transaction(new Date(), amount, TransactionType.WITHDRAW, this.getBalance()));
        return "Withdraw successful. $"+amount+" has been withdrawn";
    }

    public String deposit(double amount) {
        if (amount < 0) {
            return "The amount cannot be a negative number";
        }
        this.transactions.add(new Transaction(new Date(), amount, TransactionType.DEPOSIT, this.getBalance()));
        return "$"+amount+" deposited";
    }

    public String requestOverdraft(double amount) {
        if (amount < 0) {
            return "Amount cannot be negative";
        }
        this.branch.addOverdraftRequest(this, amount);
        return "Overdraft of $"+amount+" requested";
    }
}

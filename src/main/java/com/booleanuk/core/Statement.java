package com.booleanuk.core;

import java.util.List;
import java.util.ArrayList;

public class Statement {

    private Account account;
    private List<Transaction> transactions = new ArrayList<Transaction>();

    public Statement(Account account) {
        this.account = account;
    }

    public Statement(Account account, List<Transaction> transactions) {
        this.account = account;
        this.transactions = transactions;
    }

    public Account getAccount() {
        return account;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void addTransaction(Transaction transaction) {

        this.transactions.add(transaction);
    }

    public String generateStatement() {
        StringBuilder sb = new StringBuilder();
        sb.append("             Date             || credit       || debit        || balance\n");

        for (Transaction transaction : transactions) {
            double balance = 0;

            String credit = "";
            String debit = "";

            if (transaction.getTransactionType().equals("Deposit")) {
                credit = String.format("%-12s", String.format("%.2f", transaction.getTransactionAmount()));
                balance += transaction.getTransactionAmount();
            } else if (transaction.getTransactionType().equals("Withdraw")) {
                debit = String.format("%-12s", String.format("%.2f", transaction.getTransactionAmount()));
                balance -= transaction.getTransactionAmount();
            }

            sb.append(String.format("%-26s || %-12s || %-12s || %.2f\n",
                    transaction.getTransactionDate(), credit, debit, balance));
        }

        return sb.toString();
    }

}

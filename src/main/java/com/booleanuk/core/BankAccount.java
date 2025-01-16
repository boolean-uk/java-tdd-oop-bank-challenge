package com.booleanuk.core;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public abstract class BankAccount {
    private String branch;
    private HashMap<Integer, Transaction> transactions;
    private int accountNumber;
    private double balance;

    public BankAccount(String branch, HashMap<Integer, Transaction> transactions, int accountNumber, double balance) {
        this.branch = branch;
        this.transactions = transactions;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public double getBalance() {
        Collection<Transaction> collection = transactions.values();
        double balance = 0;
        for (Transaction transaction : collection) {
            if (Objects.equals(transaction.getType(), "credit")) {
                balance += transaction.getAmount();
            } else {
                balance -= transaction.getAmount();
            }
        }
        return balance;
    }

    public String deposit(double amount) {
        int ID = (int) (Math.random()* 90000) + 10000;
        String type = "credit";
        String date = LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        double balanceAfter = balance += amount;
        transactions.put(ID, new Transaction(ID, type, amount, date, balanceAfter));
        return "Deposit successfull!";
    }

    public String withdraw(double amount) {
        int ID = (int) (Math.random()* 90000) + 10000;
        String type = "debit";
        String date = LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        double balanceAfter = balance -= amount;
        transactions.put(ID, new Transaction(ID, type, amount, date, balanceAfter));
        return "Withdraw successfull!";
    }

    public String generateBankStatement() {
        StringBuilder bankStatement = new StringBuilder();
        List<Transaction> sortedTransactions = new ArrayList<>(transactions.values());
        sortedTransactions.sort(Comparator.comparing(Transaction::getDate).reversed());
        bankStatement.append("date || credit || debit || balance\n");
        for (Transaction transaction : sortedTransactions) {
            String date = LocalDateTime.parse(transaction.getDate()).format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
            String credit = transaction.getType().equals("credit") ? String.valueOf(transaction.getAmount()) : "";
            String debit = transaction.getType().equals("debit") ? String.valueOf(transaction.getAmount()) : "";
            String balance = String.valueOf(transaction.getBalanceAfter());

            bankStatement.append(date).append(" || ").append(credit).append(" || ").append(debit).append(" || ").append(balance).append("\n");
        }
        return bankStatement.toString();
    }
}

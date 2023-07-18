package com.booleanuk.core;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Account {
    private ArrayList<Info> info;
    private int id;
    private String type;
    private int balance;

    private int customerId;

    public Account(int accountId, String accountType, int initDeposit) {
        this.id = accountId;
        this.type = accountType;
        this.balance = initDeposit;
        this.info = new ArrayList<>();
    }

    public Account(int accountId, String accountType){
        this.id = accountId;
        this.type = accountType;
        this.info = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public int getBalance() {
        return balance;
    }
    public ArrayList<Info> getInfo() {
        return info;
    }

    public void addWithdrawInfo(int amount) {
        LocalDateTime transactionDate = LocalDateTime.now();
        int newBalance = balance - amount;
        Info withdrawInfo = new Info(transactionDate, 0, amount, newBalance, customerId, id);
        info.add(withdrawInfo);
        balance = newBalance;
    }

    public void addDepositInfo(int amount) {
        LocalDateTime transactionDate = LocalDateTime.now();
        int newBalance = balance + amount;
        Info depositInfo = new Info(transactionDate, 0, amount, newBalance, customerId, id);
        info.add(depositInfo);
        balance = newBalance;
    }
    public void addDeposit(int amount, LocalDateTime dateTime) {
        int newBalance = balance + amount;
        Info depositInfo = new Info(dateTime, amount, newBalance, customerId, id, TransactionType.DEBIT);
        info.add(depositInfo);
        balance = newBalance;
    }

    public void addWithdrawal(int amount, LocalDateTime dateTime) {
        int newBalance = balance - amount;
        Info withdrawalInfo = new Info(dateTime, amount, newBalance, customerId, id, TransactionType.CREDIT);
        info.add(withdrawalInfo);
        balance = newBalance;
    }
    public void addDepositWithoutCalc(int amount, LocalDateTime dateTime) {
        int newBalance = getBalance() + amount;
        Info depositInfo = new Info(dateTime, amount, newBalance, customerId, id, TransactionType.DEBIT);
        info.add(depositInfo);
        balance = newBalance;
    }

    public void addWithdrawalWithoutCalc(int amount, LocalDateTime dateTime) {
        int newBalance = getBalance() - amount;
        if (newBalance < 0) {
            System.out.println("Insufficient funds.");
            return;
        }
        Info withdrawalInfo = new Info(dateTime, amount, newBalance, customerId, id, TransactionType.CREDIT);
        info.add(withdrawalInfo);
        balance = newBalance;
    }

    public void generateInfo(int amount, LocalDateTime dateTime, String transactionType) {
        if (transactionType.equalsIgnoreCase("debit")) {
            addDeposit(amount, dateTime);
        } else if (transactionType.equalsIgnoreCase("credit")) {
            addWithdrawal(amount, dateTime);
        } else {
            System.out.println("Invalid transaction type. Use 'debit' or 'credit'.");
        }
    }

    public void printBankStatement() {
        System.out.println(" date      || credit        || debit      || balance");
        System.out.println("------------------------------------------------------");
        for (Info transaction : info) {
            String credit = (transaction.getTransactionType() == TransactionType.DEBIT) ? String.format("%.2f", (double) transaction.getAmount()) : "";
            String debit = (transaction.getTransactionType() == TransactionType.CREDIT) ? String.format("%.2f", (double) transaction.getAmount()) : "";

            System.out.printf("%s || %13s || %10s || %.2f%n",
                    transaction.getDateTime().toLocalDate(),
                    credit,
                    debit,
                    (double) transaction.getBalance());
        }
    }
    public int calculateBalance() {
        int balance = 0;
        for (Info transaction : info) {
            if (transaction.getTransactionType() == TransactionType.DEBIT) {
                balance += transaction.getAmount();
            } else if (transaction.getTransactionType() == TransactionType.CREDIT) {
                balance -= transaction.getAmount();
            }
        }
        return balance;
    }
}

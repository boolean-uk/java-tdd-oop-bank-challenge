package com.booleanuk.core;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class BankAccount {
    private final String accountNumber;
    private final String branchNumber;
    private final List<Transaction> transactions;

    public BankAccount(int branchNumber) {
        Random random = new Random();
        int randomAccountNumber = random.nextInt(99999999);
        this.accountNumber = "0".repeat((int) (8 - Math.ceil(Math.log10(randomAccountNumber)))) + randomAccountNumber;
        if (branchNumber > 999999) {
            System.out.println("Invalid branch code (must be 6 digit number). Branch code will be set to 0.");
            branchNumber = 0;
        }
        this.branchNumber = "0".repeat((int) (6 - Math.ceil(Math.log10(branchNumber)))) + branchNumber;
        this.transactions = new ArrayList<>();
    }

    public BankAccount(String accountNumber, String branchNumber) {
        // todo: make sure numbers are OK length
        this.accountNumber = accountNumber;
        this.branchNumber = branchNumber;
        this.transactions = new ArrayList<>();
    }

    public boolean withdraw(double amount, LocalDateTime dateTime) {
        double balance = this.getBalance();
        if (amount <= balance) {
            balance -= amount;
            transactions.add(new Transaction(-amount, balance, dateTime));
        }
        return amount <= balance;
    }

    public boolean withdraw(double amount) {
        return this.withdraw(amount, LocalDateTime.now());
    }

    // maybe can be void... or maybe consider overflow?
    public boolean deposit(double amount, LocalDateTime dateTime) {
        double balance = this.getBalance();
        balance += amount;
        transactions.add(new Transaction(amount, balance, dateTime));
        return true;
    }

    public boolean deposit(double amount) {
        return this.deposit(amount, LocalDateTime.now());
    }

    // TODO Fix formatting
    public String generateBankStatement() {
        StringBuilder sb = new StringBuilder();
        sb.append("date\t||credit\t||debit\t||balance\n");

        for (Transaction t : transactions.reversed()) {
            sb.append(t.getDateTime().getDayOfMonth()).append("/")
                    .append(t.getDateTime().getMonthValue()).append("/")
                    .append(t.getDateTime().getYear()).append("||");
            if (t.getAmount() > 0) {
                sb.append(String.format("%.2f", Math.abs(t.getAmount()))).append("||\t");
            } else {
                sb.append("\t||").append(String.format("%.2f", Math.abs(t.getAmount())));
            }
            sb.append("||").append(String.format("%.2f", t.getCurrentBalance())).append("\n");
        }

        return sb.toString();
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        double balance = 0;
        for (Transaction t : transactions) {
            balance += t.getAmount();
        }
        return balance;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public String getBranchNumber() {
        return branchNumber;
    }
}

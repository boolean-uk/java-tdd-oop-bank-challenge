package com.booleanuk.core;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class BankAccount {
    private String accountNumber;
    private List<Transaction> transactionHistory;
    private Branch branch;
    public BankAccount(String accountNumber,Branch branch) {
        this.accountNumber = accountNumber;
        this.transactionHistory = new ArrayList<>();
        this.branch = branch;
        branch.addAccount(this);
    }

    public Branch getBranch() {
        return branch;
    }


    public String getAccountNumber() {
        return accountNumber;
    }

    public void deposit(BigDecimal amount, String date, String type) {
        transactionHistory.add(new Transaction(date, amount,type));
    }

    public void withdraw(BigDecimal amount, String date, String type) {
        transactionHistory.add(new Transaction(date, amount.negate(),type));
    }

    public BigDecimal getBalance() {
        BigDecimal balance = new BigDecimal("0.00");
        for (Transaction transaction : transactionHistory) {
            balance = balance.add(transaction.getAmount());
        }
        return balance;
    }
    public String generateBankStatement() {
        System.out.println("Bank Statement for Account Number: " + accountNumber);
        BigDecimal balance = new BigDecimal("0.00");
        StringBuilder statement = new StringBuilder();
        statement.append("Operation || Date || Amount || Balance");
        for (Transaction transaction : transactionHistory) {
            balance = balance.add(transaction.getAmount());
            statement.append(transaction.getOperationType()).append("\t").
                    append(transaction.getDate()).append("\t").
                    append(transaction.getAmount().abs()).append("\t").
                    append(balance).append("\n");
        }
        return statement.toString();
    }
    public void sendSmsWithStatement(){
        SmsSender sms = new SmsSender();
        sms.sendSMS(generateBankStatement());
    }
}

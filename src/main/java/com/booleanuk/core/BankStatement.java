package com.booleanuk.core;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

public class BankStatement {

    private String transactionDate;
    private double depositAmount;
    private double withdrawalAmount;
    private double balance;

    private ArrayList<Transaction> transactionList;

    public BankStatement() {
        transactionList = new ArrayList<>();
    }

    public BankStatement(String transactionDate, double depositAmount, double withdrawalAmount, double balance) {
        this.transactionDate = transactionDate;
        this.depositAmount = depositAmount;
        this.withdrawalAmount = withdrawalAmount;
        this.balance = balance;
    }

    //User Story 3
    //Comment: Somehow fails on my machine, but passes on GitHub and on Dave's machine.
    public String generateBankStatement(BankAffiliate bankAffiliate, BankAccount bankAccount) {
        //DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy"); // Format the date as "dd/MM/yyyy"
        StringBuilder bankStatementOutput = new StringBuilder();
        bankStatementOutput.append("\n");

        bankStatementOutput.append("Date       || Deposit  || Withdrawal || Balance\n");

        for (Transaction transaction : bankAccount.getTransactionList()) {
            String balance = String.format("%.2f", transaction.getBalance()); // Format balance with two decimal places

            // Initialize transaction columns with spaces
            String depositAmount = "        ";
            String withdrawalAmount = "         ";

            // Set transaction amount based on type
            if (transaction.getType().equals("Deposit")) {
                depositAmount = String.format("%.2f", transaction.getAmount());
            } else if (transaction.getType().equals("Withdrawal")) {
                withdrawalAmount = String.format("%.2f", transaction.getAmount());
            }

            // Append the formatted transaction line to the StringBuilder
            bankStatementOutput.append(String.format("%-10s || %-8s || %-10s || %s%n", transaction.getDate(), depositAmount, withdrawalAmount, balance));
        }

        return bankStatementOutput.toString();
    }

    public String getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
    }

    public double getDepositAmount() {
        return depositAmount;
    }

    public void setDepositAmount(double depositAmount) {
        this.depositAmount = depositAmount;
    }

    public double getWithdrawalAmount() {
        return withdrawalAmount;
    }

    public void setWithdrawalAmount(double withdrawalAmount) {
        this.withdrawalAmount = withdrawalAmount;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public ArrayList<Transaction> getTransactionList() {
        return transactionList;
    }

    public void setTransactionList(ArrayList<Transaction> transactionList) {
        this.transactionList = transactionList;
    }
}

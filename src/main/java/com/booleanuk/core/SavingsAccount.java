package com.booleanuk.core;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class SavingsAccount implements Account{
    private ArrayList<Transaction> transactions;
    private int uniqueID;
    private String branch;
    private double balance;

    public SavingsAccount(String branch, int uniqueID){
        this.branch = branch;
        this.uniqueID = uniqueID;
        this.balance = 0;
        this.transactions = new ArrayList<>();
    }



    public double newTransaction(double depositAmount, double withdrawAmount, int transactionID){
        Transaction t = new Transaction(depositAmount, withdrawAmount);

        transactions.add(t);

        double newBalance = calculateAccountBalance();
        return newBalance;
    }

    private double calculateAccountBalance(){
        double totalDeposit = 0;
        double totalWithdraw = 0;
        for (Transaction t: transactions){
            totalDeposit += t.getDepositAmount();
            totalWithdraw += t.getWithdrawAmount();
        }

        double newTotal = totalDeposit - totalWithdraw;
        return newTotal;
    }

    public String generateAccountStatement() {
        // Header for the account statement
        String headerFormat = "%-12s || %-10s || %-10s || %-10s\n";
        String rowFormat = "%-12s || %10s || %10s || %10s\n";

        System.out.println("Account ID: " );
        System.out.printf(headerFormat, "date", "credit", "debit", "balance");
        double balance = 0.0;

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        // Loop through the transactions and print the formatted statement
        for (Transaction t : transactions) {
            String date = t.getCurrentDateTime().format(formatter);

            // Get amounts
            double depositAmount = t.getDepositAmount();
            double withdrawAmount = t.getWithdrawAmount();
            balance += depositAmount;
            balance -= withdrawAmount;

            // Ternary operator to give bland space in case of no deposit/withdraw
            String creditStr = depositAmount > 0 ? String.format("%.2f", depositAmount) : "";
            String debitStr = withdrawAmount > 0 ? String.format("%.2f", withdrawAmount) : "";
            String balanceStr = String.format("%.2f", balance);

            //Display result
            System.out.printf(rowFormat, date, creditStr, debitStr, balanceStr);
        }

        return "";
    }
    /*
    public String generateAccountStatement() {
        // Header for the account statement
        System.out.println("date       || credit  || debit  || balance");

        // Variable to keep track of the running balance
        double balance = 0.0;

        // Loop through the transactions and print the formatted statement
        for (Transaction t : transactions) {
            LocalDateTime date = t.getCurrentDateTime();
            double depositAmount = t.getDepositAmount();
            double withdrawAmount = t.getWithdrawAmount();

            // Update the balance based on the transaction
            balance += depositAmount;

            balance -= withdrawAmount;
            System.out.printf("%s || %.2f  ||   %.2f      || %.2f\n", date, depositAmount, withdrawAmount, balance);

        }

        return "";
    }

     */


    public double getBalance(){
        return calculateAccountBalance();

    }
    public void setBalance(double newBalance){
        this.balance = newBalance;
    }


    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(ArrayList<Transaction> transactions) {
        this.transactions = transactions;
    }

    public int getUniqueID() {
        return uniqueID;
    }

    public void setUniqueID(int uniqueID) {
        this.uniqueID = uniqueID;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    @Override
    public String toString() {
        return "SavingsAccount{" +
                "transactions=" + transactions +
                ", uniqueID=" + uniqueID +
                ", branch='" + branch + '\'' +
                '}';
    }
}

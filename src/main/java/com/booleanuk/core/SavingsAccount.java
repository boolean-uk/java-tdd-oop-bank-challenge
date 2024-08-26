package com.booleanuk.core;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class SavingsAccount implements Account{
    private ArrayList<Transaction> transactions;
    private int uniqueID;
    private String branch;
    private double balance;
    private double overdraftAmount;
    private Bank bank;
    private Customer customer;

    public SavingsAccount(String branch, int uniqueID, Bank bank, Customer customer){
        this.branch = branch;
        this.uniqueID = uniqueID;
        this.balance = 0;
        this.transactions = new ArrayList<>();
        this.overdraftAmount = 0;
        this.bank = bank;
        this.customer = customer;
    }



    public double newTransaction(double depositAmount, double withdrawAmount, int transactionID){
        double currentBalance = calculateAccountBalance();
        double projectedBalance = currentBalance + depositAmount - withdrawAmount;

        if(projectedBalance< 0){
            //Check if account is allowed to overdraft
            if(overdraftAmount >= Math.abs(projectedBalance)){
                Transaction t = new Transaction(depositAmount, withdrawAmount);
                transactions.add(t);
                return projectedBalance;
            }else{
                System.out.println("This account is not allowed to overdraft this amount");
                return currentBalance;
            }
        }


        Transaction t = new Transaction(depositAmount, withdrawAmount);

        transactions.add(t);
        System.out.println("test");

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

    public void requestOverdraft(Double overdraftAmount){
        OverdraftRequest request = new OverdraftRequest(this.customer, this, 5000);
        bank.addOverdraftRequest(request);
        System.out.println("Overdraft request sent");


    }

    public void setOverdraftAmount(Double overdraftAmount){
        this.overdraftAmount = overdraftAmount;
    }

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

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
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

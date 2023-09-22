package com.booleanuk;

import com.booleanuk.core.BankManager;
import com.booleanuk.core.Branch;
import com.booleanuk.core.MessageService;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

public abstract class Account {

    private ArrayList<Transaction> transactions = new ArrayList<>();
    private Branch branch;
    private boolean overdraftRequest = false;
    private MessageService messageService;
    private String customerPhoneNumber;

    public Account() {
    }

    public Account(ArrayList<Transaction> transactions, Branch branch, MessageService messageService, String customerPhoneNumber) {
        this.transactions = new ArrayList<>(transactions);
        this.branch = branch;
        this.messageService = messageService;
        this.customerPhoneNumber = customerPhoneNumber;
    }

    public Account(Branch branch, String customerPhoneNumber, MessageService messageService) {
        this.branch = branch;
        this.customerPhoneNumber = customerPhoneNumber;
        this.messageService = messageService;
    }

    public double getCurrentBalance() {
        return transactions.isEmpty() ? 0.0 : transactions.get(transactions.size() - 1).getBalanceAtTime();
    }

    public Branch getBranch() {
        return branch;
    }

    public ArrayList<Transaction> getTransactions() {
        return new ArrayList<>(transactions);
    }

    public void deposit(double amount) {
        if (amount < 0.0) {
            throw new IllegalArgumentException("Please insert a positive number");
        }
        double balance = getCurrentBalance();
        balance += amount;
        transactions.add(new Transaction(new Date(), amount, balance, TransactionType.DEPOSIT));
        System.out.println("Deposited " + amount);
    }

    public void withdraw(double amount) {
        if (amount < 0.0) {
            throw new IllegalArgumentException("Please insert a positive number");
        }
        double balance = getCurrentBalance();
        if (amount > balance && !overdraftRequest) {
            throw new IllegalArgumentException("Insufficient funds. This transaction cannot be completed");
        }
        if (overdraftRequest) {
            double newBalance = balance - amount;
            transactions.add(new Transaction(new Date(), amount, newBalance, TransactionType.WITHDRAW));
            System.out.println("Withdrew " + amount);
        }
        double newBalance = balance - amount;
        transactions.add(new Transaction(new Date(), amount, newBalance, TransactionType.WITHDRAW));
        System.out.println("Withdrew " + amount);
    }

    public void generateBankStatement() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        System.out.printf("%-10s || %-10s || %-10s || %-10s%n", "date", "credit", "debit", "balance");
        ArrayList<Transaction> reversedTransactions = new ArrayList<>(transactions);
        Collections.reverse(reversedTransactions);
        for (Transaction transaction : reversedTransactions) {
            String formattedDate = sdf.format(transaction.getTransactionDate());
            double amount = transaction.getAmount();
            double balanceAtTime = transaction.getBalanceAtTime();
            TransactionType type = transaction.getType();

            double creditAmount = type == TransactionType.DEPOSIT ? amount : 0.0;
            double debitAmount = type == TransactionType.WITHDRAW ? amount : 0.0;

            System.out.printf("%-10s || %-10.2f || %-10.2f || %-10.2f%n",
                    formattedDate,
                    creditAmount,
                    debitAmount,
                    balanceAtTime);
        }
        String message = "Your bank statement has been generated. Check your phone!";
        messageService.sendSMS(customerPhoneNumber, message);
    }

    public boolean requestAnOverdraftAndWithdraw(double amount) {
       boolean isApproved = BankManager.evaluateRequest(amount, transactions);
       if (isApproved) {
           this.overdraftRequest = true;
           withdraw(amount);
           this.overdraftRequest = false;
       }
       return isApproved;
    }


}
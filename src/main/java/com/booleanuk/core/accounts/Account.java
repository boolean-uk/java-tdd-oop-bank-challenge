package com.booleanuk.core.accounts;

import com.booleanuk.core.users.Bank;
import com.booleanuk.core.users.Customer;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.time.format.DateTimeFormatter;


public abstract class Account {
    protected static long accountCount = 0;
    protected long id;
    protected List<Transaction> transactionHistory;
    protected Customer user;
    protected double maxOverdraft = 0.0;

    public Account(Customer user) {
        accountCount +=1;
        this.id = accountCount;
        this.user = user;
        this.transactionHistory = new ArrayList<>();
    }

    public void addTransaction(Transaction transaction){
        transaction.setAccount(this);
        this.transactionHistory.add(transaction);
        if (wouldOverdraft(transaction)){
            this.requestOverdraft(transaction);
        }else{
            transaction.setAccepted(true);
        }
    }

    public double calculateBalance(LocalDateTime dateTime){
        return this.transactionHistory.stream()
                .filter(transaction -> transaction.getDate().isBefore(dateTime))
                .filter(Transaction::isAccepted)
            .mapToDouble(Transaction::getAmount).sum();
    }

    private boolean wouldOverdraft(Transaction transaction){
        return this.calculateBalance(LocalDateTime.now()) + transaction.getAmount() < maxOverdraft;
    }

    private void requestOverdraft(Transaction transaction){
        Bank.getBankManagerList().stream()
                .filter(a->a.getBranchID().equals(user.getBranchID()))
                .findFirst().get()
                .addOverdraftRequest(transaction);
    }

    public static long getAccountCount() {
        return accountCount;
    }

    public long getId() {
        return id;
    }

    public List<Transaction> getTransactionHistory() {
        return transactionHistory;
    }

    public Customer getUser() {
        return user;
    }

    public double getMaxOverdraft() {
        return maxOverdraft;
    }

    public String printAccountStatement() {
        String s = "";
        s+= String.format("%-12s || %-10s || %-10s || %-10s%n", "Date", "Credit", "Debit", "Balance");
        s+="============================================== \n";

        double balance = 0.0;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        for (Transaction transaction : transactionHistory) {
            LocalDateTime date = transaction.getDate();
            String formattedDate = date.format(formatter);

            String credit = "";
            String debit = "";

            if (transaction.getAmount() > 0) {
                credit = String.format("%.2f", transaction.getAmount());
            } else {
                debit = String.format("%.2f", transaction.getAmount());
            }

            balance += transaction.getAmount();

            s += String.format("%-12s || %-10s || %-10s || %-10s%n", formattedDate, credit, debit, String.format("%.2f", balance));
        }
        return s;
    }

    public static void setAccountCount(long accountCount) {
        Account.accountCount = accountCount;
    }
}

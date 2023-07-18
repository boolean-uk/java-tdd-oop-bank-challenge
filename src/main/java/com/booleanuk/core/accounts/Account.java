package com.booleanuk.core.accounts;

import com.booleanuk.core.users.Bank;
import com.booleanuk.core.users.Customer;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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
}

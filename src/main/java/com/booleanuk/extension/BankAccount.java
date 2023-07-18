package com.booleanuk.extension;

import java.util.ArrayList;
import java.util.List;

public class BankAccount {
    protected final List<Transaction> transactions;
    protected final String branchCode;
    protected final String userPhoneNumber;

    public BankAccount(String branchCode, String userPhoneNumber) {
        this.transactions = new ArrayList<>();
        this.branchCode = branchCode;
        this.userPhoneNumber = userPhoneNumber;
    }

    public boolean deposit(int amount) {
        if (amount <= 0)
            return false;

        transactions.add(new Transaction(amount, true));
        return true;
    }

    public boolean withdraw(int amount) {
        if (amount <= 0 || getCurrentBalance() - amount < 0)
            return false;

        transactions.add(new Transaction(amount, false));
        return true;
    }

    protected boolean sendDepositNotification(Transaction transaction) {
        return false;
    }

    protected boolean sendWithdrawNotification(Transaction transaction) {
        return false;
    }

    protected int getCurrentBalance() {
        return transactions.stream()
                .map(t -> t.isDeposit() ? t.getAmount() : -t.getAmount())
                .reduce(Integer::sum)
                .orElse(0);
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public String getBranchCode() {
        return this.branchCode;
    }

    public String getUserPhoneNumber() {
        return this.userPhoneNumber;
    }

    public void clearAccount() {
        this.transactions.clear();
    }
}

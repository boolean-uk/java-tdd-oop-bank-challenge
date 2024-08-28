package com.booleanuk.core.accounts;

import com.booleanuk.core.idgenerator.IdGenerator;
import com.booleanuk.core.idgenerator.IdPrefix;
import com.booleanuk.core.transactons.Transaction;
import com.booleanuk.core.transactons.TransactionType;

import java.util.HashMap;
import java.util.Map;

public abstract class Account {

    private final String accountNumber;
    private Branch branch;
    private boolean isPossibleToOverdraft;
    private Map<String, Transaction> transactions;

    public Account() {
        this.accountNumber = new IdGenerator(IdPrefix.AC).getId();
        this.transactions = new HashMap<>();
    }

    public String getAccountNumber() {
        return this.accountNumber;
    }

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }

    public boolean isPossibleToOverdraft() {
        return isPossibleToOverdraft;
    }

    public void setPossibleToOverdraft(boolean possibleToOverdraft) {
        isPossibleToOverdraft = possibleToOverdraft;
    }

    protected void addTransaction(Transaction transaction) {
        this.transactions.put(transaction.getId(), transaction);
    }

    public void deposit(Double amount) {
        Transaction transaction = new Transaction(
                amount,
                TransactionType.DEBIT,
                calculateBalance()
        );
        this.addTransaction(transaction);
    }

    protected void validateOverdraft(Double currentBalance, Double withdrawAmount) throws Exception {
        boolean isNegativeBalance = (currentBalance - withdrawAmount) < 0;
        if (!this.isPossibleToOverdraft && isNegativeBalance) {

            // TODO: should make custom exception

            throw new Exception("Not possible to overdraft");
        }
    }

    public void withdraw(Double amount) {
        Double currentBalance = this.calculateBalance();
        try {
            this.validateOverdraft(currentBalance, amount);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        Transaction transaction = new Transaction(
                amount,
                TransactionType.CREDIT,
                currentBalance
        );
        this.addTransaction(transaction);
    }

    protected Double calculateBalance() {
        Double sum = 0.0;
        for (Transaction transaction : transactions.values()) {
            if (transaction.getType() == TransactionType.DEBIT) {
                sum += transaction.getAmount();
            } else if (transaction.getType() == TransactionType.CREDIT) {
                sum -= transaction.getAmount();
            }
        }
        return sum;
    }

    public Double getBalance() {
        return calculateBalance();
    }
}

package com.booleanuk.core.accounts;

import com.booleanuk.core.idgenerator.IdGenerator;
import com.booleanuk.core.idgenerator.IdPrefix;
import com.booleanuk.core.transactons.Transaction;
import com.booleanuk.core.transactons.TransactionType;

import java.util.*;

public abstract class Account {

    private IdGenerator idGenerator;
    private final String accountNumber;
    private Branch branch;
    private boolean isPossibleToOverdraft;
    private Map<String, Transaction> transactions;

    public Account(String accountNumber) {
        this.idGenerator = new IdGenerator();
        this.accountNumber = accountNumber;
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
                this.idGenerator.createId(IdPrefix.TR),
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
                this.idGenerator.createId(IdPrefix.TR),
                amount,
                TransactionType.CREDIT,
                currentBalance
        );
        this.addTransaction(transaction);
    }

    public ArrayList<Transaction> getAllTransactions() {
        ArrayList<Transaction> list = new ArrayList<>(transactions.values());
        Collections.reverse(list);

        return list;
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

    // TODO: printTransactionHistory
    public void printTransactionHistory() {
        System.out.println();
        System.out.printf("%s", "date", "||");
        for (Transaction transaction : transactions.values()) {
            System.out.println();
        }
    }
}

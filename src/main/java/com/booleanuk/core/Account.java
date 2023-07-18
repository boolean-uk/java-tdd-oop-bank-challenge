package com.booleanuk.core;

import com.booleanuk.core.enums.OVERDRAFT_STATE;
import com.booleanuk.core.enums.TRANSACTION_TYPE;

import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class Account {
    private final Customer customer;
    private final List<Transaction> transactions = new ArrayList<>();
    private final String accountNumber;
    private Branch branch;
    private OverdraftRequest request = null;

    Account(BigDecimal amount, Customer customer) {
        this.customer = customer;
        this.accountNumber = createAccountNumber();
        if (amount.compareTo(BigDecimal.ZERO) > 0) deposit(amount);
    }

    Account(Customer customer) {
        this.customer = customer;
        this.accountNumber = createAccountNumber();
    }

    Account(Customer customer, Branch branch){
        this.customer = customer;
        this.accountNumber = createAccountNumber();
        this.branch = branch;
    }

    public Branch getBranch() {
        return branch;
    }

    private String createAccountNumber() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 16; i++) {
            sb.append(random.nextInt(10));
        }

        return sb.toString();
    }

    public void deposit(BigDecimal amount) {
        createTransaction(amount, TRANSACTION_TYPE.CREDIT);
    }

    public void withdraw(BigDecimal amount) throws IllegalAccessException {

        if(this.getBalance().compareTo(amount) < 0) {
            if (this.request == null) {
                throw new IllegalStateException(
                String.format("Insufficient funds %s, cannot withdraw %s ", this.getBalance(), amount));
            }
            if(this.request.getRequestState() != OVERDRAFT_STATE.APPROVED) {
                throw new IllegalStateException(
                        String.format("Insufficient funds %s, cannot withdraw %s ", this.getBalance(), amount));
            } else if (this.request.getRequestState() == OVERDRAFT_STATE.APPROVED && this.request.getAmount().compareTo(amount) == -1 ) {
                throw new IllegalStateException(
                        String.format("Overdraft amount %s is lower than requested amount %s ", this.request.getAmount(), amount));
            } else {
                createTransaction(amount, TRANSACTION_TYPE.DEBIT);
            }
        } else {
            createTransaction(amount, TRANSACTION_TYPE.DEBIT);
        }
    }


    private void createTransaction(BigDecimal amount, TRANSACTION_TYPE transactionType) {
        Transaction transaction = new Transaction(transactionType, amount, this);
        this.transactions.add(transaction);
    }
    //core
    public BigDecimal getBalance() {
        BigDecimal balance = BigDecimal.ZERO;
        for (Transaction transaction : transactions) {
            if (transaction.getType() == TRANSACTION_TYPE.CREDIT) {
                balance = balance.add(transaction.getAmount());
            }
            if (transaction.getType() == TRANSACTION_TYPE.DEBIT) {
                balance = balance.subtract(transaction.getAmount());
            }
        }
        return balance;
    }
    //extension
    private BigDecimal getBalance(Transaction transaction, BigDecimal prevBalance) {
        BigDecimal balance = BigDecimal.ZERO;
        if (transaction.getType() == TRANSACTION_TYPE.CREDIT) {
            balance = prevBalance.add(transaction.getAmount());
        }
        if (transaction.getType() == TRANSACTION_TYPE.DEBIT) {
            balance = prevBalance.subtract(transaction.getAmount());
        }
        return balance;
    }

    public void requestOverdraft(BigDecimal amount){
        this.request = new OverdraftRequest(this, amount);
    }

    public OverdraftRequest getRequest(){
        return this.request;
    }

    public OVERDRAFT_STATE getOverdraftStatus() {
        return this.request.getRequestState();
    }

    public void printBankStatement() {
        System.out.printf("%10s || %10s || %10s || %10s\n", "date", "credit", "debit", "balance");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        BigDecimal balance = BigDecimal.ZERO;

        for (Transaction transaction : transactions) {
            String date = dtf.format(transaction.getDate());

                String credit = String.valueOf(transaction.getType() == TRANSACTION_TYPE.CREDIT ? transaction.getAmount() : "");
                String debit = String.valueOf(transaction.getType() == TRANSACTION_TYPE.DEBIT ? transaction.getAmount() : "");
                balance =getBalance(transaction, balance);
                Double statementBalance = balance.doubleValue();
                System.out.printf("%10s || %10s || %10s || %10.2f\n", date, credit, debit, statementBalance);
            }

        }


}


package com.booleanuk.core;

import com.booleanuk.core.enums.TRANSACTION_TYPE;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class Account {
    private final Customer customer;
    private final List<Transaction> transactions = new ArrayList<>();
    private String accountNumber;

    Account(BigDecimal amount, Customer customer) {
        this.customer = customer;
        this.accountNumber = createAccountNumber();
        if (amount.compareTo(BigDecimal.ZERO) > 0) deposit(amount);
    }

    Account(Customer customer) {
        this.customer = customer;
        this.accountNumber = createAccountNumber();
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

    public void withdraw(BigDecimal amount) {
        createTransaction(amount, TRANSACTION_TYPE.DEBIT);
    }


    private void createTransaction(BigDecimal amount, TRANSACTION_TYPE transactionType) {
        Transaction transaction = new Transaction(transactionType, amount, this);
        this.transactions.add(transaction);
    }

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

    public BigDecimal getBalance(Transaction transaction, BigDecimal prevBalance) {
        BigDecimal balance = BigDecimal.ZERO;
        if (transaction.getType() == TRANSACTION_TYPE.CREDIT) {
            balance = prevBalance.add(transaction.getAmount());
        }
        if (transaction.getType() == TRANSACTION_TYPE.DEBIT) {
            balance = prevBalance.subtract(transaction.getAmount());
        }
        return balance;
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


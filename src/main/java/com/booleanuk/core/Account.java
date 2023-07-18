package com.booleanuk.core;

import com.booleanuk.core.enums.TRANSACTION_TYPE;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class Account {
    private final Customer customer;
    private List<Transaction> transactions = new ArrayList<>();
    private final String accountNumber;

    Account(BigDecimal amount, Customer customer){
        this.customer = customer;
        this.accountNumber = createAccountNumber();
        if (amount.compareTo(BigDecimal.ZERO) > 0) deposit(amount);
    }

    private String createAccountNumber(){
        Random random = new Random();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 16; i++) {
            sb.append(random.nextInt(10));
        }

        return sb.toString();
    }

    public void deposit(BigDecimal amount){
        createTransaction(amount, TRANSACTION_TYPE.CREDIT);
    }

    public void withdraw(BigDecimal amount){
        createTransaction(amount, TRANSACTION_TYPE.DEBIT);
    }


    private void createTransaction(BigDecimal amount, TRANSACTION_TYPE transactionType){
        Transaction transaction = new Transaction( transactionType, amount, this);
        this.transactions.add(transaction);
    }

    public BigDecimal getBalance(){
        BigDecimal balance = BigDecimal.ZERO;
        for (Transaction transaction : transactions) {
            if(transaction.getType() == TRANSACTION_TYPE.CREDIT) {
                balance = balance.add(transaction.getAmount());
            }
            if(transaction.getType() == TRANSACTION_TYPE.DEBIT) {
                balance = balance.subtract(transaction.getAmount());
            }
        }
        return balance;
    }


}

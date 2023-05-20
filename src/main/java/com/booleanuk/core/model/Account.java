package com.booleanuk.core.model;

import com.booleanuk.core.model.enumerations.TRANSACTION_TYPE;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public abstract class Account {
    private String iban;
    private String accountNumber;
    private Customer customer;
    private List<Transaction> transactions;

    Account(BigDecimal amount, Customer customer) {
        if (amount == null || customer == null)
            throw new NullPointerException("Amount and customer must be non-null.");

        this.customer = customer;
        this.transactions = new ArrayList<>();
        this.accountNumber = generateAccountNumber();
        this.iban = composeIBAN();

        if (amount.compareTo(BigDecimal.ZERO) > 0) deposit(amount);
    }

    private String composeIBAN() {
        String countryCode = customer.getBranch().getBank().getLocale().getCountry();
        String bankCode = customer.getBranch().getBank().getBankCode();
        String branchCode = customer.getBranch().getBranchCode();
        return countryCode + bankCode + branchCode + this.accountNumber;
    }

    private String generateAccountNumber() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();

        do {
            for (int i = 0; i < 16; i++) {
                sb.append(random.nextInt(10));
            }
        } while (!customer.getBranch().isAccountNumberUnique(sb.toString()));
        return sb.toString();
    }

    public void deposit(BigDecimal amount) {
        createTransaction(amount, TRANSACTION_TYPE.DEPOSIT);
    }

    public void withdraw(BigDecimal amount) {
        if (this.getBalance().getAmount().compareTo(amount) < 0) {
            System.out.println("Insufficient funds. You do not have enough money in" +
                    " your account to make this withdrawal.");
            return;
        }
        createTransaction(amount, TRANSACTION_TYPE.WITHDRAWAL);
    }

    void createTransaction(BigDecimal amount, TRANSACTION_TYPE type) {
        try {
            Money money = new Money(amount, this.customer.getBranch().getBank().getLocale());
            Transaction transaction = new Transaction(type, money, this);
            this.transactions.add(transaction);
        } catch (Exception e) {
            System.out.println("Transaction wasn't completed." + Arrays.toString(e.getStackTrace()));
        }
    }

    public Money getBalance() {
        BigDecimal amount = new BigDecimal(BigInteger.ZERO);
        for (Transaction transaction : transactions) {
            if (transaction.getType() == TRANSACTION_TYPE.DEPOSIT)
                amount = amount.add(transaction.getMoney().getAmount());
            if (transaction.getType() == TRANSACTION_TYPE.WITHDRAWAL)
                amount = amount.subtract(transaction.getMoney().getAmount());
        }
        return new Money(amount, this.customer.getBranch().getBank().getLocale());
    }

    public void printBankStatement() {
        if (transactions.size() == 0) {
            System.out.println("No transactions have been made.");
        } else {
            System.out.printf("%11s || %11s || %11s || %11s\n", "date", "credit", "debit", "balance");
            transactions.forEach(System.out::println);
        }
    }

    public String getAccountNumber() {
        return this.accountNumber;
    }

    public Customer getCustomer() {
        return customer;
    }
}

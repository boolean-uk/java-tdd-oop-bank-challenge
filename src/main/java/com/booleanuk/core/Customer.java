package com.booleanuk.core;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Customer {
    private List<BankAccount> accounts = new ArrayList<>();
    private List<BankStatement> statements = new ArrayList<>();

    private final int id;
    private static int nextId = 0;
    private String phoneNumber;
    private String email;
    private final String firstName;
    private final String lastName;

    public Customer(String phoneNumber, String email, String firstName, String lastName) {
        this.id = nextId++;
        this.phoneNumber = phoneNumber;
        if (!email.contains("@")) {
            throw new IllegalArgumentException("Invalid email address");
        }
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public BankAccount createAccount(AccountType accountType, String branchCode) {
        Bank bank = Bank.getInstance();
        String accountNumber = bank.generateAccountNumber();
        BankAccount account = switch (accountType) {
            case CURRENT -> new CurrentAccount(accountNumber, id, branchCode);
            case SAVINGS -> new SavingsAccount(accountNumber, id, branchCode);
        };
        accounts.add(account);
        bank.addAccount(account);
        BankStatement statement = new BankStatement(accountNumber);
        statements.add(statement);
        bank.addStatement(statement);
        return account;
    }

    public void deposit(String accountNumber, double amount) throws IllegalArgumentException {
        if (amount < 0) {
            throw new IllegalArgumentException("Invalid amount");
        }
        BankAccount account = accounts.stream()
                .filter(a -> a.getAccountNumber().equals(accountNumber))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Invalid account number"));
        account.deposit(amount);
        LocalDateTime today = LocalDateTime.now();
        Transaction transaction = new Transaction(account.getBalance(), today, TransactionType.CREDIT, amount);
        statements.stream()
                .filter(s -> s.getAccountNumber().equals(accountNumber))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Invalid account number"))
                .addTransaction(transaction);
    }

    public void withdraw(String accountNumber, double amount) throws IllegalArgumentException {
        if (amount < 0) {
            throw new IllegalArgumentException("Invalid amount");
        }
        BankAccount account = accounts.stream()
                .filter(a -> a.getAccountNumber().equals(accountNumber))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Invalid account number"));
        account.withdraw(amount);

        LocalDateTime today = LocalDateTime.now();
        Transaction transaction = new Transaction(account.getBalance(), today, TransactionType.DEBIT, amount);
        statements.stream()
                .filter(s -> s.getAccountNumber().equals(accountNumber))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Invalid account number"))
                .addTransaction(transaction);
    }

    public List<BankAccount> getAccounts() {
        return accounts;
    }

    public List<BankStatement> getStatements() {
        return statements;
    }

    public int getId() {
        return id;
    }

    public static int getNextId() {
        return nextId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}

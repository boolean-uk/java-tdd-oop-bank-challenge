package com.booleanuk.core;

import com.booleanuk.core.enums.AccountType;
import com.booleanuk.core.enums.TransactionType;
import com.booleanuk.core.exceptions.AccountNotFoundException;
import com.booleanuk.core.exceptions.InsufficientFundsException;
import com.booleanuk.core.models.Transaction;
import com.booleanuk.core.models.accounts.Account;
import com.booleanuk.core.models.accounts.CurrentAccount;
import com.booleanuk.core.models.accounts.SavingsAccount;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import static com.booleanuk.core.util.CurrencyUtils.toSubUnits;

@Data
public class Bank {
    private final List<Account> accounts;
    private final List<Transaction> transactions;
    private AtomicInteger accountNumberCounter;

    public Bank() {
        this.accounts = new ArrayList<>();
        this.transactions = new ArrayList<>();
        this.accountNumberCounter = new AtomicInteger(480_00000);
    }

    private int generateAccountNumber() {
        return accountNumberCounter.getAndIncrement();
    }

    public int createAccount(AccountType accountType) {
        Account account = null;
        int accountNum = generateAccountNumber();

        switch (accountType) {
            case CURRENT -> account = new CurrentAccount(accountNum);
            case SAVINGS -> account = new SavingsAccount(accountNum);
        }

        accounts.add(account);
        return accountNum;
    }

    public Account getAccountByAccountNumber(int accountNum) {
        for (Account account : accounts) {
            if (account.getAccountNumber() == (accountNum)) {
                return account;
            }
        }
        throw new AccountNotFoundException();
    }

    public double performDeposit(int accountNum, double amount)  {
        Account account = getAccountByAccountNumber(accountNum);
        account.deposit(amount);

        Transaction transaction = new Transaction(account, account.getBalance(), toSubUnits(amount), TransactionType.DEPOSIT);
        transactions.add(transaction);

        return account.getBalanceInBaseUnits();
    }

    public double performDeposit(int accountNum, double amount, LocalDateTime dateTime)  {
        Account account = getAccountByAccountNumber(accountNum);
        account.deposit(amount);

        Transaction transaction = new Transaction(account, account.getBalance(), toSubUnits(amount), TransactionType.DEPOSIT, dateTime);
        transactions.add(transaction);

        return account.getBalanceInBaseUnits();
    }

    public double performWithdrawal(int accountNum, double amount) {
        Account account = getAccountByAccountNumber(accountNum);
        try {
            account.withdraw(amount);
            Transaction transaction = new Transaction(account, account.getBalance(), toSubUnits(amount), TransactionType.WITHDRAWAL);
            transactions.add(transaction);
        } catch (InsufficientFundsException e) {
            System.out.println("Transaction failed: " + e.getMessage());
        }
        return account.getBalanceInBaseUnits();
    }

    public double performWithdrawal(int accountNum, double amount, LocalDateTime dateTime) {
        Account account = getAccountByAccountNumber(accountNum);
        try {
            account.withdraw(amount);
            Transaction transaction = new Transaction(account, account.getBalance(), toSubUnits(amount), TransactionType.WITHDRAWAL, dateTime);
            transactions.add(transaction);
        } catch (InsufficientFundsException e) {
            System.out.println("Transaction failed: " + e.getMessage());
        }
        return account.getBalanceInBaseUnits();
    }

    public double getAccountBalance(int accountNumber) {
        return getAccountByAccountNumber(accountNumber).getBalanceInBaseUnits();
    }

    public List<Transaction> getAccountTransactions(int accountNum) {
        List<Transaction> accountTransactions = new ArrayList<>();
        for (Transaction transaction : transactions) {
            if (transaction.getAccount() == getAccountByAccountNumber(accountNum)) {
                accountTransactions.add(transaction);
            }
        }
        return accountTransactions;
    }

    public String getAccountBankStatement(int accountNumber) {
        StatementService statementService = new StatementService(this);
        return statementService.generateBankStatement(accountNumber);
    }
}

package com.booleanuk.core;

import com.booleanuk.core.enums.AccountType;
import com.booleanuk.core.enums.TransactionType;
import com.booleanuk.core.exceptions.InsufficientFundsException;
import com.booleanuk.core.exceptions.OverdraftRequestException;
import com.booleanuk.core.models.Transaction;
import com.booleanuk.core.models.accounts.Account;
import com.booleanuk.core.models.accounts.CurrentAccount;
import com.booleanuk.core.models.accounts.SavingsAccount;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

import static com.booleanuk.core.util.CurrencyUtils.toSubUnits;

@Data
public class Branch {
    protected int branchNumber;
    private final List<Account> accounts;
    private final List<Transaction> transactions;

    public Branch(int branchNumber) {
        this.branchNumber = branchNumber;
        this.accounts = new ArrayList<>();
        this.transactions = new ArrayList<>();
    }

    public int addNewAccount(AccountType accountType, int accountNum) {
        Account account = null;

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
        System.out.println("Account [" + accountNum + "] not found");
        // FIXME Should throw AccountNotFoundError that is caught in each method
        return null;
    }

    public double performDeposit(int accountNum, double amount)  {
        Account account = getAccountByAccountNumber(accountNum);
        account.deposit(amount);

        Transaction transaction = new Transaction(account, account.getBalance(), toSubUnits(amount), TransactionType.DEPOSIT);
        transactions.add(transaction);
        account.addTransaction(transaction);

        return account.getBalanceInBaseUnits();
    }

    public double performWithdrawal(int accountNum, double amount) {
        Account account = getAccountByAccountNumber(accountNum);
        try {
            account.withdraw(amount);
            Transaction transaction = new Transaction(account, account.getBalance(), toSubUnits(amount), TransactionType.WITHDRAWAL);
            transactions.add(transaction);
            account.addTransaction(transaction);
        } catch (InsufficientFundsException | OverdraftRequestException e) {
            System.out.println("Transaction failed: " + e.getMessage());
        }
        return account.getBalanceInBaseUnits();
    }

    public double getAccountBalance(int accountNumber) {
        // return getAccountByAccountNumber(accountNumber).getBalanceInBaseUnits();
        return getAccountByAccountNumber(accountNumber).getBalanceInBaseUnitsFromTransactions();
    }

    @Deprecated
    // Should not be used since transactions now are stored in the account object
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

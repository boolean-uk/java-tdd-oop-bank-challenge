package com.booleanuk.core.Accounts;

import com.booleanuk.core.Bank.Branch;
import com.booleanuk.core.Bank.Transaction;
import com.booleanuk.core.BaseEntity;


import com.booleanuk.core.Enums.Branches;
import com.booleanuk.core.Enums.TransactionType;
import com.booleanuk.core.Users.User;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
@Getter
@Setter

public abstract class Account extends BaseEntity {
    private BigDecimal balance;
    private List<Transaction> transactions;
    private final BigDecimal initialDepositMinimum = BigDecimal.ZERO;
    // A Set maybe?

    private User accountHolder;
    private Branch branch;



    public Account(BigDecimal initialBalance, Branch branch, User accountHolder) {
        this.transactions = new ArrayList<>();
        this.balance = BigDecimal.ZERO;
        this.depositFunds(initialBalance);
        this.branch = branch;
        this.accountHolder = accountHolder;
    }



    public Transaction depositFunds(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Amount must be positive for deposit.");
        }

        Transaction depositTransaction = new Transaction(TransactionType.DEPOSIT, amount);
        transactions.add(depositTransaction);

        this.setBalance(this.getBalance().add(amount));

        return depositTransaction;
    }
    public Transaction withdrawFunds(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Amount must be positive for withdrawal.");
        }

        if (amount.compareTo(this.getBalance()) > 0) {
            throw new IllegalArgumentException("Insufficient balance for withdrawal.");
        }

        Transaction withdrawTransaction = new Transaction(TransactionType.WITHDRAW, amount);
        transactions.add(withdrawTransaction);

        this.setBalance(this.getBalance().subtract(amount));

        return withdrawTransaction;
    }

    public BigDecimal getBalance() {
        BigDecimal balance = BigDecimal.ZERO;

        for (Transaction transaction : transactions) {
            if (transaction.getType() == TransactionType.DEPOSIT) {
                balance = balance.add(transaction.getAmount());
            } else if (transaction.getType() == TransactionType.WITHDRAW) {
                balance = balance.subtract(transaction.getAmount());
            }
        }

        return balance;
    }

//    public void setBalance(BigDecimal balance) {
//        this.balance = balance;
//    }
//    @Override
    public void setBalance(BigDecimal balance) {
        if (this.getBalance().compareTo(this.initialDepositMinimum) < 0) {
            throw new IllegalArgumentException("Balance cannot be set below the minimum deposit of " + initialDepositMinimum);
        }
       this.balance=balance;
    }
    public abstract boolean requestOverdraft(BigDecimal amount);


}

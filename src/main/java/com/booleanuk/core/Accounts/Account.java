package com.booleanuk.core.Accounts;

import com.booleanuk.core.Bank.BankStatement;
import com.booleanuk.core.Bank.Branch;
import com.booleanuk.core.Bank.Transaction;
import com.booleanuk.core.BaseEntity;
import com.booleanuk.core.Enums.TransactionType;
import com.booleanuk.core.Users.Client;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

@Getter
@Setter
public abstract class Account extends BaseEntity {
    private BigDecimal balance;
    protected List<Transaction> transactions;
    private Client accountHolder;
    private Branch branch;


    public Account(BigDecimal initialBalance, Branch branch, Client accountHolder) {
        this.transactions = new LinkedList<>();
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

        return depositTransaction;
    }
    public abstract Transaction withdrawFunds(BigDecimal amount);

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

    public abstract boolean requestOverdraft(BigDecimal amount);

    public String generateStatement() {
        return BankStatement.generateStatement(this);
    }
}

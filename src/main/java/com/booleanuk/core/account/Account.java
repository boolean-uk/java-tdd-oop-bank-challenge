package com.booleanuk.core.account;

import lombok.Getter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Getter
public abstract class Account {
    protected BigDecimal balance = BigDecimal.ZERO;
    protected final List<Transaction> transactions = new ArrayList<>();

    void deposit(BigDecimal amount) {
        balance = balance.add(amount);
        transactions.add(Transaction.of(Transaction.Type.Deposit, amount));
    }

    void withdraw(BigDecimal amount) {
        if (balance.compareTo(amount) < 0) {
            throw new IllegalStateException(
                    String.format("Cannot withdraw $%s - insufficient funds ($%s)", amount, balance)
            );
        }

        balance = balance.subtract(amount);
        transactions.add(Transaction.of(Transaction.Type.Withdrawal, amount));
    }

    String generateStatement() {
        var transactions = new ArrayList<>(this.transactions);
        Collections.reverse(transactions);
        var statementBalance = balance;
        var sb = new StringBuilder();
        sb.append(String.format(
                "|| %10s || %10s || %10s || %10s ||\n",
                "Date", "Credit", "Debit", "Balance"
        ));
        for (var t : transactions) {
            sb
                    .append(t)
                    .append(String.format(" %10.2f ||", statementBalance.doubleValue()))
                    .append("\n");
            var modifier = BigDecimal.valueOf(t.type().getModifier());
            statementBalance = statementBalance.subtract(t.amount().multiply(modifier));
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        var a = new SavingsAccount();
        a.deposit(BigDecimal.valueOf(2137));
        a.withdraw(BigDecimal.valueOf(420));
        a.deposit(BigDecimal.valueOf(69));

        System.out.println(a.generateStatement());
    }
}

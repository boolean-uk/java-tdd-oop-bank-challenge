package com.booleanuk.core;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;

public abstract class Account {
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private static final DecimalFormat AMOUNT_FORMATTER = new DecimalFormat("0.00");
    private static final String ROW_FORMAT = "%10s || %10s || %10s || %10s%n";
    private static final String HEADER_ROW = String.format(ROW_FORMAT, "date", "credit", "debit", "balance");

    private final UUID id;
    private final Customer holder;
    private BigDecimal balance;
    private final List<Transaction> transactions;

    public Account(Customer holder) {
        this.id = UUID.randomUUID();
        this.holder = holder;
        balance = BigDecimal.ZERO;
        transactions = new ArrayList<>();
    }

    protected BigDecimal deposit(BigDecimal funds) {
        Transaction transaction = new Transaction(LocalDateTime.now(), funds, null, balance.add(funds));
        transactions.add(transaction);
        balance = transaction.balance();
        return balance;
    }

    protected BigDecimal withdraw(BigDecimal funds) {
        Transaction transaction = new Transaction(LocalDateTime.now(), null, funds, balance.subtract(funds));
        transactions.add(transaction);
        balance = transaction.balance();
        return balance;
    }



    public String generateStatement() {
        if (transactions.isEmpty()) {
            return "";
        }

        StringBuilder statement = new StringBuilder(HEADER_ROW);
        transactions.stream()
                .sorted(Comparator.comparing(Transaction::date).reversed())
                .forEach(transaction -> {
                    statement.append(
                            String.format(ROW_FORMAT,
                                    transaction.date().format(DATE_FORMATTER),
                                    transaction.credit() == null ? "" : AMOUNT_FORMATTER.format(transaction.credit()),
                                    transaction.debit() == null ? "" : AMOUNT_FORMATTER.format(transaction.debit()),
                                    AMOUNT_FORMATTER.format(transaction.balance())
                            )
                    );
                });
        return statement.toString();
    }

    public UUID getId() {
        return id;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }
}

package com.booleanuk.extension;

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
    private final List<Transaction> transactions;

    public Account(Customer holder) {
        this.id = UUID.randomUUID();
        this.holder = holder;
        transactions = new ArrayList<>();
    }

    protected void deposit(BigDecimal funds) {
        Transaction transaction = new Transaction(LocalDateTime.now(), funds, null);
        transactions.add(transaction);
    }

    protected void withdraw(BigDecimal funds) {
        Transaction transaction = new Transaction(LocalDateTime.now(), null, funds);
        transactions.add(transaction);
    }


    public String generateStatement() {
        if (transactions.isEmpty()) {
            return "";
        }

        StringBuilder statement = new StringBuilder(HEADER_ROW);
        BigDecimal balance = BigDecimal.ZERO;
        for (Transaction transaction : transactions) {
            balance = transaction.credit() != null ? balance.add(transaction.credit()) : balance.subtract(transaction.debit());
            statement.append(
                    String.format(ROW_FORMAT,
                            transaction.date().format(DATE_FORMATTER),
                            transaction.credit() == null ? "" : AMOUNT_FORMATTER.format(transaction.credit()),
                            transaction.debit() == null ? "" : AMOUNT_FORMATTER.format(transaction.debit()),
                            AMOUNT_FORMATTER.format(balance)
                    )
            );
        }

        return statement.toString();
    }

    private BigDecimal calculateBalance() {
        BigDecimal balance = BigDecimal.ZERO;
        for (Transaction transaction : transactions) {
            balance = transaction.credit() == null ? balance.subtract(transaction.debit()) : balance.add(transaction.credit());
        }
        return balance;
    }

    public UUID getId() {
        return id;
    }

    public BigDecimal getBalance() {
        return calculateBalance();
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }
}

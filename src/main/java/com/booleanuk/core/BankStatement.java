package com.booleanuk.core;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.Collectors;

public class BankStatement {
    private final String accountNumber;
    List<Transaction> transactions;


    public BankStatement(String accountNumber) {
        this.accountNumber = accountNumber;
        this.transactions = new ArrayList<>();
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    private int getCreditLineLength() {
        OptionalInt maxLength = transactions.stream()
                .filter(t -> t.type() == TransactionType.CREDIT)
                .map(t -> (double) Math.round(t.amount() * 100) / 100)
                .map(t -> String.format("%.2f", t))
                .mapToInt(String::length)
                .max();

        if (maxLength.isPresent()) {
            return maxLength.getAsInt() + 2;
        }
        return " credit ".length();
    }

    private int getDebitLineLength() {
        OptionalInt maxLength = transactions.stream()
                .filter(t -> t.type() == TransactionType.DEBIT)
                .map(t -> (double) Math.round(t.amount() * 100) / 100)
                .map(t -> String.format("%.2f", t))
                .mapToInt(String::length)
                .max();
        if (maxLength.isPresent()) {
            return maxLength.getAsInt() + 2;
        }
        return " debit ".length();
    }

    @Override
    public String toString() {
        transactions.sort((t1, t2) -> t2.transactionDate().compareTo(t1.transactionDate()));
        int creditLineLength = getCreditLineLength();
        int debitLineLength = getDebitLineLength();
        StringBuilder sb = new StringBuilder();
        sb.append("date").append(" ".repeat(7)).append("||");
        sb.append(" credit ")
                .append(" ".repeat(Math.max(creditLineLength - " credit ".length(), 0)))
                .append("||");
        sb.append(" debit ")
                .append(" ".repeat(Math.max(debitLineLength - " debit ".length(), 0)))
                .append("||");
        sb.append(" balance");
        sb.append(System.lineSeparator());

        for (Transaction transaction : transactions) {
            DecimalFormatSymbols symbols = new DecimalFormatSymbols();
            symbols.setDecimalSeparator('.'); // explicitly set decimal separator to period
            DecimalFormat df = new DecimalFormat("0.00", symbols);
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            sb.append(dateFormat.format(transaction.transactionDate())).append(" || ");
            String amount = df.format(transaction.amount());
            if (transaction.type() == TransactionType.CREDIT) {
                sb.append(amount).append(" ".repeat(creditLineLength - String.valueOf(amount).length() - 1));
                sb.append("||").append(" ".repeat(debitLineLength));
            }
            else {
                sb.append(" ".repeat(creditLineLength - 1)).append("|| ");
                sb.append(amount).append(" ".repeat(debitLineLength - String.valueOf(amount).length() - 1));
            }
            sb.append("|| ");
            sb.append(df.format(transaction.balanceAfter()));
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }
}

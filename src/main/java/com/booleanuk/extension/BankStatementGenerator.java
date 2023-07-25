package com.booleanuk.extension;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BankStatementGenerator {
    public String generateBankStatement(List<Transaction> transactions) {
        StringBuilder bankStatementBuilder = new StringBuilder();

        String format = getLineFormat(transactions);

        generateInitialLine(bankStatementBuilder, format);
        generateTransactionLines(bankStatementBuilder, transactions, format);

        return bankStatementBuilder.toString();
    }

    private String getLineFormat(
            List<Transaction> transactions
    ) {
        int dateAlign = getDateAlign(transactions);
        int creditAlign = getCreditAlign(transactions);
        int debitAlign = getDebitAlign(transactions);
        int balanceAlign = getBalanceAlign(transactions);

        return "%-" + dateAlign + "s" + " || " +
                "%-" + creditAlign + "s" + " || " +
                "%-" + debitAlign + "s" + " || " +
                "%-" + balanceAlign + "s";
    }

    private int getDateAlign(
            List<Transaction> transactions
    ) {
        int longestDateLength = transactions.stream()
                .map(t -> getFormattedTransactionDate(t).length())
                .max(Comparator.comparing(Integer::intValue))
                .orElse(0);

        return Math.max("date".length(), longestDateLength);
    }

    private int getCreditAlign(
            List<Transaction> transactions
    ) {
        int longestCreditLength = transactions.stream()
                .map(t -> getFormattedTransactionCredit(t).length())
                .max(Comparator.comparing(Integer::intValue))
                .orElse(0);

        return Math.max("credit".length(), longestCreditLength);
    }

    private int getDebitAlign(
            List<Transaction> transactions
    ) {
        int longestDebitLength = transactions.stream()
                .map(t -> getFormattedTransactionDebit(t).length())
                .max(Comparator.comparing(Integer::intValue))
                .orElse(0);

        return Math.max("debit".length(), longestDebitLength);
    }

    private int getBalanceAlign(
            List<Transaction> transactions
    ) {
        int longestBalanceLength = 0;
        int balance = 0;

        for (Transaction transaction: transactions) {
            balance += transaction.isDeposit()
                    ? transaction.getAmount()
                    : -transaction.getAmount();

            longestBalanceLength = Math.max(
                    longestBalanceLength,
                    getFormattedBalance(balance).length()
            );
        }

        return Math.max("balance".length(), longestBalanceLength);
    }

    private void generateInitialLine(
            StringBuilder bankStatementBuilder,
            String lineFormat) {
        bankStatementBuilder.append(lineFormat.formatted(
                "date",
                "credit",
                "debit",
                "balance"));
    }

    private void generateTransactionLines(
            StringBuilder bankStatementBuilder,
            List<Transaction> transactions,
            String lineFormat
    ) {
        List<String> transactionLines = getTransactionLines(
                transactions,
                lineFormat
        );

        Collections.reverse(transactionLines);

        for (String transactionLine: transactionLines)
            bankStatementBuilder.append('\n')
                    .append(transactionLine);
    }

    private List<String> getTransactionLines(
            List<Transaction> transactions,
            String lineFormat
    ) {
        List<String> transactionsLines = new ArrayList<>();
        int balance = 0;

        for (Transaction transaction: transactions) {
            balance += transaction.isDeposit()
                    ? transaction.getAmount()
                    : -transaction.getAmount();

            transactionsLines.add(
                    getTransactionLine(
                            transaction,
                            lineFormat,
                            balance
                    )
            );
        }

        return transactionsLines;
    }

    private String getTransactionLine(
            Transaction transaction,
            String lineFormat,
            int balance
    ) {
        return lineFormat.formatted(
                getFormattedTransactionDate(transaction),
                getFormattedTransactionCredit(transaction),
                getFormattedTransactionDebit(transaction),
                getFormattedBalance(balance)
        );
    }

    private String getFormattedTransactionDate(
            Transaction transaction) {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/uuuu");
        return transaction.getDate().format(format);
    }

    private String getFormattedTransactionCredit(
            Transaction transaction) {
        return transaction.isDeposit()
                ? "%.2f".formatted((double) transaction.getAmount() / 100)
                : "";
    }

    private String getFormattedTransactionDebit(
            Transaction transaction) {
        return transaction.isDeposit()
                ? ""
                : "%.2f".formatted((double) transaction.getAmount() / 100);
    }

    private String getFormattedBalance(
            int balance
    ) {
        return "%.2f".formatted((double) balance / 100);
    }
}

package com.booleanuk.core.Bank;

import com.booleanuk.core.Accounts.Account;
import com.booleanuk.core.Enums.TransactionType;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.List;

public class BankStatement {
    public static String generateStatement(Account account) {
        StringBuilder statement = new StringBuilder();
        String headerLine = String.format("date                || %-12s || %-12s || balance%n", "credit", "debit");
        statement.append(headerLine);

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")
                .withZone(ZoneId.systemDefault());
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        BigDecimal balance = BigDecimal.ZERO;
        List<Transaction> transactions = account.getTransactions();
        transactions.sort(new TransactionTimestampComparator());

        for (Transaction transaction : transactions) {
            Instant timestamp = transaction.getTimestamp();
            String dateTimeStr = dateTimeFormatter.format(timestamp);

            String creditStr = transaction.getType() == TransactionType.DEPOSIT ?
                    String.format("%-12s", decimalFormat.format(transaction.getAmount())) : "            ";
            String debitStr = transaction.getType() == TransactionType.WITHDRAW ?
                    String.format("%-12s", decimalFormat.format(transaction.getAmount())) : "            ";

            if (transaction.getType() == TransactionType.DEPOSIT) {
                balance = balance.add(transaction.getAmount());
            } else if (transaction.getType() == TransactionType.WITHDRAW) {
                balance = balance.subtract(transaction.getAmount());
            }

            statement.append(dateTimeStr)
                    .append(" || ")
                    .append(creditStr)
                    .append(" || ")
                    .append(debitStr)
                    .append(" || ")
                    .append(decimalFormat.format(balance))
                    .append("\n");
        }

        return statement.toString();
    }
}

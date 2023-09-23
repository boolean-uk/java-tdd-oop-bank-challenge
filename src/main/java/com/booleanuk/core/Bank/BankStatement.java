package com.booleanuk.core.Bank;

import com.booleanuk.core.Accounts.Account;
import com.booleanuk.core.Enums.TransactionType;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;

public class BankStatement {
    public static String generateStatement(Account account) {
        StringBuilder statement = new StringBuilder();
        statement.append("date                || credit  || debit  || balance\n");

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        BigDecimal balance = BigDecimal.ZERO;

        for (Transaction transaction : account.getTransactions()) {
            String dateTimeStr = dateTimeFormatter.format(transaction.getTimestamp());
            String creditStr = "";
            String debitStr = "";

            if (transaction.getType() == TransactionType.DEPOSIT) {
                creditStr = decimalFormat.format(transaction.getAmount());
                balance = balance.add(transaction.getAmount());
            } else if (transaction.getType() == TransactionType.WITHDRAW) {
                debitStr = decimalFormat.format(transaction.getAmount());
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

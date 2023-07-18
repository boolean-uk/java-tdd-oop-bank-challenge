package com.booleanuk.core.statements;

import com.booleanuk.core.banking.BankTransaction;
import lombok.Getter;

import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;


@Getter
public class BankStatementGenerator {

    private static final String COLUMN = " || ";
    private static final String LINE_BREAK = "\n";
    private static final String DATE_FORMAT = "dd/MM/yyyy";
    private static final String DATE = "DATE";
    private static final String TRANSACTION_TYPE = "OPERATION";
    private static final String RESULT = "RESULT";
    private static final String BALANCE_BEFORE = "BALANCE BEFORE";
    private static final String BALANCE_AFTER = "BALANCE AFTER";
    private static final String AMOUNT = "AMOUNT";

    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMAT).withZone(ZoneId.systemDefault());

    private static void setHeaders(StringBuilder result) {
        result.append(String.format("%10s", DATE));
        result.append(String.format("%15s", TRANSACTION_TYPE));
        result.append(String.format("%30s", RESULT));
        result.append(String.format("%25s", BALANCE_BEFORE));
        result.append(String.format("%15s", AMOUNT));
        result.append(String.format("%15s", BALANCE_AFTER));
        result.append(LINE_BREAK);
    }

    public String generateStatement(List<BankTransaction> transactions) {
        transactions.sort(Comparator.comparing(BankTransaction::getCreatedAt).reversed());

        StringBuilder result = new StringBuilder();
        setHeaders(result);

        for (BankTransaction transaction : transactions) {
            result.append(String.format("%10s", formatter.format(transaction.getCreatedAt())));
            result.append(String.format("%15s", transaction.getTransactionType()));
            result.append(String.format("%30s", transaction.getTransactionResult()));
            result.append(String.format("%25s", transaction.getBalanceBefore()));
            result.append(String.format("%15s", transaction.getAmount()));
            result.append(String.format("%15s", transaction.getBalanceAfter()));
            result.append(LINE_BREAK);

        }
        return result.toString();
    }
}

package com.booleanuk.core;

import com.booleanuk.core.enums.TransactionType;
import com.booleanuk.core.models.Transaction;

import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static com.booleanuk.core.util.CurrencyUtils.toBaseUnits;

public class StatementService {
    private final static String SEPARATOR = "\t||";
    private final static String NEW_LINE = "\n";
    Branch branch;
    DateTimeFormatter formatter;

    public StatementService(Branch branch) {
        this.branch = branch;
        this.formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    }

    public String generateBankStatement(int accountNumber) {
        StringBuilder sb = new StringBuilder();
        List<Transaction> sortedList = getReverseSortedTransactions(accountNumber);

        sb.append("date\t\t\t\t|| credit\t|| debit\t|| balance");

        for (Transaction transaction : sortedList) {
            sb.append(NEW_LINE);
            // Transaction date
            sb.append(transaction.getDateTime().format(formatter)).append(SEPARATOR);

            // Transaction amount
            if (transaction.getTransactionType() == TransactionType.DEPOSIT) {
                sb.append(" ").append(toBaseUnits(transaction.getAmount())).append(SEPARATOR);
                sb.append("\t\t").append(SEPARATOR);
            } else {
                sb.append("\t\t").append(SEPARATOR);
                sb.append(" ").append(toBaseUnits(transaction.getAmount())).append(SEPARATOR);
            }

            // Total balance
            sb.append(" ").append(toBaseUnits(transaction.getNewBalance()));
        }

        return sb.toString();
    }

    private List<Transaction> getReverseSortedTransactions(int accountNumber) {
        List<Transaction> sortedList = branch.getAccountTransactions(accountNumber);
        sortedList.sort(Comparator.comparing(Transaction::getDateTime));
        Collections.reverse(sortedList);
        return sortedList;
    }
}

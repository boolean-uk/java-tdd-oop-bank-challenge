package com.booleanuk.core;

import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BankStatement {
    public void printStatement(Account account) {
        List<Transaction> transactions = account.getTransactions();
        Collections.sort(transactions, Comparator.comparing(Transaction::getDateTime));

        System.out.println("date/time              || credit      || debit       || balance");
        BigDecimal balance = BigDecimal.ZERO;
        for (Transaction transaction : transactions) {
            if (transaction.getType() == TransactionType.DEPOSIT) {
                balance = balance.add(transaction.getAmount());
            } else {
                balance = balance.subtract(transaction.getAmount());
            }
            System.out.println(String.format("%1$-22s || %2$-11s || %3$-11s || %4$-11s",
                    transaction.getDateTime().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")),
                    (transaction.getType() == TransactionType.DEPOSIT ? transaction.getAmount() : ""),
                    (transaction.getType() == TransactionType.WITHDRAWAL ? transaction.getAmount() : ""),
                    balance));
        }
    }
}

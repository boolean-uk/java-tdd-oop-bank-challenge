package com.booleanuk.core;

import java.math.BigDecimal;

public class BankStatement {
    public void printStatement(Account account) {
        System.out.println("Account Number: " + account.getAccountNumber());
        System.out.println("date             || credit  || debit   || balance");
        BigDecimal balance = BigDecimal.ZERO;
        for (Transaction transaction : account.getTransactions()) {
            BigDecimal transactionAmount = transaction.getAmount();
            if (transaction.getType() == TransactionType.DEPOSIT) {
                balance = balance.add(transactionAmount);
            } else if (transaction.getType() == TransactionType.WITHDRAWAL) {
                balance = balance.subtract(transactionAmount);
            }
            System.out.printf("%-17s|| %-8s|| %-8s|| %.2f%n",
                    transaction.getDateTime().toString(),
                    transaction.getType() == TransactionType.DEPOSIT ? transaction.getAmount() : "",
                    transaction.getType() == TransactionType.WITHDRAWAL ? transaction.getAmount() : "",
                    balance);
        }
    }
}

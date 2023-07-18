package com.booleanuk.core;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BankStatement {
    public static void printStatement() {
        System.out.println("date       || credit || debit  || balance");
        System.out.println("------------------------------------------");
        int balance = 0;
        for (int i = 0; i < Account.transactionHistory.size(); i++) {
            int transactionAmount = Account.transactionHistory.get(i);
            LocalDateTime transactionDate = Account.transactionDate.get(i);
            if (Account.transactionHistory.get(i) > 0) {
                System.out.printf(
                        "%s || %d   ||        || %d%n",
                        transactionDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")),
                        transactionAmount,
                        balance += transactionAmount);
            } else {
                System.out.printf(
                        "%s ||        ||  %d  || %d%n",
                        transactionDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")),
                        transactionAmount,
                        balance += transactionAmount);
            }
        }
        System.out.println("------------------------------------------");
    }
}

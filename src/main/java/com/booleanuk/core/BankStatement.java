package com.booleanuk.core;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class BankStatement {
    private final Account account;

    public BankStatement(Account account) {
        this.account = account;
    }

    public String print() {
        List<Transaction> transactions = account.getTransactions()
                .stream()
                .sorted(Comparator.comparing(Transaction::date).reversed())
                .toList();

        List<String> dates = new ArrayList<>();
        List<String> credits = new ArrayList<>();
        List<String> debits = new ArrayList<>();
        List<String> balances = new ArrayList<>();

        dates.add("date");
        credits.add("credit");
        debits.add("debit");
        balances.add("balance");

        BigDecimal balance = account.getBalance();

        for(Transaction transaction : transactions) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            String date = transaction.date().format(formatter);
            dates.add(date);

            BigDecimal amount = transaction.amount().setScale(2, RoundingMode.HALF_UP);
            if(amount.compareTo(BigDecimal.ZERO) > 0) {
                credits.add(amount.toString());
                debits.add("");
            } else {
                debits.add(amount.negate().toString());
                credits.add("");
            }

            balances.add(balance.setScale(2, RoundingMode.HALF_UP).toString());
            balance = balance.subtract(amount);
        }

        dates = alignColumn(dates);
        credits = alignColumn(credits);
        debits = alignColumn(debits);
        balances = alignColumn(balances);

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < dates.size(); i++) {
            sb.append(String.join(" || ", List.of(
                    dates.get(i),
                    credits.get(i),
                    debits.get(i),
                    balances.get(i)
            )));
            sb.append("\n");
        }
        return sb.toString();
    }

    private List<String> alignColumn(List<String> column) {
        int maxLength = column.stream().mapToInt(String::length).max().orElse(0);
        return column.stream().map(s -> s + " ".repeat(maxLength - s.length())).toList();
    }
}

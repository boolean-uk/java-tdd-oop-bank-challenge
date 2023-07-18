package com.booleanuk.core;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

public class BankAccount {
    LinkedHashMap<String, List<Transaction>> accounts;

    public BankAccount() {
        accounts = new LinkedHashMap<>();
        accounts.put("main", new ArrayList<>());
    }

    public boolean makeTransaction(String accountName, Transaction transaction) {
        if(!accounts.containsKey(accountName))
            return false;

        accounts.get(accountName).add(transaction);
        return true;
    }

    public String showAccountHistory(String accountName) {
        if(!accounts.containsKey(accountName))
            return "accountName is not matching with any account";

        List<Transaction> account = accounts.get(accountName);
        StringBuilder result = new StringBuilder();
        result.append("date       || credit  || debit  || balance\n");
        AtomicReference<Float> balance = new AtomicReference<>(0f);
        String transactionsString = account.stream().map(transaction -> {
                balance.updateAndGet(currentBalance -> currentBalance + transaction.amount);
                return rightPad(transaction.date.toString(), 10)
                        + " || "
                        + (transaction.amount > 0 ?
                        rightPad(Float.toString(transaction.amount), 8) + "||" + " ".repeat(8)
                        : " ".repeat(8) + "|| " + rightPad(Float.toString(-transaction.amount), 7))
                        + "|| " + balance;}
        ).collect(Collectors.joining("\n"));

        result.append(transactionsString);
        return result.toString();
    }

    private String leftPad(String text, int length) { return String.format("%" + length + "." + length + "s", text); }
    private String rightPad(String text, int length) { return String.format("%-" + length + "." + length + "s", text); }
}

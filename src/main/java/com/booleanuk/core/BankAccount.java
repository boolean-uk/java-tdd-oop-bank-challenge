package com.booleanuk.core;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

public class BankAccount {
    LinkedHashMap<String, List<Transaction>> accounts;
    private float overDraftAmount;
    private float overDraftRequestedAmount;

    public BankAccount() {
        accounts = new LinkedHashMap<>();
        accounts.put("main", new ArrayList<>());
        accounts.put("savings", new ArrayList<>());
        overDraftAmount = 0;
    }

    public boolean deposit(String accountName, float amount, LocalDate date) {
        if(!accounts.containsKey(accountName) || amount <= 0)
            return false;

        Transaction transaction = new Transaction(date, amount);
        accounts.get(accountName).add(transaction);
        return true;
    }

    public boolean withdraw(String accountName, float amount, LocalDate date) {
        if(!accounts.containsKey(accountName) || amount <= 0)
            return false;

        AtomicReference<Float> balance = new AtomicReference<>(0f);
        List<Transaction> transactions = accounts.get(accountName);
        transactions.stream().forEach(
                transaction -> balance.updateAndGet(currentBalance -> currentBalance + transaction.amount));

        if(balance.get() + overDraftAmount < amount)
            return false;

        Transaction transaction = new Transaction(date, -amount);
        transactions.add(transaction);
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
    private String rightPad(String text, int length) { return String.format("%-" + length + "." + length + "s", text); }

    public boolean requestOverDraft(float amount) {
        if(amount < 0)
            return false;

        overDraftRequestedAmount = amount;
        return true;
    }

    public float getOverDraftRequestedAmount() {
        return overDraftRequestedAmount;
    }

    public boolean approveOverDraftAmount(float amount) {
        if(amount < 0 || amount != overDraftRequestedAmount)
            return false;

        overDraftAmount = overDraftRequestedAmount;
        overDraftRequestedAmount = 0;
        return true;
    }
}

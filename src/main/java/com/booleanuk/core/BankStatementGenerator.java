package com.booleanuk.core;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BankStatementGenerator {

    public String generateBankStatement(Account account){
        String dateHeader = "date       ";
        String creditHeader = " credit  ";
        String debitHeader = " debit  ";
        String balanceHeader = " balance";

        int creditLength = creditHeader.length();
        if(getLongestDeposit(account) > creditHeader.length())
            creditLength = getLongestDeposit(account);

        int debitLength = debitHeader.length();
        if(getLongestWithdrawal(account) > debitHeader.length())
            debitLength = getLongestWithdrawal(account);

        int balanceLength = balanceHeader.length();
        if(getLongestBalance(account) > balanceHeader.length())
            balanceLength = getLongestBalance(account);

        String initialLine = dateHeader +
                "||" +
                centerText("credit", creditLength) +
                "||" + centerText("debit", debitLength) +
                "|| " + centerText("balance", balanceLength) +
                "\n";

        StringBuilder bankStatementBuilder = new StringBuilder();
        bankStatementBuilder.append(initialLine);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        double balance = 0;
        for(Transaction transaction : account.getTransactionHistory()){
            String date = transaction.getTransactionDate().format(formatter) + " ||";
            String rest;
            if(transaction.getType().equals("deposit")){
                balance += transaction.getAmount();
                String amount = String.format("%.2f",transaction.getAmount());
                String balanceFormatted = "%.2f".formatted(balance);
                rest = centerText(amount,creditLength) + "||" + " ".repeat(debitLength)
                        + "||" + " ".repeat(balanceLength-balanceFormatted.length()) + balanceFormatted;
            }else{
                balance -= transaction.getAmount();
                String amount = "%.2f".formatted(transaction.getAmount());
                String balanceFormatted = "%.2f".formatted(balance);
                rest = " ".repeat(creditLength)  + "||" + centerText(amount,debitLength)
                        + "||" + " ".repeat(balanceLength-balanceFormatted.length()) + balanceFormatted;
            }
            String newLine = date + rest + "\n";
            bankStatementBuilder.append(newLine);
        }

        return bankStatementBuilder.toString();
    }



    private String centerText(String text, int spaceLength) {
        int empty = spaceLength - text.length();
        int prefixSize = empty / 2;
        int suffixSize = (empty + 1) / 2;

        return spaceLength > text.length()
                ? " ".repeat(prefixSize) + text + " ".repeat(suffixSize)
                : text;
    }
    public int getLongestDeposit(Account account){
        List<Transaction> filtered = account.getTransactionHistory()
                                            .stream()
                                            .filter(transaction -> transaction.getType().equals("deposit"))
                                            .toList();
        List<Double> depositAmounts = filtered.stream()
                                                .map(Transaction::getAmount)
                                                .toList();
        return depositAmounts.stream()
                .map(Object::toString)
                .map(String::length)
                .max(Comparator.comparing(Integer::intValue))
                .orElse(0) + 2;
    }

    public int getLongestWithdrawal(Account account){
        List<Transaction> filtered = account.getTransactionHistory()
                .stream()
                .filter(transaction -> transaction.getType().equals("withdrawal"))
                .toList();
        List<Double> withdrawalAmounts = filtered.stream()
                .map(Transaction::getAmount)
                .toList();
        return withdrawalAmounts.stream()
                .map(Object::toString)
                .map(String::length)
                .max(Comparator.comparing(Integer::intValue))
                .orElse(0) + 2;
    }

    public int getLongestBalance(Account account){
        List<Integer> balances = new ArrayList<>();
        int balance = 0;
        for (Transaction transaction : account.getTransactionHistory()){
            balance += transaction.getType().equals("deposit") ? transaction.getAmount() : -transaction.getAmount();
            balances.add(balance);
        }
        return balances.stream()
                .map(Object::toString)
                .map(String::length)
                .max(Comparator.comparing(Integer::intValue))
                .orElse(0) + 2;
    }
}

package com.booleanuk.core;

import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class BankAccount {
    double totalAmount;
    double currentTotal;
    double savingsTotal;
    double withdrawalsTotal;
    ArrayList<Current> currentAccount;
    ArrayList<Savings> savingsAccount;
    ArrayList<Withdrawal> withdrawalsAccount;

    public BankAccount() {
        this.currentTotal = 100;
        this.savingsTotal = 0;
        this.withdrawalsTotal = 0;
        this.currentAccount = new ArrayList<>();
        this.savingsAccount = new ArrayList<>();
        this.withdrawalsAccount = new ArrayList<>();
    }

    public double balance() {
        return currentTotal - totalCurrent();
    }

    public double depositMoneyToCurrent(Currency currentAmount) {
        currentAccount.add(new Current(currentAmount, LocalDate.now()));
        return currentTotal += currentAmount.getValue();
    }

    public double totalCurrent() {
        // Start with the initial value of 100
        double currentTotal = 100;
        for (Current current : currentAccount) {
            currentTotal += current.currentAmount.getValue();
        }
        return currentTotal;
    }


    public void listDepositAmountsCurrent() {
        String result = "date           ||  credit  || debit  || balance";
        for (Current current : currentAccount) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            String formattedDate = current.date.format(formatter);

            result += "\n" + formattedDate + "     " + "||" + " " + current.currentAmount.getSymbol() + " " + current.currentAmount.getValue();
        }
        PrintStream ps = new PrintStream(new FileOutputStream(FileDescriptor.out), true, StandardCharsets.UTF_8);
        ps.println(result);

    }

    public double depositMoneyToSavings(Currency savingsAmount) {
        savingsAccount.add(new Savings(savingsAmount, LocalDate.now()));
        return savingsTotal += savingsAmount.getValue();
    }


    public double totalSavings(Currency savingsAmount) {
        for (Savings saving : savingsAccount) {
            savingsTotal += savingsAmount.getValue();
        }
        return savingsTotal;
    }

    public void listDepositAmountsSavings() {
        String result = " date           ||  credit  || debit  || balance";
        for (Savings savings : savingsAccount) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            String formattedDate = savings.date.format(formatter);

            result += "\n " + formattedDate + "     " + "||" + " " + savings.savingsAmount.getSymbol() + " " + savings.savingsAmount.getValue();
        }
        PrintStream ps = new PrintStream(new FileOutputStream(FileDescriptor.out), true, StandardCharsets.UTF_8);
        ps.println(result);
    }

    public double withdrawMoney(Currency withdrawalAmount) {
        withdrawalsAccount.add(new Withdrawal(withdrawalAmount, LocalDate.now()));
        return currentTotal -= withdrawalAmount.getValue();
    }

    public double withdrawMoneyFromSavings(Currency withdrawalAmount) {
        withdrawalsAccount.add(new Withdrawal(withdrawalAmount, LocalDate.now()));
        return savingsTotal -= withdrawalAmount.getValue();
    }

    public void listWithdrawalAmounts() {
        String result = " date           ||  credit  || debit  || balance";
        for (Withdrawal withdrawal : withdrawalsAccount) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            String formattedDate = withdrawal.date.format(formatter);

            result += "\n " + formattedDate + "     " + "||" + " " + withdrawal.withdrawalAmount.getSymbol() + " " + withdrawal.withdrawalAmount.getValue();
        }
        PrintStream ps = new PrintStream(new FileOutputStream(FileDescriptor.out), true, StandardCharsets.UTF_8);
        ps.println(result);

    }

    public void listBalanceStatement() {
        String result = " date           ||  credit       ||    debit    || balance";

        double currentBalance = 0;  // Start with the initial value of 100
        double savingsBalance = 0;

        // Add deposits from current account
        for (Current current : currentAccount) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            String formattedDate = current.date.format(formatter);
            String credit = current.currentAmount.getSymbol() + " " + current.currentAmount.getValue();
            currentBalance += current.currentAmount.getValue();
            result += String.format("\n%-15s || %-13s || %-11s || %s", formattedDate, credit, "", current.currentAmount.getSymbol() + " "+ currentBalance);
        }

        // Add deposits from savings account
        for (Savings savings : savingsAccount) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            String formattedDate = savings.date.format(formatter);
            String credit = savings.savingsAmount.getSymbol() + " " + savings.savingsAmount.getValue();
            savingsBalance += savings.savingsAmount.getValue();
            result += String.format("\n%-15s || %-13s || %-11s || %s", formattedDate, credit, "", savings.savingsAmount.getSymbol() + " "+  savingsBalance);
        }

        // Add withdrawals
        for (Withdrawal withdrawal : withdrawalsAccount) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            String formattedDate = withdrawal.date.format(formatter);
            String debit = withdrawal.withdrawalAmount.getSymbol() + " " + withdrawal.withdrawalAmount.getValue();
            currentBalance -= withdrawal.withdrawalAmount.getValue();
            result += String.format("\n%-15s || %-13s || %-11s || %s", formattedDate, "", debit,  withdrawal.withdrawalAmount.getSymbol() + " "+ currentBalance);
        }

        PrintStream ps = new PrintStream(new FileOutputStream(FileDescriptor.out), true, StandardCharsets.UTF_8);
        ps.println(result);
    }

}

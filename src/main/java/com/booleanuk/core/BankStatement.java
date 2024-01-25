package com.booleanuk.core;

import com.booleanuk.core.Account;
import com.booleanuk.core.Transaction;

import java.util.Collections;
import java.util.Comparator;

public class BankStatement {

    public static void printStatement(Account account) {
        Collections.sort(account.getTransactions(), Comparator.comparing(Transaction::getDate));

        double balance = 0;
        System.out.println(String.format("Customer: %-10s", account.getCustomer().getCustomerID()));
        System.out.println(String.format("Account: %-10s", account));
        System.out.println("-----------------------------------------------------------------");
        System.out.println("date                 || credit     || debit      || balance");
        for (Transaction transaction : account.getTransactions()) {
            balance += transaction.getAmount();
            String credit = transaction.getAmount() > 0 ? String.format("%.2f", transaction.getAmount()) : "";

            String debit = transaction.getAmount() < 0 ? String.format("%.2f", -transaction.getAmount()) : "";


            System.out.println(String.format("%-20s || %10s || %10s || %10s || ",
                    transaction.getDate(), credit, debit, String.format("%,.2f", balance)));
        }
    }
}
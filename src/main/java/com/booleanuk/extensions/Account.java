package com.booleanuk.extensions;

import com.booleanuk.core.Transaction;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Account {

    final static String POUND = "\u00a3";
    List<Transaction> transactionsHistory;

    public Account() {
        transactionsHistory = new ArrayList<>();
    }

    public List<Transaction> getTransactionsHistory() {
        return transactionsHistory;
    }

}

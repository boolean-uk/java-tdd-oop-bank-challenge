package com.booleanuk.core;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class BankAccountTest {
    private ArrayList<Transaction> listOfTransactions = new ArrayList<>(){{
        LocalDateTime dateTime1 = LocalDateTime.now();
        Transaction transaction1 = new Transaction(dateTime1, 200D, "Deposit");
        add(transaction1);

        LocalDateTime dateTime2 = dateTime1.plusHours(1);
        Transaction transaction2 = new Transaction(dateTime2, 700D, "Deposit");
        add(transaction2);

        LocalDateTime dateTime3 = dateTime1.plusDays(2);
        Transaction transaction3 = new Transaction(dateTime3, 900D, "Withdraw");
        add(transaction3);
    }};


}

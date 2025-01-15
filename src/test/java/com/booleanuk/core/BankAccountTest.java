package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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
        Transaction transaction3 = new Transaction(dateTime3, -500D, "Withdraw");
        add(transaction3);
    }};

    @Test
    public void balanceIncreasesWhenInputingValidAmount(){
        BankAccount account = new CurrentAccount(1, listOfTransactions);
        LocalDateTime dateTime = LocalDateTime.now();
        dateTime = dateTime.plusDays(4);

        Assertions.assertEquals(600D, account.makeDeposit(200D, dateTime));
    }

    @Test
    public void balanceStaysTheSameWhenInputingNonValidAmount(){
        BankAccount account = new CurrentAccount(1, listOfTransactions);
        LocalDateTime dateTime = LocalDateTime.now();
        dateTime = dateTime.plusDays(4);

        Assertions.assertEquals(400D, account.makeDeposit(-200D, dateTime));
    }
}

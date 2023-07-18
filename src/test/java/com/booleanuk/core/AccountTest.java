package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static com.booleanuk.core.TransactionType.*;

public class AccountTest {
    Account account;
    List<Transaction> transactions;
    User user;
    User manager;
    Transaction withdraw;
    Transaction deposit1;
    Transaction deposit2;
    Transaction wire;
    @BeforeEach
    public void setup(){
        account = new Account();
        user = new User();
        manager = new User();
        transactions = new ArrayList<>();
        withdraw = new Transaction(WITHDRAW,100);
        deposit1 = new Transaction(DEPOSIT, 1000);
        deposit2 = new Transaction(DEPOSIT, 800);
        wire = new Transaction(WIRE,500);
    }

    @Test
    public void shouldGetBalance(){
        transactions.add(deposit1);
        transactions.add(deposit2);
        transactions.add(withdraw);
        Assertions.assertEquals(1700,account.getBalance());
    }
}

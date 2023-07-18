package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static com.booleanuk.core.TransactionType.*;
import static org.junit.jupiter.api.Assertions.*;

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
        account = new CurrentAccount("PL8",user,manager);
        user = new User();
        manager = new User();
//        transactions = new ArrayList<>();
//        withdraw = new Transaction(WITHDRAW,100.00);
//        deposit1 = new Transaction(DEPOSIT, 1000.00);
//        deposit2 = new Transaction(DEPOSIT, 800.00);
        wire = new Transaction(WIRE,500.00);
    }

    @Test
    public void shouldDepositMoney(){
        account.deposit(1000.00);
        assertEquals(1,account.getTransactions().size());
        assertEquals(1000.00,account.getTransactions().get(0).getAmount());
    }

    @Test
    public void shouldGetBalance(){

        assertEquals(1700.00,account.getBalance());
    }
}

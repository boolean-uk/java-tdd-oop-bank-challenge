package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.booleanuk.core.TransactionType.*;
import static org.junit.jupiter.api.Assertions.*;

public class AccountTest {
    CurrentAccount currentAccount;
    User user;
    User secondUser;
    CurrentAccount secondAccount;
    User manager;

    @BeforeEach
    public void setup(){
        user = new User("Wojtek");
        secondUser = new User("Kuba");
        manager = new User("Milena");
        currentAccount = new CurrentAccount("PL8",user,manager);
    }

    @Test
    public void shouldDepositMoney(){
        currentAccount.deposit(1000.00);
        assertEquals(1, currentAccount.getTransactions().size());
        assertEquals(1000.00, currentAccount.getTransactions().get(0).getAmount());
    }

    @Test
    public void shouldWithdrawMoney(){
        currentAccount.deposit(1500.00);
        currentAccount.withdraw(1000.00);
        assertEquals(2, currentAccount.getTransactions().size());
        assertEquals(1000, currentAccount.getTransactions().get(1).getAmount());

        Assertions.assertThrows(IllegalArgumentException.class,()-> currentAccount.withdraw(1000));
    }

    @Test
    public void shouldWireMoney(){
        secondAccount = new CurrentAccount("POL54", secondUser, manager);
        currentAccount.deposit(1000);
        currentAccount.wire(600.00,secondAccount.getAccountNumber());
        assertEquals(400.00,currentAccount.getBalance());


    }
    @Test
    public void shouldGetBalance(){
        secondAccount = new CurrentAccount("POL54", secondUser, manager);
        currentAccount.deposit(1000.00);
        currentAccount.deposit(1500.00);
        currentAccount.wire(100.00,secondAccount.getAccountNumber());
        currentAccount.withdraw(700.00);
        assertEquals(1700.00, currentAccount.getBalance());
    }
    @Test
    public void shouldGetCorrectStatement(){
        secondAccount = new CurrentAccount("POL86", secondUser, manager);
        currentAccount.deposit(1000.00);
        currentAccount.deposit(1500.00);
        currentAccount.wire(100.00,secondAccount.getAccountNumber());
        currentAccount.withdraw(700.00);
        Map<String,List<Transaction>> expected = new HashMap<>();
        expected.put(currentAccount.getAccountNumber(),currentAccount.getTransactions());

        assertEquals(expected,user.generateStatement().getTransactions());
    }
}

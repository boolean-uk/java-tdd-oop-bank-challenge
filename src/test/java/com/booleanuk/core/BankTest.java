package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class BankTest {
    static Bank bank;
    static Branch branchWarsaw;
    static Branch branchGdansk;
    static CurrentAccount curr;
    static SavingsAccount save;

    @BeforeEach
    public void setUp() {
        bank = new Bank("Santander");
        branchWarsaw = new Branch("Branch nr 1", "Warsaw",bank);
        branchGdansk = new Branch("Branch nr 2", "Gdansk",bank);
        curr = new CurrentAccount("123",branchWarsaw);
        save = new SavingsAccount("456",branchGdansk, new BigDecimal("5.00"));
    }

    @Test
    public void depositWithdrawTest(){
        curr.deposit(new BigDecimal("1000.00"),"2023-07-18", "Deposit");
        Assertions.assertEquals(new BigDecimal("1000.00"),curr.getBalance());
        curr.deposit(new BigDecimal("5000.00"),"2023-07-18", "Deposit");
        Assertions.assertEquals(new BigDecimal("6000.00"),curr.getBalance());
        curr.withdraw(new BigDecimal("5000.00"),"2023-07-18", "Withdrawal");
        Assertions.assertEquals(new BigDecimal("1000.00"),curr.getBalance());
        curr.withdraw(new BigDecimal("5000.00"),"2023-07-18", "Withdrawal");
        Assertions.assertEquals(new BigDecimal("1000.00"),curr.getBalance());
    }


}

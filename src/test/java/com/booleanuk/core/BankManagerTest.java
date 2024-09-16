package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class BankManagerTest {
    @Test
    public void addBankTest() {
        BankManager bankManager = new BankManager();

        BankAccount bankAccount =  new BankAccount();
        bankManager.addBank("Warsaw", bankAccount);
    }

    @Test
    public void getBankTest() {
        BankManager bankManager = new BankManager();

        BankAccount bankAccount =  new BankAccount();
        bankManager.addBank("Warsaw", bankAccount);
        List<BankAccount> banksList = bankManager.getBanks("Warsaw");

        Assertions.assertEquals(bankAccount, banksList.get(0));
    }
}

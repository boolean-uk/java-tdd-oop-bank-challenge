package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class BankTest {

    private Bank bank;
    private Account currentAccount;
    private Account savingsAccount;

    @BeforeEach
    public void setUp() {
        bank = new Bank();
        currentAccount = new CurrentAccount();
        savingsAccount = new SavingsAccount();
        bank.createAccount("1", currentAccount);
        bank.createAccount("2", savingsAccount);
    }

    @Test
    public void createAccountTest() {
        Assertions.assertNotNull(bank.getAccount("1"));
        Assertions.assertNotNull(bank.getAccount("2"));
    }

    @Test
    public void depositTest() {
        currentAccount.deposit(1000);
        Assertions.assertEquals(1000, currentAccount.calculateBalance());
    }

    @Test
    public void withdrawTest() {
        currentAccount.deposit(1000);
        currentAccount.withdraw(1499,-500);
        Assertions.assertEquals(-498, currentAccount.calculateBalance());

        Assertions.assertTrue(currentAccount.calculateBalance() >= -500);

    }

    @Test
    public void bankStatementTest(){
        currentAccount.deposit(1000);
        currentAccount.withdraw(1500, -500);
        currentAccount.deposit(5000);

        bank.printStatement("1");
        System.out.println(currentAccount.calculateBalance());

    }


}

package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BankTest {
    @Test
    public void testCreatingCurrentAccountFromBank(){
        Bank bank = new Bank();
        Assertions.assertTrue(bank.createCurrentAccount("John"));
    }
    @Test
    public void testCreatingSavingsAccountFromBank(){
        Bank bank = new Bank();
        Assertions.assertTrue(bank.createSavingsAccount("John"));
    }

    @Test
    public void testDepositingtoExistingSavingsAccount(){
        Bank bank = new Bank();
        bank.createSavingsAccount("Joe");
        Assertions.assertTrue(bank.depositToAccount(1, 1000));
    }
    @Test
    public void testWithdrawingFromExistingCurrentAccount(){
        Bank bank = new Bank();
        bank.createCurrentAccount("John");
        bank.depositToAccount(1, 1000);
        Assertions.assertTrue(bank.withdrawFromAccount(1, 200));
    }
    @Test
    public void testGettingBankStatementsFromCreatedAccount(){
        Bank bank = new Bank();
        bank.createCurrentAccount("John");
        bank.depositToAccount(1, 100);
        bank.depositToAccount(1, 300);
        bank.withdrawFromAccount(1, 50);
        bank.createCurrentAccount("Daisy");
        bank.depositToAccount(2, 100);
        bank.depositToAccount(2, 300);
        bank.withdrawFromAccount(2, 50);
        Assertions.assertEquals(bank.getBankStatementsFromAccount(1), bank.getBankStatementsFromAccount(2));
    }

    /* Extension tests*/

    @Test
    public void test(){

    }
}

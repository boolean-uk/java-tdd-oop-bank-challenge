package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class BankTest {
    @Test
    public void testCreatingCurrentAccountFromBank(){
        Bank bank = new Bank();
        Assertions.assertTrue(bank.createCurrentAccount("John", Branch.DEF));
    }
    @Test
    public void testCreatingSavingsAccountFromBank(){
        Bank bank = new Bank();
        Assertions.assertTrue(bank.createSavingsAccount("John", Branch.ABC));
    }

    @Test
    public void testDepositingtoExistingSavingsAccount(){
        Bank bank = new Bank();
        bank.createSavingsAccount("Joe", Branch.GHJ);
        Assertions.assertTrue(bank.depositToAccount(1, 1000));
    }
    @Test
    public void testWithdrawingFromExistingCurrentAccount(){
        Bank bank = new Bank();
        bank.createCurrentAccount("John", Branch.ABC);
        bank.depositToAccount(1, 1000);
        Assertions.assertTrue(bank.withdrawFromAccount(1, 200));
    }
    @Test
    public void testGettingBankStatementsFromCreatedAccount(){
        Bank bank = new Bank();

        bank.createCurrentAccount("John", Branch.ABC);
        bank.depositToAccount(1, 100);
        bank.depositToAccount(1, 300);
        bank.withdrawFromAccount(1, 50);

        bank.createCurrentAccount("Daisy", Branch.DEF);
        bank.depositToAccount(2, 100);
        bank.depositToAccount(2, 300);
        bank.withdrawFromAccount(2, 50);

        Assertions.assertEquals(bank.getBankStatementsFromAccount(1), bank.getBankStatementsFromAccount(2));
    }

    /* Extension tests*/

    @Test
    public void testGettingSavingsAccountFromDEFBranch(){
        Bank bank = new Bank();

        bank.createCurrentAccount("John", Branch.DEF);
        bank.createSavingsAccount("Joe", Branch.DEF);
        bank.createCurrentAccount("Johnny", Branch.ABC);

        ArrayList<String> expected = new ArrayList<>();
        expected.add("Account Holder: " + "John" + ", Current Balance: " + "0.0");
        expected.add("Account Holder: " + "Joe" + ", Current Balance: " + "0.0");

        Assertions.assertEquals(expected, bank.getAccountsInBranch(Branch.DEF));

    }

    @Test
    public void testRequestingOverdraftToSavingsAccount(){
        Bank bank = new Bank();
        bank.createSavingsAccount("Joe", Branch.ABC);
        Assertions.assertFalse(bank.requestOverdraft(1));

    }
    @Test
    public void testGettingAllPendingOverdraftRequests(){
        Bank bank = new Bank();
        bank.createCurrentAccount("Joe", Branch.ABC);
        bank.requestOverdraft(1);

        ArrayList<String> expected = new ArrayList<>();
        expected.add("Account Holder: " + "Joe" + ", Current Balance: " + "0.0");

        Assertions.assertEquals(expected.toString(),  bank.getRequestedOverdrafts().toString());

    }

}

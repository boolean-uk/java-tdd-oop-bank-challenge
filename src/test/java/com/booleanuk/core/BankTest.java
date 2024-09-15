package com.booleanuk.core;

import com.booleanuk.core.enums.Branch;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class BankTest {
    @Test
    public void testCreatingCurrentAccountFromBank(){
        Bank bank = new Bank(new AccountHandler(new ArrayList<Account>(), new ArrayList<Account>(), new TransactionManager()));
        Assertions.assertTrue(bank.createCurrentAccount("John", Branch.DEF));
    }
    @Test
    public void testCreatingSavingsAccountFromBank(){
        Bank bank = new Bank(new AccountHandler(new ArrayList<Account>(), new ArrayList<Account>(), new TransactionManager()));
        Assertions.assertTrue(bank.createSavingsAccount("John", Branch.ABC));
    }

    @Test
    public void testDepositingtoExistingSavingsAccount(){
        Bank bank = new Bank(new AccountHandler(new ArrayList<Account>(), new ArrayList<Account>(), new TransactionManager()));
        bank.createSavingsAccount("Joe", Branch.GHJ);
        Assertions.assertTrue(bank.depositToAccount(1, 1000));
    }
    @Test
    public void testWithdrawingFromExistingCurrentAccount(){
        Bank bank = new Bank(new AccountHandler(new ArrayList<Account>(), new ArrayList<Account>(), new TransactionManager()));
        bank.createCurrentAccount("John", Branch.ABC);
        bank.depositToAccount(1, 1000);
        Assertions.assertTrue(bank.withdrawFromAccount(1, 200));
    }
    @Test
    public void testGettingBankStatementsFromCreatedAccount(){
        Bank bank = new Bank(new AccountHandler(new ArrayList<Account>(), new ArrayList<Account>(), new TransactionManager()));

        bank.createCurrentAccount("John", Branch.ABC);
        bank.depositToAccount(1, 100);
        bank.depositToAccount(1, 300);
        bank.withdrawFromAccount(1, 50);

        bank.createCurrentAccount("Daisy", Branch.DEF);
        bank.depositToAccount(2, 100);
        bank.depositToAccount(2, 300);
        bank.withdrawFromAccount(2, 50);

        Assertions.assertEquals(bank.getBankStatementsFromAccount(1), bank.getBankStatementsFromAccount(2));
        System.out.println(bank.getBankStatementsFromAccount(1));
    }

    /* Extension tests*/

    @Test
    public void testGettingSavingsAccountFromDEFBranch(){
        Bank bank = new Bank(new AccountHandler(new ArrayList<Account>(), new ArrayList<Account>(), new TransactionManager()));

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
        Bank bank = new Bank(new AccountHandler(new ArrayList<Account>(), new ArrayList<Account>(), new TransactionManager()));
        bank.createSavingsAccount("Joe", Branch.ABC);
        Assertions.assertFalse(bank.requestOverdraft(1));

    }
    @Test
    public void testGettingAllPendingOverdraftRequests(){
        Bank bank = new Bank(new AccountHandler(new ArrayList<Account>(), new ArrayList<Account>(), new TransactionManager()));
        bank.createCurrentAccount("Joe", Branch.ABC);
        bank.requestOverdraft(1);

        ArrayList<String> expected = new ArrayList<>();
        expected.add("Account Holder: " + "Joe" + ", Current Balance: " + "0.0");

        Assertions.assertEquals(expected.toString(),  bank.getRequestedOverdrafts().toString());

    }
    @Test
    public void testApprovingAndWithdrawingFromAccountWithOverdraftApproved(){
        Bank bank = new Bank(new AccountHandler(new ArrayList<Account>(), new ArrayList<Account>(), new TransactionManager()));
        bank.createCurrentAccount("Joe", Branch.ABC);
        bank.requestOverdraft(1);

        bank.approveOverDraft(1);
        Assertions.assertTrue(bank.withdrawFromAccount(1, 1000));

    }
    @Test
    public void testSavingAndLoadingFromFile() throws FileNotFoundException {
        AccountHandler accountHandler = new AccountHandler(new ArrayList<>(), new ArrayList<>(), new TransactionManager());
        Bank bank = new Bank(accountHandler);
        bank.createCurrentAccount("Joe", Branch.ABC);
        bank.depositToAccount(1, 1000);
        bank.depositToAccount(1, 2400);
        String expected = bank.getBankStatementsFromAccount(1);
        bank.createSavingsAccount("John", Branch.ABC);
        accountHandler.saveAccountsAndRequests();


        ArrayList<Account> accounts;
        ArrayList<Account> overdraftRequests;
        ArrayList<Transaction> transactions;
        Bank bank2;
        try{
            accounts = FileHandler.readFromFile("Test.txt");
            overdraftRequests = FileHandler.readFromFile("TestOverdraft.txt");
            transactions = FileHandler.readTransactionFromFile("TestTransactions.txt");

            bank2 = new Bank(new AccountHandler(accounts, overdraftRequests, new TransactionManager(transactions)));
            Assertions.assertEquals("Account Holder: Joe, Current Balance: 3400.0", bank2.getAccounts().get(0).toString());
            Assertions.assertEquals(expected, bank2.getBankStatementsFromAccount(1));

        }catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }




    }

}

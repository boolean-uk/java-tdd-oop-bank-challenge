package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BankStatementTest {
    private BankManager bankManager;
    private Branch mainBranch;

    @BeforeEach
    public void setUp() {
        bankManager = new BankManager();
        mainBranch = new Branch("Main Branch");
        bankManager.addBranch(mainBranch);
    }

    @Test
    public void testAddCurrentAccountToBranch() {
        Client client = new Client("John Doe", "12345");
        bankManager.addClient(client);

        Account newAccount = new CurrentAccount("C123456", client);
        mainBranch.addAccount(newAccount);

        assertEquals(1, mainBranch.getAccounts().size());
        assertTrue(mainBranch.getAccounts().contains(newAccount));
    }

    @Test
    public void testAddSavingsAccountToBranch() {
        Client client = new Client("John Doe", "12345");
        bankManager.addClient(client);

        Account newAccount = new SavingsAccount("S987654", client);
        mainBranch.addAccount(newAccount);

        assertEquals(1, mainBranch.getAccounts().size());
        assertTrue(mainBranch.getAccounts().contains(newAccount));
    }


    @Test
    public void testDepositToAccount() {
        Client client = new Client("John Doe", "12345");
        bankManager.addClient(client);

        Account newAccount = new CurrentAccount("C123456", client);
        mainBranch.addAccount(newAccount);

        newAccount.deposit(new BigDecimal("1000"));

        assertEquals(new BigDecimal("1000"), newAccount.getBalance());
    }

    @Test
    public void testWithdrawFromAccount() {
        Client client = new Client("John Doe", "12345");
        bankManager.addClient(client);

        Account newAccount = new CurrentAccount("C123456", client);
        mainBranch.addAccount(newAccount);

        newAccount.deposit(new BigDecimal("1000"));
        newAccount.withdraw(new BigDecimal("500"));

        assertEquals(new BigDecimal("500"), newAccount.getBalance());
    }
    @Test
    public void testAddAccountWithOverdraftToBranch() {
        Account newAccount = new CurrentAccount("C654321", new Client("Test Client", "98765"));
        newAccount.setOverdraftLimit(new BigDecimal("1000"));

        mainBranch.addAccount(newAccount);
        assertTrue(mainBranch.getAccounts().contains(newAccount));
    }
    @Test
    public void testAddAccountWithZeroOverdraftToBranch() {
        Account newAccount = new CurrentAccount("C654321", new Client("Test Client", "98765"));
        newAccount.setOverdraftLimit(BigDecimal.ZERO);

        mainBranch.addAccount(newAccount);
        assertTrue(mainBranch.getAccounts().contains(newAccount));
    }

    @Test
    public void testAddAccountWithPositiveOverdraftToBranch() {
        Account newAccount = new CurrentAccount("C654321", new Client("Test Client", "98765"));
        newAccount.setOverdraftLimit(new BigDecimal("500"));

        mainBranch.addAccount(newAccount);
        assertTrue(mainBranch.getAccounts().contains(newAccount));
    }


    @Test
    public void testAddAccountWithOverdraftToMultipleBranches() {
        Account newAccount = new CurrentAccount("C654321", new Client("Test Client", "98765"));
        newAccount.setOverdraftLimit(new BigDecimal("1000"));

        mainBranch.addAccount(newAccount);
        assertTrue(mainBranch.getAccounts().contains(newAccount));

        Branch secondBranch = new Branch("Second Branch");
        bankManager.addBranch(secondBranch);
        secondBranch.addAccount(newAccount);

        assertTrue(secondBranch.getAccounts().contains(newAccount));
    }
    @Test
    public void testRequestOverdraft() {
        Account account = new CurrentAccount("C123456", new Client("John Doe", "12345"));
        account.deposit(new BigDecimal("1000"));

        account.requestOverdraft(new BigDecimal("500"));

        assertTrue(((CurrentAccount) account).isOverdraftRequestPending());
        assertEquals(new BigDecimal("500"), ((CurrentAccount) account).getRequestedOverdraftAmount());
    }



}

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

    @Test
    public void withdrawMoreThanBalance(){
        curr.deposit(new BigDecimal("1000.00"),"2023-07-18", "Deposit");
        curr.withdraw(new BigDecimal("5000.00"),"2023-07-18", "Withdrawal");
        Assertions.assertEquals(new BigDecimal("1000.00"),curr.getBalance());
        save.deposit(new BigDecimal("1000.00"),"2023-07-18", "Deposit");
        save.withdraw(new BigDecimal("5000.00"),"2023-07-18", "Withdrawal");
        Assertions.assertEquals(new BigDecimal("1000.00"),save.getBalance());
    }
    @Test
    public void testOverdraftingApproved(){
        curr.requestOverdraft(new BigDecimal("1000.00"));
        curr.deposit(new BigDecimal("500.00"),"2023-07-18", "Deposit");
        bank.approveOverdraft(curr);
        curr.withdraw(new BigDecimal("1000.00"),"2023-07-18", "Withdrawal");
        Assertions.assertEquals(new BigDecimal("-500.00"),curr.getBalance());

    }

    @Test
    public void testOverdraftingReject(){
        curr.requestOverdraft(new BigDecimal("1000.00"));
        curr.deposit(new BigDecimal("500.00"),"2023-07-18", "Deposit");
        bank.rejectOverdraft(curr);
        curr.withdraw(new BigDecimal("1000.00"),"2023-07-18", "Withdrawal");
        Assertions.assertEquals(new BigDecimal("500.00"),curr.getBalance());
        Assertions.assertEquals("rejected", curr.getOverdraft().getStatus());
    }
    @Test
    public void testInterestRate(){
        save.deposit(new BigDecimal("1000.00"),"2023-07-18", "Deposit");
        save.withdraw(new BigDecimal("900.00"),"2023-07-18", "Withdrawal");
        save.applyInterest("2023-07-18");
        Assertions.assertEquals(new BigDecimal("105.00"),save.getBalance());
    }

    @Test
    public void testBranch(){
        Assertions.assertEquals(2,bank.getBranches().size());
        Assertions.assertEquals(1,branchGdansk.branchSize());
        Assertions.assertEquals("Gdansk", branchGdansk.getBranchLocation());
        Assertions.assertEquals("Branch nr 2", branchGdansk.getBranchName());
    }

    @Test
    public void testBankingStatement(){
        curr.deposit(new BigDecimal("5000.00"),"2023-07-18", "Deposit");
        curr.withdraw(new BigDecimal("1000.00"),"2023-07-18", "Withdrawal");
        curr.requestOverdraft(new BigDecimal("1000.00"));
        bank.approveOverdraft(curr);
        curr.withdraw(new BigDecimal("5000.00"),"2023-07-18", "Withdrawal");
        System.out.println(curr.generateBankStatement());
    }


}

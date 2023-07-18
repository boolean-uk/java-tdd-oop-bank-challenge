package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AccountsTest {
    private Branch branch;
    private Branch branch2;
    private Account account;
    private CurrentAccount currentAccount;
    private SavingsAccount savingsAccount;

    @BeforeEach
    public void setup() {
        branch = new Branch("PLWAW1", "Poland", "Warsaw");
        branch2 = new Branch("PLBIA33", "Poland", "Bialystok");
        account = new Account("12", branch);
        currentAccount = new CurrentAccount("12", branch);
        savingsAccount = new SavingsAccount("12", branch);
    }

    @Test
    public void accountGetterAndSetterShouldReturnProperValue() {
        Assertions.assertEquals("12", account.getAccountNr());
        Assertions.assertEquals(branch, account.getBranch());

        account.setAccountNr("123");

        Assertions.assertEquals("123", account.getAccountNr());
        Assertions.assertEquals(branch, account.getBranch());

        account.setBranch(branch2);

        Assertions.assertEquals(branch2, account.getBranch());
        Assertions.assertEquals(0, account.getTransfers().size());
    }

    @Test
    public void calculateBalanceShouldReturn0() {
        Assertions.assertEquals(0, account.calculateBalance());
    }

    @Test
    public void calculateBalanceShouldReturnProperValue() {
        account.deposit(20000);

        Assertions.assertEquals(20000, account.calculateBalance());
        Assertions.assertEquals(1, account.getTransfers().size());

        account.deposit(20000);

        Assertions.assertEquals(40000, account.calculateBalance());

        account.withdraw(30000);

        Assertions.assertEquals(10000, account.calculateBalance());

        account.withdraw(10000);

        Assertions.assertEquals(0, account.calculateBalance());

    }

    @Test
    public void currentAccountGetterAndSetterShouldReturnProperValue() {
        Assertions.assertEquals("12", currentAccount.getAccountNr());
        Assertions.assertEquals(branch, currentAccount.getBranch());

        currentAccount.setAccountNr("123");

        Assertions.assertEquals("123", currentAccount.getAccountNr());
        Assertions.assertEquals(branch, currentAccount.getBranch());
    }

    @Test
    public void savingsAccountGetterAndSetterShouldReturnProperValue() {
        Assertions.assertEquals("12", savingsAccount.getAccountNr());
        Assertions.assertEquals(branch, savingsAccount.getBranch());

        savingsAccount.setAccountNr("123");

        Assertions.assertEquals("123", savingsAccount.getAccountNr());
        Assertions.assertEquals(branch, savingsAccount.getBranch());
    }

//    @Test
//    public void generateBankStatementsShouldReturnNicelyFormattedOutput() {
//        account.deposit(20000);
//        account.withdraw(10000);
//        account.deposit(505);
//        Assertions.assertEquals("", account.generateBankStatements());
//    }
}

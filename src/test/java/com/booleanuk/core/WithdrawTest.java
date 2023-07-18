package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class WithdrawTest {
    private Branch branch;
    private Account account;
    private CurrentAccount currentAccount;
    private SavingsAccount savingsAccount;

    @BeforeEach
    public void setup() {
        branch = new Branch("PLWAW1", "Poland", "Warsaw");
        account = new Account("12", branch);
        currentAccount = new CurrentAccount("12", branch);
        savingsAccount = new SavingsAccount("12", branch);
    }

    @Test
    public void withdrawShouldCreateAndAddDepositToTransfers() {
        account.deposit(20000);

        Assertions.assertEquals(20000, account.calculateBalance());

        account.withdraw(5000);

        Assertions.assertEquals(15000, account.calculateBalance());
    }

    @Test
    public void withdrawWithOverdraftShouldThrowException() {
        currentAccount.deposit(20000);

        Assertions.assertEquals(20000, currentAccount.calculateBalance());
        Assertions.assertThrows(IllegalStateException.class, () -> currentAccount.withdraw(80000));
    }

    @Test
    public void withdrawWithOverdraftShouldThrowExceptionAtTheEnd() {
        currentAccount.deposit(20000);
        currentAccount.deposit(30000);
        currentAccount.deposit(1000);
        currentAccount.deposit(20000);
        currentAccount.withdraw(20000);
        currentAccount.deposit(32000);
        currentAccount.withdraw(200);
        System.out.println(currentAccount.calculateBalance());

        Assertions.assertThrows(IllegalStateException.class, () -> currentAccount.withdraw(800000000));
    }
}
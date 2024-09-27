package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DepositTest {
    private Account account;

    @BeforeEach
    public void setup() {
        Branch branch = new Branch("PLWAW1", "Poland", "Warsaw");
        account = new Account("12", branch);
        CurrentAccount currentAccount = new CurrentAccount("12", branch);
        SavingsAccount savingsAccount = new SavingsAccount("12", branch);
    }
    @Test
    public void depositShouldCreateAndAddDepositToTransfers() {
        Assertions.assertEquals(0, account.calculateBalance());

        account.deposit(20000);

        Assertions.assertEquals(20000, account.calculateBalance());
        Assertions.assertEquals(1, account.getTransfers().size());
    }

    @Test
    public void depositShouldAddAmountOfMoney() {
        Assertions.assertEquals(0, account.calculateBalance());

        account.deposit(20000);

        Assertions.assertEquals(20000, account.calculateBalance());

        account.deposit(50000);

        Assertions.assertEquals(70000, account.calculateBalance());
    }

    @Test
    public void depositShouldAddAmountOfMoneyAfterWithdraw() {
        Assertions.assertEquals(0, account.calculateBalance());

        account.deposit(20000);

        Assertions.assertEquals(20000, account.calculateBalance());

        account.withdraw(10000);

        Assertions.assertEquals(10000, account.calculateBalance());

        account.deposit(50000);

        Assertions.assertEquals(60000, account.calculateBalance());
    }
}

package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BankChallengeTest {
    @Test
    public void testDeposit() {
        Account _account = new Account(4, 10000.0);

        Assertions.assertEquals(Status.OK, _account.deposit(9000.0));
        Assertions.assertEquals(Status.EXCEEDED_BALANCE, _account.deposit(8000.0));
        Assertions.assertEquals(Status.OK, _account.deposit(1000.0));
        Assertions.assertEquals(Status.INVALID_NUMBER, _account.deposit(-100.0));

        Assertions.assertEquals(10000.0, _account.getBalance(), 0.0001);
    }

    @Test
    public void testWithdraw() {
        Account _account = new Account(4, 10000.0);

        _account.deposit(5000.0);

        Assertions.assertEquals(Status.INVALID_NUMBER, _account.withdraw(-100.0));

        Assertions.assertEquals(Status.OK, _account.withdraw(2000.0));
        Assertions.assertEquals(Status.BALANCE_TOO_SMALL, _account.withdraw(4000.0));


        Assertions.assertEquals(Status.OK, _account.withdraw(100.0));
        Assertions.assertEquals(Status.OK, _account.withdraw(100.0));
        Assertions.assertEquals(Status.OK, _account.withdraw(100.0));
        Assertions.assertEquals(Status.EXCEEDED_WITHDRAWAL_AMOUNT, _account.withdraw(100.0));

        Assertions.assertEquals(3700.0, _account.getBalance(), 0.0001);
    }
}

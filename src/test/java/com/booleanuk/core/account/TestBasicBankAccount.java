package com.booleanuk.core.account;

import com.booleanuk.core.account.BankAccount;
import com.booleanuk.core.account.BasicBankAccount;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestBasicBankAccount {
    @Test
    public void testDepositPositive() {
        double original = 100.20;
        double end = 200.70;
        double diff = end - original;

        BankAccount ba = new BasicBankAccount(original);
        double r = ba.deposit(diff);

        Assertions.assertEquals(end, r);
    }

    @Test
    public void testDepositZero() {
        double original = 100.20;

        BankAccount ba = new BasicBankAccount(original);
        double r = ba.deposit(0);

        Assertions.assertEquals(original, r);
    }

    @Test
    public void testDepositNegative() {
        double original = 100.20;

        BankAccount ba = new BasicBankAccount(original);
        double r = ba.deposit(-200);

        Assertions.assertEquals(original, r);
    }

    @Test
    public void testWithdrawPositive() {
        double original = 100.20;
        double end = 70.70;
        double diff = original - end;

        BankAccount ba = new BasicBankAccount(original);
        double r = ba.withdraw(diff);

        Assertions.assertEquals(end, r);
    }

    @Test
    public void testWithdrawZero() {
        double original = 100.20;

        BankAccount ba = new BasicBankAccount(100.20);
        double r = ba.withdraw(0);

        Assertions.assertEquals(original, r);
    }

    @Test
    public void testWithdrawNegative() {
        double original = 100.20;

        BankAccount ba = new BasicBankAccount(original);
        double r = ba.withdraw(-100);

        Assertions.assertEquals(original, r);
    }

    @Test
    public void testStatements() {

    }
}

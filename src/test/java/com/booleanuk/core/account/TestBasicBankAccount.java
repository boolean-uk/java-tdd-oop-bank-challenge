package com.booleanuk.core.account;

import com.booleanuk.core.statement.Statements;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class TestBasicBankAccount {
    @Test
    public void testDepositPositive() {
        double original = 100.20;
        double end = 200.70;
        double diff = end - original;

        BankAccount ba = new BasicBankAccount(original, new Statements());
        double r = ba.deposit(diff);

        Assertions.assertEquals(end, r);
    }

    @Test
    public void testDepositZero() {
        double original = 100.20;

        BankAccount ba = new BasicBankAccount(original, new Statements());
        double r = ba.deposit(0);

        Assertions.assertEquals(original, r);
    }

    @Test
    public void testDepositNegative() {
        double original = 100.20;

        BankAccount ba = new BasicBankAccount(original, new Statements());
        double r = ba.deposit(-200);

        Assertions.assertEquals(original, r);
    }

    @Test
    public void testWithdrawPositive() {
        double original = 100.20;
        double end = 70.70;
        double diff = original - end;

        BankAccount ba = new BasicBankAccount(original, new Statements());
        double r = ba.withdraw(diff);

        Assertions.assertEquals(end, r);
    }

    @Test
    public void testWithdrawZero() {
        double original = 100.20;

        BankAccount ba = new BasicBankAccount(100.20, new Statements());
        double r = ba.withdraw(0);

        Assertions.assertEquals(original, r);
    }

    @Test
    public void testWithdrawNegative() {
        double original = 100.20;

        BankAccount ba = new BasicBankAccount(original, new Statements());
        double r = ba.withdraw(-100);

        Assertions.assertEquals(original, r);
    }

    @Test
    public void testStatements() {
        LocalDate time = LocalDate.now();
        double balance = 100.20;
        double deposit = 40.20;
        double credit = 20.10;

        BankAccount ba = new BasicBankAccount(balance, new Statements());
        ba.deposit(deposit);
        ba.withdraw(credit);

        String expected = "      date||    credit||     debit||   balance||\n" +
                time + "||          ||      " + deposit + "||     " + balance + "||\n" +
                time + "||      " + credit + "||          " + "||     " + (balance + deposit) + "||\n";

        Assertions.assertEquals(expected, ba.statement());
    }
}

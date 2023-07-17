package com.booleanuk.core.account;

import com.booleanuk.core.bank.Bank;
import com.booleanuk.core.bank.BasicBank;
import com.booleanuk.core.statement.Statements;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

public class TestStatelessBasicBankAccount {
    BankAccount ba = new StatelessBasicBankAccount(new Statements());
    @Test
    public void testDepositPositive() {
        double r = ba.deposit(100);

        Assertions.assertEquals(100, r);
    }

    @Test
    public void testDepositZero() {
        double r = ba.deposit(0);

        Assertions.assertEquals(0, r);
    }

    @Test
    public void testDepositNegative() {
        double r = ba.deposit(-200);

        Assertions.assertEquals(0, r);
    }

    @Test
    public void testWithdrawPositive() {
        double r = ba.withdraw(100);

        // first need to deposit
        Assertions.assertEquals(0, r);

        ba.deposit(100.234);
        r = ba.withdraw(40.21);
        // first need to deposit
        Assertions.assertEquals(60.02, r);
    }

    @Test
    public void testWithdrawZero() {
        double r = ba.withdraw(0);

        Assertions.assertEquals(0, r);
    }

    @Test
    public void testWithdrawNegative() {
        double r = ba.withdraw(-100);

        Assertions.assertEquals(0, r);
    }

    @Test
    public void testStatements() {
        LocalDate time = LocalDate.now();
        double balance = 100.20;
        double deposit = 40.20;
        double credit = 20.10;

        ba.deposit(balance);
        ba.deposit(deposit);
        ba.withdraw(credit);

        String expected = "      date||    credit||     debit||   balance||\n" +
                time + "||          ||     " + balance + "||       " + 0.0 + "||\n" +
                time + "||          ||      " + deposit + "||     " + balance + "||\n" +
                time + "||      " + credit + "||          " + "||     " + (balance + deposit) + "||\n";

        Assertions.assertEquals(expected, ba.statement());
    }

    @Test
    public void testDeserveOverdraft() {
        // balance is 0, so i deserve overdraft of 100
        Assertions.assertTrue(ba.deserveOverdraft(100));

        double r = ba.withdraw(100);

        // withdrew 100, so balance is -100, so i dont deserver overdraft
        Assertions.assertFalse(ba.deserveOverdraft(100));

        SavingsBankAccount sa = new SavingsBankAccount(100, new Statements());
        // saving account doesnt deserver overdraft
        Assertions.assertFalse(sa.deserveOverdraft(100));
    }

    @Test
    public void testBranch() {
        Bank b = new BasicBank("Athens", 1000);

        b.add(ba);

        Assertions.assertEquals("Athens", ba.branch().location());
    }
}

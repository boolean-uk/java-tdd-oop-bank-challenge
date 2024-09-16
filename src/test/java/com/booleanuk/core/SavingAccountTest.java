package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Date;

public class SavingAccountTest {

    SavingAccount account;
    public SavingAccountTest() {
        account = new SavingAccount();
    }

    @Test
    public void depositWithPositiveAmountTest() {

        account.deposit(100);

        Assertions.assertEquals(100.00, account.getBalance());
        Assertions.assertEquals(1, account.getTransactions().size());
        account.deposit(100.55);
        Assertions.assertEquals(200.55, account.getBalance());
        account.deposit(100.44);
        Assertions.assertEquals(300.99, account.getBalance());
        Assertions.assertEquals(3,account.getTransactions().size());
    }

    @Test
    public void depositWith0OrNegativeAmountTest() {
        account.deposit(100.11);
        Assertions.assertEquals(100.11, account.getBalance());
        Assertions.assertEquals(1, account.getTransactions().size());

        account.deposit(0);
        account.deposit(-100.11);
        Assertions.assertEquals(100.11, account.getBalance());
        Assertions.assertEquals(1, account.getTransactions().size());

    }

    @Test
    public void withdrawWithPositiveAmountTest() {
        account.deposit(1000);

        account.withdraw(100);
        Assertions.assertEquals(900, account.getBalance());
        Assertions.assertEquals(2, account.getTransactions().size());
        account.withdraw(899.99);
        Assertions.assertEquals(0.01, account.getBalance());
        Assertions.assertEquals(3, account.getTransactions().size());
        account.withdraw(0.01);
        Assertions.assertEquals(0.00, account.getBalance());
        Assertions.assertEquals(4, account.getTransactions().size());
        account.withdraw(100);
        Assertions.assertEquals(0.00, account.getBalance());
        Assertions.assertEquals(4, account.getTransactions().size());
        account.generateBankStatement();
    }
    @Test
    public void withdrawWithZeroOrNegativeNumber() {
        account.deposit(100);
        account.withdraw(0);
        account.withdraw(-0.01);
        account.withdraw((-99));

        Assertions.assertEquals(100, account.getBalance());
        Assertions.assertEquals(1,account.getTransactions().size());
    }

    @Test
    public void canIOverdraftSavingAccountTest() {
        account.deposit(100);
        account.withdraw(100);
        Assertions.assertEquals(0, account.getBalance());
        Assertions.assertEquals(2,account.getTransactions().size());
        account.withdraw(0.01);
        Assertions.assertEquals(0, account.getBalance());
        Assertions.assertEquals(2,account.getTransactions().size());
        account.withdraw(50);
        Assertions.assertEquals(0, account.getBalance());
        Assertions.assertEquals(2,account.getTransactions().size());
    }

    @Test
    public void checkingIfInBankStatementDateIsSortedCorrectlyTest() {
        Date date = new Date("10/01/2023");
        Date date1 = new Date("15/01/2023");
        Date date2 = new Date("01/01/2023");
        Date date3 = new Date("24/01/2022");
        account.deposit(100, date);
        account.deposit(100, date1);

        Assertions.assertEquals(
                "date       || credit    || debit     || balance \n" +
                        "01/03/2024 || 100.00    ||           || 200.00 \n" +
                        "01/12/2023 || 100.00    ||           || 400.00 ",
                "date       || credit    || debit     || balance \n" +
                        "01/03/2024 || 100.00    ||           || 200.00 \n" +
                        "01/12/2023 || 100.00    ||           || 400.00 ");


        account.deposit(100, date2);
        account.deposit(100, date3);

        account.generateBankStatement();
    }
}

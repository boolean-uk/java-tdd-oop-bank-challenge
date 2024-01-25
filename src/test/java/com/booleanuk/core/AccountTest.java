package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class AccountTest {

    @Test
    public void depositWithdrawClearMethods() {
        Account account = new Account("AccountName1");

        Assertions.assertEquals(0.00, account.getBalance());
        Assertions.assertEquals(new ArrayList<BankStatement>(), account.getBankStatements());
        Assertions.assertTrue(account.clearBankStatements());
        Assertions.assertEquals(0, account.getBankStatements().size());

        Assertions.assertTrue(account.deposit(600.00));
        Assertions.assertFalse(account.withdraw(601.00));
        Assertions.assertTrue(account.withdraw(500.00));
        Assertions.assertEquals(100.00, account.getBalance());

        Assertions.assertEquals(2, account.getBankStatements().size());
    }

    @Test
    public void printBankStatementsFromArray() {

        Account account = new Account();

        Assertions.assertEquals(0.00, account.getBalance());
        Assertions.assertEquals(new ArrayList<BankStatement>(), account.getBankStatements());
        Assertions.assertTrue(account.deposit(500));
        Assertions.assertTrue(account.withdraw(100));

        LocalDate date = LocalDate.now();


        Assertions.assertEquals("\n    Date        Debit       Credit     Balance\n" +
                date +" ||          ||    500.0 ||     500.0\n" +
                date +" ||    500.0 ||          ||    2000.0\n", account.printBankStatements());

    }


}

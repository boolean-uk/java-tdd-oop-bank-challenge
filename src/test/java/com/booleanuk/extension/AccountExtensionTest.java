package com.booleanuk.extension;

import com.booleanuk.core.Account;
import com.booleanuk.core.Bank;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class AccountExtensionTest {
    @Test
    public void withdrawOverdraftAmountAndDateGivenWhenApporvedTest() {
        Bank bank = new Bank();
        Account account = new Account(bank);
        double amount = 500;
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate date = LocalDate.parse("01/12/2020", dateFormat);
        Assertions.assertEquals("Overdraft approved", account.withdrawOverdraft(amount, date, account.approveOverdraft(true)));
        Assertions.assertTrue(account.getDebitList().containsKey(date));
        Assertions.assertEquals(account.getDebitList().get(date).get(0), amount);
    }

    @Test
    public void withdrawOverdraftAmountAndDateGivenWhenNotApporvedTest() {
        Bank bank = new Bank();
        Account account = new Account(bank);
        double amount = 500;
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate date = LocalDate.parse("01/12/2020", dateFormat);
        Assertions.assertEquals("Overdraft rejected", account.withdrawOverdraft(amount, date, account.approveOverdraft(false)));
        Assertions.assertTrue(!account.getDebitList().containsKey(date));
    }

    @Test
    public void withdrawOverdraftAmountGivenWhenApprovedTest() {
        Bank bank = new Bank();
        Account account = new Account(bank);
        double amount = 500;
        Assertions.assertEquals("Overdraft approved", account.withdrawOverdraft(amount, account.approveOverdraft(true)));
        Assertions.assertTrue(account.getDebitList().containsKey(LocalDate.now()));
        Assertions.assertEquals(account.getDebitList().get(LocalDate.now()).get(0), amount);
    }

    @Test
    public void withdrawOverdraftAmountGivenWhenNotApprovedTest() {
        Bank bank = new Bank();
        Account account = new Account(bank);
        double amount = 500;
        Assertions.assertEquals("Overdraft rejected", account.withdrawOverdraft(amount, account.approveOverdraft(false)));
        Assertions.assertTrue(!account.getDebitList().containsKey(LocalDate.now()));
    }
}

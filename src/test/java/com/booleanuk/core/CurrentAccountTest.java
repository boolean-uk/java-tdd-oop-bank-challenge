package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CurrentAccountTest {

    @Test
    public void testDeposit() {
        Account a = new CurrentAccount("1", "0000", "01");
        Assertions.assertEquals(0, a.calculateBalance());
        Assertions.assertEquals(String.format("The 1.00 money is now deposited to the account 01.%n"), a.deposit(100));
        Assertions.assertEquals(100, a.calculateBalance());
    }

    @Test
    public void testWithdraw() {
        CurrentAccount a = new CurrentAccount("1", "0000", "01");
        a.deposit(10000);
        Assertions.assertEquals(10000, a.calculateBalance());
        Assertions.assertEquals(String.format("50.00 money has been withdrawn from your account.%n"), a.withdraw(5000));
        Assertions.assertEquals(5000, a.calculateBalance());
    }

    @Test
    public void testWithdrawTooMuch() {
        CurrentAccount a = new CurrentAccount("1", "0000", "01");
        Assertions.assertEquals(0, a.calculateBalance());
        Assertions.assertEquals(String.format("Your balance of 0.00 is too low to withdraw a sum of 50.00.%n"), a.withdraw(5000));
        Assertions.assertEquals(0, a.calculateBalance());
    }

    @Test
    public void testTransferWithoutMoney() {
        Account a = new CurrentAccount("1", "0000", "01");
        Account b = new CurrentAccount("1", "0000", "02");
        Controller.depositables.put("01", a);
        Controller.depositables.put("02", b);
        Assertions.assertEquals(0, a.calculateBalance());
        Assertions.assertEquals(String.format("Your balance of 0.00 is too low to send a sum of 50.00.%n"), a.transfer("02", 5000), "");
        Assertions.assertEquals(0, b.calculateBalance());
        Assertions.assertEquals(0, a.calculateBalance());
        Assertions.assertEquals(0, a.getTransactions().size());
        Assertions.assertEquals(0, b.getTransactions().size());
    }

    @Test
    public void testTransferToCurrentAccount() {
        Account a = new CurrentAccount("1", "0000", "01");
        Account b = new CurrentAccount("1", "0000", "02");
        Controller.depositables.put("01", a);
        Controller.depositables.put("02", b);
        a.deposit(10000);
        Assertions.assertEquals(10000, a.calculateBalance());
        Assertions.assertEquals(String.format("50.00 money has now been transferred from account 01 to account 02.%n"), a.transfer("02", 5000), "");
        Assertions.assertEquals(5000, b.calculateBalance());
        Assertions.assertEquals(5000, a.calculateBalance());
        Assertions.assertEquals(2, a.getTransactions().size());
        Assertions.assertEquals(1, b.getTransactions().size());
    }

    @Test
    public void testTransferToSavingsAccount() {
        Account a = new CurrentAccount("1", "0000", "01");
        Account b = new SavingsAccount("1", "0000", "02");
        Controller.depositables.put("01", a);
        Controller.depositables.put("02", b);
        a.deposit(10000);
        Assertions.assertEquals(10000, a.calculateBalance());
        Assertions.assertEquals(String.format("50.00 money will be transferred from account 01 to account 02 in three (3) days.%n"), a.transfer("02", 5000), "");
        Assertions.assertEquals(0, b.calculateBalance());
        Assertions.assertEquals(5000, b.calculateBalance(4));
        Assertions.assertEquals(10000, a.calculateBalance());
        Assertions.assertEquals(5000, a.calculateBalance(4));
        Assertions.assertEquals(2, a.getTransactions().size());
        Assertions.assertEquals(1, b.getTransactions().size());
    }

}
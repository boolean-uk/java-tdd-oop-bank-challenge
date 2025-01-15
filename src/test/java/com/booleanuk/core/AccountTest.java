package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AccountTest {
    @Test
    public void depositToAccount() {
        CurrentAccount currentAccount = new CurrentAccount(123456789);

        currentAccount.deposit(200);

        Assertions.assertEquals(200, currentAccount.getBalance());

    }

    @Test
    public void withdrawToAccount() {
        CurrentAccount currentAccount = new CurrentAccount(123456789);

        currentAccount.deposit(1000);
        currentAccount.withdraw(200);

        Assertions.assertEquals(800, currentAccount.getBalance());

    }

    @Test
    public void testPrintedOutBankStatement() {
        CurrentAccount acc = new CurrentAccount(123456789);

        String output = String.format("%1$10s %2$10s %3$10s %4$10s %5$10s %6$10s %7$10s","Date", "||","Credit","||","Debit","||","Balance\n");
        output += String.format("%1$10s %2$10s %3$10s %4$10s %5$10s %6$10s %7$10s","01/15/2025", "||","1000.0","||","","||","2000.0\n");
        output += String.format("%1$10s %2$10s %3$10s %4$10s %5$10s %6$10s %7$10s","01/15/2025", "||","","||","500.0","||","1000.0\n");
        output += String.format("%1$10s %2$10s %3$10s %4$10s %5$10s %6$10s %7$10s","01/15/2025", "||","1500.0","||","","||","1500.0\n");

        System.out.println(output);
        StringBuilder sb = new StringBuilder();

        sb.append(output);

        acc.deposit(1500);
        acc.withdraw(500);
        acc.deposit(1000);

        StringBuilder sb2 = new StringBuilder();
        sb2.append(acc.bankStatement());

        Assertions.assertEquals(0, sb.compareTo(sb2));
    }

    @Test
    public void testCalculatingBalance() {
        CurrentAccount currentAccount = new CurrentAccount(123456789);

        currentAccount.deposit(1500);
        currentAccount.withdraw(500);
        currentAccount.deposit(1000);

        Assertions.assertEquals(2000, currentAccount.calculateBalance());

    }
}

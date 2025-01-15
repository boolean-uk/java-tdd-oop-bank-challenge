package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AccountTest {
    @Test
    public void depositToAccount() {
        CurrentAccount currentAccount = new CurrentAccount(500);

        currentAccount.deposit(currentAccount,200);

        Assertions.assertEquals(700, currentAccount.getBalance());

    }

    @Test
    public void withdrawToAccount() {
        CurrentAccount currentAccount = new CurrentAccount(500);

        currentAccount.withdraw(currentAccount,200);

        Assertions.assertEquals(300, currentAccount.getBalance());

    }

    @Test
    public void testPrintedOutBankStatement() {
        CurrentAccount acc = new CurrentAccount(500);

        String output = String.format("%1$10s %2$10s %3$10s %4$10s %5$10s %6$10s %7$10s","Date", "||","Credit","||","Debit","||","Balance\n");
        output += String.format("%1$10s %2$10s %3$10s %4$10s %5$10s %6$10s %7$10s","01/15/2025", "||","1000","||","","||","2500\n");
        output += String.format("%1$10s %2$10s %3$10s %4$10s %5$10s %6$10s %7$10s","01/15/2025", "||","1500","||","","||","1500\n");
        output += String.format("%1$10s %2$10s %3$10s %4$10s %5$10s %6$10s %7$10s","01/15/2025", "||","","||","500","||","0\n");
        
        System.out.println(output);

        Assertions.assertEquals(output, acc.bankStatement());
    }
}

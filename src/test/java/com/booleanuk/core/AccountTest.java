package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class AccountTest {

    //Core requirements
    //
    @Test
    public void generateBankStatement(){
        Account account = new Account("Test");
        account.deposit(100f);
        account.withdraw(30f);
        account.generateBankStatement();
        account.printBankStatement();

        //Remember to change date when testing
        String bankStatement =
                "[Date        ||     Amount ||     Balance, " +
                "----------------------------------------, " +
                "26/08/2024  ||    £100.00 ||     £100.00, " +
                "26/08/2024  ||    -£30.00 ||      £70.00]";

        Assertions.assertEquals(bankStatement,account.getBankStatement().toString());
    }

    @Test
    public void depositFunds(){
        Account account = new Account("Test");
        account.deposit(100);
        Assertions.assertEquals(String.format("%.2f", 100f), String.format("%.2f", (float) account.getBalance()/100f));
    }

    @Test
    public void withdrawFunds(){
        Account account = new Account("Test");
        Assertions.assertEquals("Not enough funds.", account.withdraw(100));
        account.deposit(100);
        Assertions.assertEquals("Funds withdrawed from account.", account.withdraw(50));
        Assertions.assertEquals(String.format("%.2f", 50f), String.format("%.2f", (float) account.getBalance()/100));
    }

    // Extension requirements
    //
    // User story 1: Account balance calculated on transaction history
    @Test
    public void calculateAccountBalance(){
        Account account = new Account("Test");
        Assertions.assertEquals(0, account.getBalance());
        account.deposit(100);
        Assertions.assertEquals(String.format("%.2f", 100f), String.format("%.2f", (float) account.getBalance()/100));
    }
}

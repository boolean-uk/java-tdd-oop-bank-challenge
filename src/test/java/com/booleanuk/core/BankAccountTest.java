package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class BankAccountTest {

    @Test
    public void userCreatesAccountTypes() {
        CurrentAccount currentAccount = new CurrentAccount();
        String banktype1 = currentAccount.getBankType();
        Assertions.assertEquals("current", banktype1);

        SavingsAccount savingsaccount = new SavingsAccount();
        String banktype2 = savingsaccount.getBankType();
        Assertions.assertEquals("savings", banktype2);
    }

    @Test

    public void userAddsMoneyToAccount() {
        CurrentAccount currentAccount = new CurrentAccount(1000.00);
        currentAccount.deposit(400.00);
        double newBalance = currentAccount.balance;

        Assertions.assertEquals(1400.00, newBalance);


        SavingsAccount savingsaccount = new SavingsAccount(2000);
        savingsaccount.deposit(500.00);
        double newBalance2 = savingsaccount.balance;

        Assertions.assertEquals(2500.00, newBalance2);


    }

    @Test
    public void userWithdrawsMoneyFromAccounts() {
        CurrentAccount currentAccount = new CurrentAccount(1000.00);
        currentAccount.withdraw(400.00);
        double newBalance = currentAccount.balance;

        Assertions.assertEquals(600.00, newBalance);


        SavingsAccount savingsaccount = new SavingsAccount(5000);
        savingsaccount.withdraw(850.00);
        double newBalance2 = savingsaccount.balance;

        Assertions.assertEquals(4150.00, newBalance2);


    }

    @Test
    public void checktheDate() {
        CurrentAccount currentAccount = new CurrentAccount(1000.00);
        String dateFromClass = currentAccount.getDate();

        SimpleDateFormat datePatternSetter = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        String currentdateformatter = datePatternSetter.format(date);

        Assertions.assertEquals(currentdateformatter, dateFromClass);


    }


}

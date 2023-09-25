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
        String currentDateFormatter = datePatternSetter.format(date);

        Assertions.assertEquals(currentDateFormatter, dateFromClass);

        SavingsAccount savingsaccount = new SavingsAccount(5000);
        String dateFromClass2 = savingsaccount.getDate();

        SimpleDateFormat datePatternSetter2 = new SimpleDateFormat("dd/MM/yyyy");
        Date date2 = new Date();
        String currentDateFormatterTwo = datePatternSetter2.format(date2);

        Assertions.assertEquals(currentDateFormatterTwo, dateFromClass2);


    }

    @Test
    public void checkTranferTable() {
        double startBalance = 5000;
        CurrentAccount currentAccount = new CurrentAccount(startBalance);
        double depositOne = 1200.00;
        double depositTwo = 400.00;
        double depositThree = 800.00;

        double withdrawOne = 600.00;
        double withdrawTwo = 200.00;

        //Deposit 1
        currentAccount.deposit(depositOne);
        //Withdraw 1
        currentAccount.withdraw(withdrawOne);
        //Deposit 2 & 3
        currentAccount.deposit(depositTwo);
        currentAccount.deposit(depositThree);
        //Withdraw 2
        currentAccount.withdraw(withdrawTwo);

        double newBalanceTest = startBalance + depositOne + depositTwo + depositThree - withdrawOne - withdrawTwo;

        Assertions.assertEquals(newBalanceTest, currentAccount.balance);
        /*
        Didn't really know how to test for the table output
        The test checks for the output of the withdrawn + deposited amounts.
        I will show the table as a System.out.println
                 */

    }
}

package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

public class CurrentAccountTest {

    @Test
    public void depositToAccount(){
        Branch branch = new Branch("Gothenburg");
        BankAccount currentAccount = new CurrentAccount(branch);
        LocalDateTime localDateTime1 = LocalDateTime.of(2020, 4, 15, 14, 46, 55);
        currentAccount.deposit(5000, localDateTime1);


        Assertions.assertEquals(5000, currentAccount.getBalance());
    }

    @Test
    public void withdrawFromAccount(){
        Branch branch = new Branch("Gothenburg");
        BankAccount currentAccount = new CurrentAccount(branch);
        LocalDateTime localDateTime1 = LocalDateTime.of(2020, 4, 15, 14, 46, 55);
        LocalDateTime localDateTime2 = LocalDateTime.of(2021, 5, 13, 11, 52, 25);
        currentAccount.deposit(5000, localDateTime1);
        currentAccount.withdraw(4550, localDateTime2);


        Assertions.assertEquals(450, currentAccount.getBalance());
    }

    @Test
    public void generateStatementWithNoTransactions(){
        Branch branch = new Branch("Gothenburg");
        BankAccount currentAccount = new CurrentAccount(branch);

        Assertions.assertEquals("No transaction history found",currentAccount.generateStatement());
    }

    @Test
    public void generateStatementWithTransactions(){
        Branch branch = new Branch("Gothenburg");
        BankAccount currentAccount = new CurrentAccount(branch);

        LocalDateTime localDateTime1 = LocalDateTime.of(2020, 4, 15, 14, 46, 55);
        LocalDateTime localDateTime2 = LocalDateTime.of(2021, 5, 13, 11, 52, 25);
        currentAccount.deposit(5000, localDateTime1);
        currentAccount.withdraw(450, localDateTime2);

        String statement = currentAccount.generateStatement();

        Assertions.assertEquals("Date: " + localDateTime1 + " || amount: " + "+" + 5000.0 +
                        " || balance: " + 5000.0 + "\n" +
                        "Date: " + localDateTime2 + " || amount: " + "-" + 450.0 + " || balance: " + 4550.0 + "\n"
                ,statement);

    }


    @Test
    public void requestOverdraftOverTheLimit(){
        Branch branch = new Branch("Gothenburg");
        BankAccount currentAccount = new CurrentAccount(branch);

        LocalDateTime localDateTime1 = LocalDateTime.of(2020, 4, 15, 14, 46, 55);
        LocalDateTime localDateTime2 = LocalDateTime.of(2021, 5, 13, 11, 52, 25);
        currentAccount.deposit(500, localDateTime1);
        currentAccount.withdraw(850, localDateTime2);

        Assertions.assertEquals(-350, currentAccount.getBalance());

    }

    @Test
    public void requestOverdraftUnderTheLimit(){
        Branch branch = new Branch("Gothenburg");
        BankAccount currentAccount = new CurrentAccount(branch);

        LocalDateTime localDateTime1 = LocalDateTime.of(2020, 4, 15, 14, 46, 55);
        LocalDateTime localDateTime2 = LocalDateTime.of(2021, 5, 13, 11, 52, 25);
        currentAccount.deposit(500, localDateTime1);
        currentAccount.withdraw(1100, localDateTime2);

        Assertions.assertEquals(500, currentAccount.getBalance());

    }
}

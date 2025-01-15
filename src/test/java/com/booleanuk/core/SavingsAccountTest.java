package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class SavingsAccountTest {

    @Test
    public void depositToAccount(){
        Branch branch = new Branch("Gothenburg");
        BankAccount savingsAccount = new SavingsAccount(branch);
        LocalDateTime localDateTime1 = LocalDateTime.of(2020, 4, 15, 14, 46, 55);
        savingsAccount.deposit(5000, localDateTime1);


        Assertions.assertEquals(500, savingsAccount.getBalance());
    }

    @Test
    public void withdrawFromAccount(){
        Branch branch = new Branch("Gothenburg");
        BankAccount savingsAccount = new SavingsAccount(branch);
        LocalDateTime localDateTime1 = LocalDateTime.of(2020, 4, 15, 14, 46, 55);
        LocalDateTime localDateTime2 = LocalDateTime.of(2021, 5, 13, 11, 52, 25);
        savingsAccount.deposit(5000, localDateTime1);
        savingsAccount.withdraw(450, localDateTime2);


        Assertions.assertEquals(50, savingsAccount.getBalance());
    }

    @Test
    public void generateStatementWithNoTransactions(){
        Branch branch = new Branch("Gothenburg");
        BankAccount savingsAccount = new SavingsAccount(branch);

        Assertions.assertEquals("No transaction history found",savingsAccount.generateStatement());
    }

    @Test
    public void generateStatementWithTransactions(){
        Branch branch = new Branch("Gothenburg");
        BankAccount savingsAccount = new SavingsAccount(branch);

        LocalDateTime localDateTime1 = LocalDateTime.of(2020, 4, 15, 14, 46, 55);
        LocalDateTime localDateTime2 = LocalDateTime.of(2021, 5, 13, 11, 52, 25);
        savingsAccount.deposit(5000, localDateTime1);
        savingsAccount.withdraw(450, localDateTime2);

        ArrayList<String> statement = savingsAccount.generateStatement();

        Assertions.assertEquals(" ",statement);

    }

    @Test
    public void requestOverdraftOverTheLimit(){
        Branch branch = new Branch("Gothenburg");
        BankAccount savingsAccount = new SavingsAccount(branch);

        LocalDateTime localDateTime1 = LocalDateTime.of(2020, 4, 15, 14, 46, 55);
        LocalDateTime localDateTime2 = LocalDateTime.of(2021, 5, 13, 11, 52, 25);
        currentAccount.deposit(500, localDateTime1);
        currentAccount.withdraw(850, localDateTime2);

        Assertions.assertEquals(-250, savingsAccount.getBalance());

    }

    @Test
    public void requestOverdraftUnderTheLimit(){
        Branch branch = new Branch("Gothenburg");
        BankAccount savingsAccount = new SavingsAccount(branch);

        LocalDateTime localDateTime1 = LocalDateTime.of(2020, 4, 15, 14, 46, 55);
        LocalDateTime localDateTime2 = LocalDateTime.of(2021, 5, 13, 11, 52, 25);
        currentAccount.deposit(500, localDateTime1);
        currentAccount.withdraw(1100, localDateTime2);

        Assertions.assertEquals(500, savingsAccount.getBalance());

    }
}
